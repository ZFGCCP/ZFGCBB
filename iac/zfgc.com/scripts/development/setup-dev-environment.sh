#!/bin/bash

# Ensure this script is sourced
if [ "${BASH_SOURCE[0]}" == "${0}" ]; then
    echo "This script is not meant to be executed directly. Please source it."
    exit 1
fi

# SCRIPT_DIR=$(dirname "$0")

# # # Set the project base directory
# # PROJECT_DIR=$(realpath "$SCRIPT_DIR/../..")
# # PROJECT_ENVIRONMENT=$1

# source "$SCRIPT_DIR/../../../scripts/common/check-minikube.sh"
# source "$SCRIPT_DIR/../../../scripts/common/check-project-dir.sh"

setup() {
    PROJECT_DIR=$1
    PROJECT_ENVIRONMENT=$2

    check_project_dir "$PROJECT_DIR" "$PROJECT_ENVIRONMENT"
    check_minikube

    DIST_DIR="$PROJECT_DIR/dist"


    echo "Creating dist directory at $DIST_DIR..."
    mkdir -p "$DIST_DIR"

    # Define the directories for services under dist
    OLD_SKOOL_DIR="$DIST_DIR/old-skool"
    ZFG_BB_DIR="$DIST_DIR/zfgbb"
    MYSQL_DIR="$OLD_SKOOL_DIR/mysql_data"
    POSTGRES_DIR="$ZFG_BB_DIR/postgres_data"
    APACHE_VHOSTS_DIR="$OLD_SKOOL_DIR/apache_vhosts"

    echo "Creating directories for services under $DIST_DIR..."

    mkdir -p "$OLD_SKOOL_DIR"
    mkdir -p "$ZFG_BB_DIR"

    mkdir -p "$MYSQL_DIR"
    mkdir -p "$POSTGRES_DIR"

    mkdir -p "$APACHE_VHOSTS_DIR"

    ENV_FILE="$PROJECT_DIR/environments/$PROJECT_ENVIRONMENT/.env"

    create_env_file() {
        MYSQL_PASSWORD=$1
        POSTGRES_PASSWORD=$2
        TARGET_ENV_FILE="$PROJECT_DIR/environments/$PROJECT_ENVIRONMENT/.env"

        echo "Generating .env file at $TARGET_ENV_FILE..."
        touch "$TARGET_ENV_FILE"
    # FIXME: use grep to replace the placeholder values with the actual values
        cat > "$TARGET_ENV_FILE" <<EOL
MYSQL_DIRECTORY=$MYSQL_DIR
POSTGRES_DIRECTORY=$POSTGRES_DIR
APACHE_VHOST_CONFIG_DIRECTORY=$APACHE_VHOSTS_DIR

ZFGBB_IMAGE_NAME=zfgbb:latest
MYSQL_PASSWORD=$MYSQL_PASSWORD
POSTGRES_PASSWORD=$POSTGRES_PASSWORD
EOL
        echo ".env file generated successfully at $ENV_FILE"
    }

    # Output directories
    echo "Directories created successfully under $DIST_DIR"

    echo "Creating MySQL secret..."
    MYSQL_PASSWORD=$(openssl rand -base64 32)
    MYSQL_PASSWORD=$(kubectl create secret generic old-skool-secrets --from-literal=MYSQL_PASSWORD=${MYSQL_PASSWORD} --dry-run=client -o yaml | awk '/MYSQL_PASSWORD:/ {print $2}')
    echo "Creating PostgreSQL secret..."
    POSTGRES_PASSWORD=$(openssl rand -base64 32)
    POSTGRES_PASSWORD=$(kubectl create secret generic zfgbb-secrets --from-literal=POSTGRES_PASSWORD=${POSTGRES_PASSWORD} --dry-run=client -o yaml | awk '/POSTGRES_PASSWORD:/ {print $2}')
    if [ -f "$ENV_FILE" ]; then
        rm "$ENV_FILE"
    fi

    create_env_file "$MYSQL_PASSWORD" "$POSTGRES_PASSWORD"
}