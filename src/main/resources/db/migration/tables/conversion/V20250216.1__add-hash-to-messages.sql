alter table zfgbb.message
add column migration_hash text;

alter table zfgbb.message_history
add column migration_hash text;