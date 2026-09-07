#!/bin/env sh
set -eu

application_user=${SPRING_DATASOURCE_USERNAME:?SPRING_DATASOURCE_USERNAME is required}
application_password=${SPRING_DATASOURCE_PASSWORD:?SPRING_DATASOURCE_PASSWORD is required}

case "$application_user" in
	*[!A-Za-z0-9_]*|'')
		echo 'Database role name contains unsupported characters.' >&2
		exit 1
		;;
esac

psql --set ON_ERROR_STOP=on \
	--username "$POSTGRES_USER" \
	--dbname postgres \
	--set application_user="$application_user" \
	--set application_password="$application_password" \
	--set application_database="$POSTGRES_DB" <<'SQL'
select format('create role %I login password %L',
	:'application_user', :'application_password')
where not exists (select 1 from pg_roles where rolname=:'application_user') \gexec
select 'create role zfgcadmin nosuperuser nocreatedb nocreaterole nologin'
where not exists (select 1 from pg_roles where rolname='zfgcadmin') \gexec

select format('alter role %I login password %L nosuperuser nocreatedb nocreaterole',
	:'application_user', :'application_password') \gexec
select format('grant zfgcadmin to %I with admin option', :'application_user') \gexec
select format('grant connect, create, temporary on database %I to %I',
	:'application_database', :'application_user') \gexec
create schema if not exists zfgbb authorization zfgcadmin;
select format('grant usage, create on schema zfgbb to %I',
	:'application_user') \gexec
SQL
