create or replace function zfgbb.touch_updated_ts() returns trigger
language plpgsql as $$
begin
	if new.updated_ts is distinct from old.updated_ts then
		return new;
	end if;
	if new is distinct from old then
		new.updated_ts = current_timestamp;
	end if;
	return new;
end $$;

create or replace function zfgbb.attach_updated_ts_triggers() returns integer
language plpgsql as $$
declare
	attached integer := 0;
	the_table record;
begin
	for the_table in
		select c.table_name
		  from information_schema.columns c
		  join information_schema.tables t
		    on t.table_schema = c.table_schema and t.table_name = c.table_name
		 where c.table_schema = 'zfgbb'
		   and c.column_name = 'updated_ts'
		   and t.table_type = 'BASE TABLE'
		 order by c.table_name
	loop
		if not exists (select 1 from pg_trigger g
		                join pg_class r on r.oid = g.tgrelid
		                join pg_namespace n on n.oid = r.relnamespace
		               where n.nspname = 'zfgbb'
		                 and r.relname = the_table.table_name
		                 and g.tgname = 'touch_updated_ts') then
			execute format(
				'create trigger touch_updated_ts before update on zfgbb.%I '
				|| 'for each row execute function zfgbb.touch_updated_ts()',
				the_table.table_name);
			attached := attached + 1;
		end if;
	end loop;
	return attached;
end $$;

select zfgbb.attach_updated_ts_triggers();
