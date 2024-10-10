create or replace view zfgbb.latest_message_in_thread_view as
select t.thread_id, 
       t.thread_name,
       m.message_id, 
       m.message_history_id, 
       m.created_ts,
       u.display_name as owner_name
from zfgbb.thread t
join lateral (select m.owner_id, h.message_history_id, m.created_ts, m.message_id
              from zfgbb.message m
              join zfgbb.message_history h on h.message_id = m.message_id
              where h.current_flag = true
                    and m.thread_id = t.thread_id
              order by m.created_ts desc
              limit 1) m on true
join zfgbb.user u on u.user_id = m.owner_id          
              