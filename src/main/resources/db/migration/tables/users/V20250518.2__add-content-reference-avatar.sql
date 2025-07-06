alter table avatar
drop column filename,
add column content_resource_id integer references content_resource;

alter table content_resource
add column migration_hash text;