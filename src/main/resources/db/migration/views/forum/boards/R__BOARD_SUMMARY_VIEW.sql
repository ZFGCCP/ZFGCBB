create or replace view zfgbb.board_summary as
select b.board_id,
       b.description,
	   b.board_name,
	   threads.thread_count,
	   posts.post_count,
	   latest_post.message_id as latest_message_id,
	   latest_post.thread_id as latest_thread_id,
	   latest_post.owner_id as latest_message_owner_id,
	   latest_post.display_name as latest_message_user_name,
	   latest_post.created_ts as latest_message_created_ts,
	   b.category_id,
	   b.parent_board_id
from zfgbb.board b
left join lateral(
	select count(*) thread_count
	from zfgbb.thread t
	where t.board_id = b.board_id
) threads on true
left join lateral(
	select count(*) post_count
	from zfgbb.thread t
	join zfgbb.message m on m.thread_id = t.thread_id
	where t.board_id = b.board_id
) posts on true
left join lateral(
	select m.message_id,
	       m.owner_id,
	       u.display_name,
	       m.created_ts,
		   t.thread_id
	from zfgbb.thread t
	join zfgbb.message m on m.thread_id = t.thread_id
	join zfgbb.user u on u.user_id = m.owner_id
	where t.board_id = b.board_id
	order by m.created_ts desc
	limit 1
) latest_post on true