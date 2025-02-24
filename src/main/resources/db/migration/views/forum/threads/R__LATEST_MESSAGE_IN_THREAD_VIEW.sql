create or replace view zfgbb.latest_message_in_thread_view as
select t.thread_id,
	   t.thread_name,
	   t.locked_flag,
	   t.pinned_flag,
	   t.created_ts,
	   t.updated_ts,
	   t.board_id,
	   t.created_user_id,
	   t.view_count,
	   max(m.created_ts) as last_post_ts
from zfgbb.thread t
join zfgbb.message m on m.thread_id = t.thread_id
join zfgbb.user u on u.user_id = m.owner_id
group by t.thread_id, t.thread_name, t.locked_flag, t.pinned_flag, t.created_ts, t.updated_ts, t.board_id, t.created_user_id, t.view_count
order by t.thread_id    
              