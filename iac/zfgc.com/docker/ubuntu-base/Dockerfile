FROM ubuntu:noble as zfgc-com-ubuntu-base

COPY ./scripts/setup-docker.sh /tmp/setup-docker.sh

# Override packages using syntaxl like this:
    # DEBIAN_FRONTEND=noninteractive apt-get install --assume-yes \
    # package-name=1.0.* \
    # etc...
    
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install --assume-yes