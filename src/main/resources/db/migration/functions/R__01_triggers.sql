create or replace function zfgbb.set_current_msg_after_insert()
returns trigger as $$
begin
	update zfgbb.message_history
	set current_flag = true
	where message_history_id = new.message_history_id;

	update zfgbb.message_history
	set current_flag = false
	where message_history_id <> new.message_history_id and
	      message_id = new.message_id;
	      
	return new;
end;
$$ language plpgsql;

drop trigger if exists trigger_message_history_after_insert on zfgbb.message_history;
create trigger trigger_message_history_after_insert
after insert on zfgbb.message_history
for each row execute procedure zfgbb.set_current_msg_after_insert();

--drop trigger if exists trigger_message_updated_ts on zfgbb.message;
