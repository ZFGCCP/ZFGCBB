create or replace view current_message_view as
 SELECT m.message_id,
    m.owner_id,
    m.thread_id,
    h.message_text,
    h.message_history_id,
    m.post_in_thread,
    m.created_ts
   FROM zfgbb.message m
     JOIN zfgbb.message_history h ON h.message_id = m.message_id AND h.current_flag = true;