#!/bin/bash

set -e

minikube start --driver=docker
kubectl config use-context minikube
