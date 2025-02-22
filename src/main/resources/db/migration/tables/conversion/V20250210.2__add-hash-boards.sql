alter table zfgbb.category
add column migration_hash text;

alter table zfgbb.board
add column migration_hash text;

alter table zfgbb.thread
add column migration_hash text;