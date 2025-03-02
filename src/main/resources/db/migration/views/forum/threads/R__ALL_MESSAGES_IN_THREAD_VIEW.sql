create or replace view zfgbb.all_messages_in_thread_view as
select t.thread_id,
	   t.thread_name,
	   t.locked_flag,
	   t.pinned_flag,
	   t.created_ts,
	   t.updated_ts,
	   t.board_id,
	   t.created_user_id,
	   t.view_count,
	   m.message_id,
	   m.owner_id as last_posted_user_id,
	   u.display_name as last_posted_user,
	   m.created_ts as post_ts,
	   m.post_in_thread
from zfgbb.thread t
join zfgbb.message m on m.thread_id = t.thread_id
join zfgbb.user u on u.user_id = m.owner_id
order by t.thread_id, m.created_ts desc