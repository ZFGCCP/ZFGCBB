create or replace function zfgbb.create_permission(p_permission_id int, p_permission_name text, p_permission_code text) 
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.permission(permission_id, permission_name, permission_code)
	values(p_permission_id, p_permission_name, p_permission_code)
	on conflict (permission_id)
	do update set permission_name = p_permission_name, permission_code = p_permission_code;
	
	return;
	
end; $$;


select zfgbb.create_permission(1, 'ZFGC User', 'ZFGC_USER');
select zfgbb.create_permission(2, 'ZFGC Guest', 'ZFGC_GUEST');
select zfgbb.create_permission(3, 'User Profile Viewer', 'ZFGC_PROFILE_VIEWER');
select zfgbb.create_permission(4, 'User Profile Editor', 'ZFGC_PROFILE_EDITOR');
select zfgbb.create_permission(5, 'User Profile Admin', 'ZFGC_PROFILE_ADMIN');

