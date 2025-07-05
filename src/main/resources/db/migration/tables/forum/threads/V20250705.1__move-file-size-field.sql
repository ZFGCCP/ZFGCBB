alter table file_attachments
drop column file_size;

alter table content_resource
add column file_size bigint;