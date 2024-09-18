create table user_bio_info (
	user_id integer not null primary key references zfgbb.user,
	custom_title text,
	personal_text text,
	created_ts timestamp not null default current_timestamp,
	updated_ts timestamp not null default current_timestamp
);