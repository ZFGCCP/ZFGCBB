alter table zfgbb.poll
add column voting_locked_flag boolean not null default false,
add column max_votes boolean not null default true,
add column expire_time timestamp not null,
add column hide_results_flag boolean not null default false,
add column change_vote_flag boolean not null default false,
add column created_user_id integer not null references zfgbb.user,
add column guest_vote_flag boolean not null default false,
add column guest_vote_count integer not null default 0,
add column reset_poll integer not null default 0;