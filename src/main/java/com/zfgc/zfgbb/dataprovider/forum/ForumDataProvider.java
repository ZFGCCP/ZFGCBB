package com.zfgc.zfgbb.dataprovider.forum;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.BoardDao;
import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.CategoryDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.BoardSummaryViewDboExample;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.dbo.ChildBoardViewDboExample;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.mappers.BoardSummaryViewDboMapper;
import com.zfgc.zfgbb.mappers.ChildBoardViewDboMapper;
import com.zfgc.zfgbb.model.forum.Board;
import com.zfgc.zfgbb.model.forum.BoardSummary;
import com.zfgc.zfgbb.model.forum.Category;
import com.zfgc.zfgbb.model.forum.ChildBoard;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.users.Permission;

@Repository
public class ForumDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ThreadDao threadDao;
	
	@Autowired
	private ThreadDataProvider threadDataProvider;
	
	@Autowired
	private BoardPermissionViewDao boardPermissionDao;
	
	@Autowired
	private BoardSummaryViewDboMapper boardSummaryMapper;
	
	@Autowired
	private ChildBoardViewDboMapper childBoardMapper;
	
	public Board getBoard(Integer boardId, Integer pageNo, Integer threadsPerPage) {
		BoardDbo boardDbo = boardDao.get(boardId);
		Board board = mapper.map(boardDbo, Board.class);
		
		List<Thread> unstickyThreads = threadDataProvider.getThreadsByBoardId(boardId, pageNo, threadsPerPage, false);
		List<Thread> stickyThreads = threadDataProvider.getThreadsByBoardId(boardId, null, null, true);
		
		board.setStickyThreads(stickyThreads);
		board.setUnStickyThreads(unstickyThreads);
		
		ThreadDboExample threadEx = new ThreadDboExample();
		threadEx.createCriteria().andBoardIdEqualTo(boardId).andPinnedFlagEqualTo(false);
		Long threadCount = threadDao.getMapper().countByExample(threadEx);
		board.setThreadCount(threadCount);

		board.setChildBoards(getBoardSummaries(board.getBoardId()));
		
		return board;
	}
	
	private List<BoardSummary> getBoardSummaries(Integer parentBoardId){
		return getBoardSummaries(Arrays.asList(parentBoardId));
	}
	
	private List<BoardSummary> getBoardSummaries(List<Integer> parentBoardId){
		BoardSummaryViewDboExample bEx = new BoardSummaryViewDboExample();
		bEx.createCriteria().andParentBoardIdIn(parentBoardId);
		List<BoardSummary> result = (boardSummaryMapper.selectByExample(bEx).stream().map(b -> mapper.map(b, BoardSummary.class)).collect(Collectors.toList()));
		
		ChildBoardViewDboExample cEx = new ChildBoardViewDboExample();
		cEx.createCriteria().andParentBoardIdIn(parentBoardId);
		
		Map<Integer, List<ChildBoard>> childBoards = childBoardMapper.selectByExample(cEx).stream()
																					.map(c -> mapper.map(c, ChildBoard.class))
																					.collect(Collectors.groupingBy(ChildBoard::getParentBoardId));
		
		result.forEach(bs -> {
			bs.setChildBoards(childBoards.get(bs.getBoardId()));
		});
		
		
		return result;
	}
	
	private List<BoardSummary> getBoardSummariesByCategory(List<Integer> categoryId){
		BoardSummaryViewDboExample bEx = new BoardSummaryViewDboExample();
		bEx.createCriteria().andCategoryIdIn(categoryId);
		List<BoardSummary> result = (boardSummaryMapper.selectByExample(bEx).stream().map(b -> mapper.map(b, BoardSummary.class)).collect(Collectors.toList()));
		
		if(!result.isEmpty()) {
			ChildBoardViewDboExample cEx = new ChildBoardViewDboExample();
			cEx.createCriteria().andParentBoardIdIn(result.stream().map(BoardSummary::getBoardId).collect(Collectors.toList()));
			
			Map<Integer, List<ChildBoard>> childBoards = childBoardMapper.selectByExample(cEx).stream()
																						.map(c -> mapper.map(c, ChildBoard.class))
																						.collect(Collectors.groupingBy(ChildBoard::getParentBoardId));
			
			result.forEach(bs -> {
				bs.setChildBoards(childBoards.get(bs.getBoardId()));
			});
		}
		
		
		return result;
	}
	
	public Forum getForum() {
		Forum forum = new Forum();
		
		BoardDbo boardDbo = boardDao.get(0);
		forum.setBoardName(boardDbo.getBoardName());

		List<Category> categories = getCategories(0);

		forum.setCategories(categories);
		
		//load up permissions for the board
		forum.setBoardPermissions(getBoardPermissions(0));
		
		return forum;
	}
	
	public List<Category> getCategories(Integer parentBoardId){
		CategoryDboExample exC = new CategoryDboExample();
		exC.createCriteria().andParentBoardIdEqualTo(parentBoardId);
		List<Category> categories = super.convertDboListToModel(categoryDao.get(exC), Category.class);
		
		Map<Integer, List<BoardSummary>> summaries = getBoardSummaries(Arrays.asList(parentBoardId)).stream().filter(x -> x.getCategoryId() != null).collect(Collectors.groupingBy(BoardSummary::getCategoryId));
		
		categories.forEach(cat ->{
			cat.setBoards(summaries.get(cat.getCategoryId()));
		});
		
		return categories;
	}
	
	public List<Permission> getBoardPermissions(Integer boardId){
		BoardPermissionViewDboExample bEx = new BoardPermissionViewDboExample();
		bEx.createCriteria().andBoardIdEqualTo(boardId);
		return super.convertDboListToModel(boardPermissionDao.get(bEx), Permission.class);
	}
	
	public List<Board> getBoardsByParent(Integer parentBoardId){
		BoardDboExample bEx = new BoardDboExample();
		bEx.createCriteria().andParentBoardIdEqualTo(parentBoardId);
		
		List<Board> result = super.convertDboListToModel(boardDao.get(bEx), Board.class);
		result.forEach(b -> {
			ThreadDboExample tEx = new ThreadDboExample();
			tEx.createCriteria().andBoardIdEqualTo(b.getBoardId());
			
			b.setThreadCount(threadDao.getMapper().countByExample(tEx));
		});
		
		return result;
		
	}
	
}