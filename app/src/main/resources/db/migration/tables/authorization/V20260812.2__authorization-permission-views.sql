create or replace view zfgbb.user_permission_view as
select u.user_id, p.permission_id, p.permission_code
from zfgbb.br_user_permission u
join zfgbb.permission p on p.permission_id = u.user_permission_id
union
select upga.user_id, p.permission_id, p.permission_code
from zfgbb.user_permission_group_assoc upga
join zfgbb.permission_group_assoc pga on pga.permission_group_id = upga.permission_group_id
join zfgbb.permission p on p.permission_id = pga.permission_id;

delete from zfgbb.br_user_permission duplicate_grant
where duplicate_grant.br_user_permission_id > (
	select min(surviving_grant.br_user_permission_id)
	from zfgbb.br_user_permission surviving_grant
	where surviving_grant.user_id = duplicate_grant.user_id
		and surviving_grant.user_permission_id = duplicate_grant.user_permission_id
);

create unique index if not exists ux_br_user_permission_user_id_user_permission_id
	on zfgbb.br_user_permission (user_id, user_permission_id);
