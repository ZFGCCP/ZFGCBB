package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;
import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dao.forum.PollDao;
import com.zfgc.zfgbb.dao.forum.PollQuestionDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.LatestMessageInThreadViewDbo;
import com.zfgc.zfgbb.dbo.LatestMessageInThreadViewDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.dbo.PollDbo;
import com.zfgc.zfgbb.dbo.PollDboExample;
import com.zfgc.zfgbb.dbo.PollQuestionDbo;
import com.zfgc.zfgbb.dbo.PollQuestionDboExample;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.mappers.LatestMessageInThreadViewDboMapper;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.LatestMessage;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.model.forum.Poll;
import com.zfgc.zfgbb.model.forum.PollQuestion;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.forum.ThreadSplit;
import com.zfgc.zfgbb.model.users.Permission;

@Repository
public class ThreadDataProvider extends AbstractDataProvider {

	@Autowired
	private ThreadDao threadDao;
	
	@Autowired
	private MessageDataProvider messageDataProvider;
	
	@Autowired
	private BoardPermissionViewDao boardPermissionDao;
	
	@Autowired
	private PollDao pollDao;
	
	@Autowired
	private PollQuestionDao pollQuestionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LatestMessageInThreadViewDboMapper latestMessageMapper;
	
	public Thread getThread(Integer threadId, Integer page, Integer count) {
		ThreadDbo threadDb = threadDao.get(threadId);
		Thread result = null;
		if(threadDb != null) {
			result = mapper.map(threadDb, Thread.class);
			
			//get messages
			result.setMessages(super.convertDboListToModel(messageDataProvider.getMessagesForThread(threadId, page, count), Message.class));
			
			//get permissions for the parent board
			result.setBoardPermissions(getBoardPermissions(result.getBoardId()));
			
			//get poll info
			result.setPollInfo(getPollInfo(threadId));
		}
		return result;
	}
	
	public Poll getPollInfo(Integer threadId) {
		PollDboExample pollEx = new PollDboExample();
		pollEx.createCriteria().andThreadIdEqualTo(threadId);
		PollDbo pollDb = pollDao.get(pollEx).stream().findFirst().orElse(null);
		Poll result = null;
		if(pollDb != null) {
			result = mapper.map(pollDb, Poll.class);
			
			PollQuestionDboExample ex = new PollQuestionDboExample();
			ex.createCriteria().andPollIdEqualTo(result.getId());
			
			List<PollQuestionDbo> answers = pollQuestionDao.get(ex);
			result.setAnswers(super.convertDboListToModel(answers, PollQuestion.class));
		}
		
		return result;
	}
	
	public List<Thread> getThreadsByBoardId(Integer boardId, Boolean sticky){
		ThreadDboExample exT = new ThreadDboExample();
		exT.createCriteria().andBoardIdEqualTo(boardId).andPinnedFlagEqualTo(sticky);
		
		List<Thread> result = super.convertDboListToModel(threadDao.get(exT), Thread.class);
		
		result.forEach(th -> {
			th.setCreatedUser(super.mapper.map(userDao.get(th.getCreatedUserId()), User.class));
			th.setPostCount(messageDataProvider.getTotalPostsInThread(th.getThreadId()).intValue());
			
			LatestMessageInThreadViewDboExample ex = new LatestMessageInThreadViewDboExample(); 
			ex.createCriteria().andThreadIdEqualTo(th.getThreadId());
			LatestMessageInThreadViewDbo latestDbo = latestMessageMapper.selectByExample(ex).stream().findFirst().orElse(null);
			if(latestDbo != null) {
				th.setLatestMessage(mapper.map(latestDbo, LatestMessage.class));
			}
		});
		
		return result;
	}
	
	public Thread getThread(Integer threadId) {
		ThreadDbo threadDb = threadDao.get(threadId);
		Thread result = null;
		if(threadDb != null) {
			result = mapper.map(threadDao.get(threadId), Thread.class);
			
			//get permissions for the parent board
			result.setBoardPermissions(getBoardPermissions(result.getBoardId()));
		}
		
		return result;
	}
	
	public Thread saveThread(Thread thread) {
		ThreadDbo threadDbo = mapper.map(thread, ThreadDbo.class);
		
		//create the thread dbo first
		threadDbo = threadDao.save(threadDbo);
		thread.setThreadId(threadDbo.getThreadId());
		thread.setCreatedTs(threadDbo.getCreatedTime());
		thread.setUpdatedTs(threadDbo.getUpdatedTime());
		
		if(thread.getPollInfo() != null) {
			PollDbo poll = mapper.map(thread.getPollInfo(), PollDbo.class);
			pollDao.save(poll);
			
			thread.getPollInfo().getAnswers().forEach(ans -> {
				ans.setPollId(poll.getPollId());
				PollQuestionDbo answerDb = mapper.map(ans, PollQuestionDbo.class);
				pollQuestionDao.save(answerDb);
			});
		}
		
		return getThread(thread.getId());
	}
	
	public List<Permission> getBoardPermissions(Integer boardId){
		BoardPermissionViewDboExample bEx = new BoardPermissionViewDboExample();
		bEx.createCriteria().andBoardIdEqualTo(boardId);
		return super.convertDboListToModel(boardPermissionDao.get(bEx), Permission.class);
	}
	
	public void deleteThread(Integer threadId) {
		messageDataProvider.deleteMessagesForThread(threadId);
		ThreadDboExample ex = new ThreadDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		threadDao.delete(ex);
	}
	
	public Thread splitThread(ThreadSplit splitter, Thread newThread) {
		newThread.getMessages().clear();
		
		newThread.setThreadName(splitter.getNewThreadTitle());
		newThread = saveThread(newThread);
		messageDataProvider.moveMessagesToNewThread(splitter.getMessageIdsToMove(), newThread.getId());
		
		return newThread;
	}
	
}
