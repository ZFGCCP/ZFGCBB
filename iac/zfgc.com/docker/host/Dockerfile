FROM zfgc-com-ubuntu-base as zfgc-com-host

RUN apt-get update && apt-get install -y 

COPY ./scripts/setup-ansible.sh /tmp/setup-ansible.sh
COPY ./ansible /ansible

RUN /tmp/setup-ansible.sh && \
    apt-get prune -y && \
    rm /tmp/*.sh 

RUN ansible-playbook /ansible/provision-kubernetes.yml
