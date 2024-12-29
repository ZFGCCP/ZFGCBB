# Environments

This directory contains kustomization files for each environment.

## Table of Contents

- [Environments](#environments)
  - [Table of Contents](#table-of-contents)
  - [Creating a new environment](#creating-a-new-environment)
    - [Applying the manifests](#applying-the-manifests)

## Creating a new environment

To create a new environment, create a new directory in this directory and add a `kustomization.yml` file to it.

```bash
mkdir production
touch production/kustomization.yml
```

The `kustomization.yml` file should contain the following:

```yaml
namespace: zfg-bb-prod
resources:
  - ../../base
  - ../../services
```

The `namespace` field should be set to the name of the namespace you want to create.

### Applying the manifests

You can then build and apply the manifests for this environment using the following commands:

```bash
kustomize build production
kustomize build production | kubectl apply -f -
```
