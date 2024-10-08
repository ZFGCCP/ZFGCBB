create table language_lookup(
	language_id integer not null generated by default as identity primary key,
	description text not null,
	language_code text not null,
	created_ts timestamp not null default current_timestamp,
	updated_ts timestamp not null default current_timestamp
);

create table gender_lookup(
	gender_id integer not null generated by default as identity primary key,
	description text not null,
	gender_code text not null,
	created_ts timestamp not null default current_timestamp,
	updated_ts timestamp not null default current_timestamp
);

alter table zfgbb.user_bio_info
add column date_of_birth timestamp not null,
add column location text,
add column gender_id integer references zfgbb.gender_lookup,
add column language_id integer references zfgbb.language_lookup,
add column visible_online_flag boolean not null default true;