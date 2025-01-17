#!/bin/bash
set -e

if [[ "$1" == "-h" || "$1" == "--help" ]]; then
cat <<EOF
Usage: $0 [POSTGRES_USER] [POSTGRES_PASSWORD] [ZFGBB_DATABASE] [ZFGBB_USER] [ZFGBB_USER_PASSWORD]
Example: $0 postgres 123456 zfgc_dev zfgbb_user 123456

If no arguments are provided, the script will use the following defaults:

POSTGRES_USER: postgres
POSTGRES_PASSWORD: 123456
ZFGBB_DATABASE: zfgc_dev
ZFGBB_USER: zfgbb_user
ZFGBB_USER_PASSWORD: 123456
EOF
    exit 1
fi

if [ -z "$POSTGRES_USER" ]; then
    POSTGRES_USER=${1:-postgres}
fi

if [ -z "$POSTGRES_PASSWORD" ]; then
    POSTGRES_PASSWORD=${2:-123456}
fi

if [ -z "$ZFGBB_DATABASE" ]; then
    ZFGBB_DATABASE=${3:-zfgc_dev}
fi

if [ -z "$ZFGBB_USER" ]; then
    ZFGBB_USER=${4:-zfgbb_user}
fi

if [ -z "$ZFGBB_USER_PASSWORD" ]; then
    ZFGBB_USER_PASSWORD=${5:-123456}
fi

echo "Setting up database..."

echo "Creating roles... [1/4]"
psql --username "$POSTGRES_USER" --command "
	-- Create Roles
	CREATE ROLE ZFGCADMIN
	WITH
		NOLOGIN NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT NOREPLICATION NOBYPASSRLS CONNECTION
	LIMIT
		-1;

	COMMENT ON ROLE ZFGCADMIN IS 'Admin users.';

	-- Create User
	CREATE ROLE $ZFGBB_USER
	WITH
		LOGIN NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT NOREPLICATION NOBYPASSRLS CONNECTION
	LIMIT
		-1 PASSWORD '$ZFGBB_USER_PASSWORD';

	GRANT ZFGCADMIN TO $ZFGBB_USER
	WITH
		ADMIN OPTION;

	COMMENT ON ROLE $ZFGBB_USER IS 'Default ZFGBB User.';
"

DB_EXISTS=$(psql --username "$POSTGRES_USER" --dbname "$ZFGBB_DATABASE" --command "SELECT 1 FROM pg_database WHERE datname = '$ZFGBB_DATABASE';")
if [ -n "$DB_EXISTS" ]; then
	echo "Database already exists."
else 
	echo "Creating database... [2/4]"
	psql --username "$POSTGRES_USER" --command  "CREATE DATABASE $ZFGBB_DATABASE WITH OWNER = $ZFGBB_USER;"
fi

psql --username "$POSTGRES_USER" --dbname "$ZFGBB_DATABASE" --command "GRANT ALL ON DATABASE $ZFGBB_DATABASE TO zfgcadmin WITH GRANT OPTION; GRANT ALL ON DATABASE $ZFGBB_DATABASE TO $ZFGBB_USER;"

echo "Creating schema... [3/4]"
psql --username "$POSTGRES_USER" --dbname "$ZFGBB_DATABASE" --command "CREATE SCHEMA IF NOT EXISTS ZFGBB AUTHORIZATION $ZFGBB_USER;" \
	--command "COMMENT ON SCHEMA ZFGBB IS 'ZFGBB Schema.';" \
	--command "GRANT ALL ON SCHEMA ZFGBB TO $ZFGBB_USER;" \
	--command "GRANT ALL ON SCHEMA ZFGBB TO ZFGCADMIN WITH GRANT OPTION;" \
	--command "ALTER DEFAULT PRIVILEGES IN SCHEMA ZFGBB GRANT ALL ON TABLES TO ZFGCADMIN;" \
	--command "GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA ZFGBB TO ZFGCADMIN;"

echo "Provisioning database... [4/4]"

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
psql --username "$POSTGRES_USER" --dbname "$ZFGBB_DATABASE" -a -f "$SCRIPT_DIR/2-provision-database"