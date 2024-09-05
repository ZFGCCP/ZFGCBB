package com.zfgc.zfgbb.dataprovider.forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dao.forum.PollDao;
import com.zfgc.zfgbb.dao.forum.PollQuestionDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDbo;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDboExample;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.LatestMessageInThreadViewDbo;
import com.zfgc.zfgbb.dbo.LatestMessageInThreadViewDboExample;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.dbo.PollDbo;
import com.zfgc.zfgbb.dbo.PollDboExample;
import com.zfgc.zfgbb.dbo.PollQuestionDbo;
import com.zfgc.zfgbb.dbo.PollQuestionDboExample;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.mappers.AllMessagesInThreadViewDboMapper;
import com.zfgc.zfgbb.mappers.LatestMessageInThreadViewDboMapper;
import com.zfgc.zfgbb.mappers.MessageDboMapper;
import com.zfgc.zfgbb.mappers.ThreadDboMapper;
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
	
	@Autowired
	private AllMessagesInThreadViewDboMapper allMessagesMapper;
	
	@Autowired
	private MessageDboMapper messageMapper;
	
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
		
		//map them all by threadId
		List<LatestMessageInThreadViewDbo> latestMessages = latestMessageMapper.selectByExampleWithLimits(exT);
		List<Thread> result = super.convertDboListToModel(latestMessages, Thread.class);
		Map<Integer, LatestMessageInThreadViewDbo> messagesByThreadId = latestMessages.stream()
																					  .collect(Collectors.toMap(LatestMessageInThreadViewDbo::getThreadId, Function.identity()));
		//we don't need the original list anymore, so lets clear it to free up some memory
		latestMessages.clear();
		
		//also get details of all the messages, mapped by threadId
		//todo: find a better way to do this? it's fast, but I don't like the idea of loading all the posts for a thread
		//just to get the latest one
		//doing it via sql so far has been too slow
		AllMessagesInThreadViewDboExample amEx = new AllMessagesInThreadViewDboExample();
		List<AllMessagesInThreadViewDbo> fullMessageDetails = new ArrayList<>();
		Map<Integer, List<AllMessagesInThreadViewDbo>> mappedMessageDetails = new HashMap<>();
		
		if(!result.isEmpty()) {
			amEx.createCriteria().andThreadIdIn(result.stream().map(Thread::getThreadId).collect(Collectors.toList()));
			amEx.setOrderByClause("post_ts desc");
			fullMessageDetails = allMessagesMapper.selectByExample(amEx);
			
			mappedMessageDetails.putAll(fullMessageDetails.stream()
					 									  .collect(Collectors.groupingBy(AllMessagesInThreadViewDbo::getThreadId)));
			
			//we don't need the original list anymore, so lets clear it to free up some memory
			fullMessageDetails.clear();
		}
		
		//finally, link up all the data
		result.forEach(th -> {
			AllMessagesInThreadViewDbo latestDetails = mappedMessageDetails.get(th.getThreadId()).get(0);
			th.setCreatedUser(super.mapper.map(userDao.get(th.getCreatedUserId()), User.class));
			th.setPostCount(messageDataProvider.getTotalPostsInThread(th.getThreadId()).intValue());
			
			LatestMessageInThreadViewDbo latestDbo = messagesByThreadId.get(th.getThreadId());
			if(latestDbo != null) {
				th.setLatestMessage(mapper.map(latestDbo, LatestMessage.class));
				th.getLatestMessage().setOwnerName(latestDetails.getLastPostedUser());
			}
			
			//as we get done, clear out the details to free up memory
			mappedMessageDetails.remove(th.getThreadId());
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
			
			MessageDboExample ex = new MessageDboExample();
			ex.createCriteria().andThreadIdEqualTo(threadId);
			long count = messageMapper.countByExample(ex);
			result.setPageCount((int)Math.ceil(count / 10));
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
