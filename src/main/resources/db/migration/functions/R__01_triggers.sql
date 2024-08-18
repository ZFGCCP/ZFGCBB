create or replace function zfgbb.set_current_msg_after_insert()
returns trigger as $$
begin
	update zfgbb.message_history mh
	set mh.current_flag = 1
	where mh.message_history_id = new.message_history_id;

	update zfgbb.message_history mh
	set mh.current_flag = 0
	where mh.message_history_id <> new.message_history_id and
	      mh.message_id = new.message_id;
end;
$$ language plpgsql;

drop trigger if exists message_history_after_insert on message_history_after_insert;
create trigger message_history_after_insert
after insert on zfgbb.message_history
execute procedure zfgbb.set_current_msg_after_insert();

