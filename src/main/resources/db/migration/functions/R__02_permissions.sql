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

create or replace function zfgbb.create_permission_group(p_group_id int,
														 p_group_name text, 
														 p_description text, 
														 p_min_posts int,
														 p_parent_group int)
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.permission_group(permission_group_id, group_name, description, min_posts, star_image, parent_group)
	values(p_group_id, p_group_name, p_description, -1, 3, p_parent_group)
	on conflict(permission_group_id)
	do update set group_name = p_group_name, description = p_description, min_posts = p_min_posts, star_image = 3, parent_group = p_parent_group;
	
	return;
	
end; $$;

create or replace function zfgbb.associate_permission_to_group(p_group_name text, p_permission_name text)
returns void
language plpgsql
as $$
begin
	
	insert into zfgbb.permission_group_assoc(permission_group_id, permission_id)
	values((select permission_group_id from zfgbb.permission_group where group_name = p_group_name),
		   (select permission_id from zfgbb.permission where permission_code = p_permission_name)
		   );
	
	return;
end; $$;

create or replace function zfgbb.add_perm_to_board(p_id integer, p_board_id integer, p_perm_id integer)
returns void
language plpgsql
as $$
begin
	insert into zfgbb.br_board_permission (br_board_permission_id, board_id, permission_id)
	values (p_id, p_board_id, p_perm_id)
	on conflict (br_board_permission_id)
	do update set board_id = p_board_id, permission_id = p_perm_id;
	
	return;
end; $$;

select zfgbb.create_permission(1, 'ZFGC User', 'ZFGC_USER');
select zfgbb.create_permission(2, 'ZFGC Guest', 'ZFGC_GUEST');
select zfgbb.create_permission(3, 'User Profile Viewer', 'ZFGC_PROFILE_VIEWER');
select zfgbb.create_permission(4, 'User Profile Editor', 'ZFGC_PROFILE_EDITOR');
select zfgbb.create_permission(5, 'User Profile Admin', 'ZFGC_PROFILE_ADMIN');
select zfgbb.create_permission(6, 'Message Viewer', 'ZFGC_MESSAGE_VIEWER');
select zfgbb.create_permission(7, 'Message Editor', 'ZFGC_MESSAGE_EDITOR');
select zfgbb.create_permission(8, 'Message Admin', 'ZFGC_MESSAGE_ADMIN');
select zfgbb.create_permission(9, 'Read Only', 'ZFGC_READ_ONLY');

--select zfgbb.create_permission_group(1, 'Member', '', -1, null);
--select zfgbb.create_permission_group(2, 'Admin', '', -1, 1);

--select zfgbb.associate_permission_to_group('Member', 'ZFGC_USER');
