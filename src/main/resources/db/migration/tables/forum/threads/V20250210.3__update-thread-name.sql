drop view if exists LATEST_MESSAGE_IN_THREAD_VIEW;

alter table zfgbb.thread
alter column thread_name type text;