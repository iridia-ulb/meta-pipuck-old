FROM ubuntu:20.04
ENV TZ=Europe/Brussels
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN apt-get update --fix-missing
RUN apt-get install -y gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint3 tmux libncurses-dev locales
RUN groupadd -g 1000 yocto && useradd -u 1000 -g yocto -d /home/yocto yocto && mkdir /home/yocto && chown -R yocto:yocto /home/yocto
RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
USER yocto
WORKDIR /home/yocto
RUN git clone git://git.yoctoproject.org/poky --branch dunfell --single-branch
WORKDIR /home/yocto/poky
RUN git clone git://git.openembedded.org/meta-openembedded --branch dunfell --single-branch
RUN git clone https://github.com/allsey87/meta-pipuck.git
RUN ["/bin/bash", "-c", "TEMPLATECONF=meta-pipuck/conf source oe-init-build-env"]
