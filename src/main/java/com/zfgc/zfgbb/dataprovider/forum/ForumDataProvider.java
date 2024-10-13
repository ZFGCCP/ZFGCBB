package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.BoardDao;
import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.CategoryDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.CategoryDbo;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.model.forum.Board;
import com.zfgc.zfgbb.model.forum.Category;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.users.Permission;
import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;

@Repository
public class ForumDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CategoryDataProvider categoryDataProvider;
	
	@Autowired
	private ThreadDao threadDao;
	
	@Autowired
	private ThreadDataProvider threadDataProvider;
	
	@Autowired
	private BoardPermissionViewDao boardPermissionDao;
	
	public Forum getForum(Integer boardId, Integer pageNo, Integer threadsPerPage) {
		Forum forum = new Forum();
		
		BoardDbo boardDbo = boardDao.get(boardId);
		forum.setBoardName(boardDbo.getBoardName());
		
		CategoryDboExample exC = new CategoryDboExample();
		exC.createCriteria().andParentBoardIdEqualTo(boardId);
		List<Category> categories = categoryDataProvider.getCategories(exC);

		List<Thread> unstickyThreads = threadDataProvider.getThreadsByBoardId(boardId, pageNo, threadsPerPage, false);
		List<Thread> stickyThreads = threadDataProvider.getThreadsByBoardId(boardId, null, null, true);
	
		forum.setThreads(unstickyThreads);
		forum.setStickyThreads(stickyThreads);
		forum.setCategories(categories);
		forum.setCategoryId(boardDbo.getCategoryId());
		
		//load up permissions for the board
		forum.setBoardPermissions(getBoardPermissions(boardId));
		
		ThreadDboExample threadEx = new ThreadDboExample();
		threadEx.createCriteria().andBoardIdEqualTo(boardId).andPinnedFlagEqualTo(false);
		Long threadCount = threadDao.getMapper().countByExample(threadEx);
		forum.setThreadCount(threadCount);
		

		return forum;
	}
	
	public List<Permission> getBoardPermissions(Integer boardId){
		BoardPermissionViewDboExample bEx = new BoardPermissionViewDboExample();
		bEx.createCriteria().andBoardIdEqualTo(boardId);
		return super.convertDboListToModel(boardPermissionDao.get(bEx), Permission.class);
	}
	
}