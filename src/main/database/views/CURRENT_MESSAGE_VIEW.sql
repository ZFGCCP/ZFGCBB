create or replace view current_message_view as
select m.message_id,
       m.owner_id,
       m.thread_id,
       h.message_text,
       h.message_history_id,
       m.post_in_thread
from zfgbb.message m
join zfgbb.message_history h on h.message_id = m.message_id and h.current_flag = true
