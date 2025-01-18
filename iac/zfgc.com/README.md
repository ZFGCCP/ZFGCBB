# zfgc.com

This directory contains the infrastructure as code for the zfgc.com domain.

## Table of Contents

- [zfgc.com](#zfgccom)
  - [Table of Contents](#table-of-contents)
  - [Services](#services)
    - [Shared](#shared)

## Services

Currently, we're including legacy zfgc.com services under the `old-skool` service. This also includes the `crystalrookarts.com` domain. These are excluded from the [develop environment](./environments/develop/kustomization.yml) to avoid conflicts with the legacy zfgc.com domain.

- [old-skool](./services/old-skool)
- [zfg-bb](./services/zfgbb)

### Shared

- [postgres](./services/shared/postgres/kustomization.yml)
