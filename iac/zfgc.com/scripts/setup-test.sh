#!/bin/bash

# Check if the project directory is provided as an argument
if [ -z "$1" ]; then
    echo "Error: No project directory provided."
    exit 1
fi

# Set the project base directory
PROJECT_DIR=$1

# Define the base directory for dist
DIST_DIR="$PROJECT_DIR/dist"

# Create the dist directory if it doesn't exist
echo "Creating dist directory at $DIST_DIR..."
mkdir -p "$DIST_DIR"

# Define the directories for services under dist
OLD_SKOOL_DIR="$DIST_DIR/old-skool"
ZFG_BB_DIR="$DIST_DIR/zfg-bb"
MYSQL_DIR="$OLD_SKOOL_DIR/mysql_data"
POSTGRES_DIR="$ZFG_BB_DIR/postgres_data"
APACHE_VHOSTS_DIR="$OLD_SKOOL_DIR/apache_vhosts"

# Create the service directories under dist
echo "Creating directories for services under $DIST_DIR..."

# Ensure the old-skool and zfg-bb directories exist
mkdir -p "$OLD_SKOOL_DIR"
mkdir -p "$ZFG_BB_DIR"

# Create the MySQL and PostgreSQL directories
mkdir -p "$MYSQL_DIR"
mkdir -p "$POSTGRES_DIR"

# Create the Apache vhost config directory for old-skool
mkdir -p "$APACHE_VHOSTS_DIR"

# Generate the .env file for the dev environment
ENV_FILE="$PROJECT_DIR/zfgc.com/environments/development/.env"

echo "Generating .env file at $ENV_FILE..."
touch "$ENV_FILE"

cat > "$ENV_FILE" <<EOL
# .env file for dev environment

# Namespace for isolation
NAMESPACE=dev

# File paths for services
MYSQL_DIRECTORY=$MYSQL_DIR
POSTGRES_DIRECTORY=$POSTGRES_DIR
APACHE_VHOST_CONFIG_DIRECTORY=$APACHE_VHOSTS_DIR

# Secure MySQL and PostgreSQL passwords (set secure values in production)
MYSQL_PASSWORD=your_mysql_password
POSTGRES_PASSWORD=your_postgres_password

# Apache Vhost config directory
APACHE_VHOST_CONFIG_DIRECTORY=$APACHE_VHOSTS_DIR

# Image name for zfg-bb (Spring Java project)
ZFGBB_IMAGE_NAME=zfg-bb:latest
EOL

echo ".env file generated successfully at $ENV_FILE"

# Output directories
echo "Directories created successfully under $DIST_DIR"
