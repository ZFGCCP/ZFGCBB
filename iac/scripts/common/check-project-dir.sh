#!/bin/bash

check_project_dir() {
    PROJECT_DIR=$1
    PROJECT_ENVIRONMENT=$2
    if [ ! -d "$PROJECT_DIR" ]; then
        echo "Error: Project directory not found."
        exit 1
    fi

    # Check if environment directory exists
    ENVIRONMENT_DIR="$PROJECT_DIR/environments/$PROJECT_ENVIRONMENT"
    if [ ! -d "$ENVIRONMENT_DIR" ]; then
        echo "Error: Environment directory not found."
        exit 1
    fi
}
