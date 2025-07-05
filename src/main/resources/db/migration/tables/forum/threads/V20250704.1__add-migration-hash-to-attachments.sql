alter table file_attachments
add column migration_hash text,
add file_size bigint,
add downloads integer;
