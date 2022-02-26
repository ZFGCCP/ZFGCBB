package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.zfgbb.BoardDao;
import com.zfgc.zfgbb.dao.zfgbb.CategoryDao;
import com.zfgc.zfgbb.dao.zfgbb.ThreadDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.zfgbb.BoardDbo;
import com.zfgc.zfgbb.dbo.zfgbb.BoardDboExample;
import com.zfgc.zfgbb.dbo.zfgbb.CategoryDbo;
import com.zfgc.zfgbb.dbo.zfgbb.CategoryDboExample;
import com.zfgc.zfgbb.dbo.zfgbb.ThreadDboExample;
import com.zfgc.zfgbb.model.forum.Board;
import com.zfgc.zfgbb.model.forum.Category;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Thread;

@Repository
public class ForumDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ThreadDao threadDao;
	
	public Forum getForum(Integer boardId) {
		Forum forum = new Forum();
		
		BoardDbo boardDbo = boardDao.get(boardId);
		forum.setBoardName(boardDbo.getBoardName());
		
		CategoryDboExample exC = new CategoryDboExample();
		exC.createCriteria().andParentBoardIdEqualTo(boardId);
		List<Category> categories = super.convertDboListToModel(categoryDao.get(exC), Category.class);
		
		categories.forEach(cat ->{
			BoardDboExample ex = new BoardDboExample();
			ex.createCriteria().andCategoryIdEqualTo(cat.getCategoryId());
			cat.setBoards(convertDboListToModel(boardDao.get(ex), Board.class));
		});
		
		ThreadDboExample exT = new ThreadDboExample();
		exT.createCriteria().andBoardIdEqualTo(boardId);
		List<Thread> unstickyThreads = super.convertDboListToModel(threadDao.get(exT), Thread.class);
		exT.createCriteria().andPinnedFlagEqualTo(true);
		List<Thread> stickyThreads = super.convertDboListToModel(threadDao.get(exT), Thread.class);
	
		forum.setThreads(unstickyThreads);
		forum.setStickyThreads(stickyThreads);
		forum.setCategories(categories);
		return forum;
	}
	
}