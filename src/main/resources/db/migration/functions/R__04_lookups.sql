create or replace function zfgbb.create_content_types(content_type_id int, code text, p_description text) 
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.content_resource_type(content_resource_type_id, content_code, description)
	values(content_type_id, code, p_description)
	on conflict (content_resource_type_id)
	do update set content_code = code, description = p_description;
	
	return;
	
end; $$;

select zfgbb.create_content_types(1, 'AVR', 'Avatar');