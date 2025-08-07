alter table avatar
drop column user_id;

alter table user_bio_info
add column avatar_id integer references avatar;

create unique index idx_user_bio_info_avatar on zfgbb.user_bio_info(avatar_id);