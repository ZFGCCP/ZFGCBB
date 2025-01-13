#!/bin/bash
set -e

PROJECT_DIR=$1
PROJECT_ENVIRONMENT=$2

[ ! -d "$PROJECT_DIR" ] && echo "Error: Project directory not found." && exit 1

kubectl config use-context minikube

cd "$PROJECT_DIR/environments/$PROJECT_ENVIRONMENT"
kubectl kustomize . -v 9
#kustomize edit fix

echo "Applying kustomize build..."
echo ""

kustomize build . | kubectl apply -f -
cd -