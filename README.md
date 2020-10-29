# The meta-pipuck layer for the Yocto build system

## Description
This repository contains a layer of the Yocto build system, which generates a complete, bootable Linux OS ready to be run on the Pi-Puck mobile robot. This system comes preinstalled with:
- ARGoS3 and a plugin for the Pi-Puck robot
- OpenCV
- Python
- GNU Compiler Collection (i.e., `gcc` and `g++` etc.)
- GNU Debugger (`gdb`)

## Quick start
We have listed two ways to build the system below. While the resulting image will be approximately 1 GB in size, the build will require around **50 GB** of free disk space. The reccomended method is to use Docker which will ensure a clean and predictable build environment.

### The Docker way
The easiest way to build this image is to use Docker. Given you have Docker installed, the following command will execute the Dockerfile in this repository and create a container based on Ubuntu 20.04 LTS. The container will contain a user and group called `yocto` and will clone dependencies so that you only need to type a single command inside the container to start the build.

```
docker build https://github.com/allsey87/meta-pipuck.git#:docker
```

### The manual way
These instructions assume you are running a clean, up-to-date installation of Ubuntu. If this is not the case, it is advisable to use the Docker solution above. 

The first step is to install the dependencies for running Yocto:
```
sudo apt install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect
 xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint3 tmux
```

Secondly, check out the required layers of the build system into a directory where you would like to perform the build (remember to check if you have enough free disk space):
```
# Clone the Yocto repository
git clone git://git.yoctoproject.org/poky --branch dunfell --single-branch
# Clone additional layers inside the Yocto repository
cd poky
git clone git://git.openembedded.org/meta-openembedded --branch dunfell --single-branch
git clone https://github.com/allsey87/meta-pipuck.git
```

Finally, initialize the build environment
```
TEMPLATECONF=meta-pipuck/conf source oe-init-build-env
```

## Building the image
To build the entire image, just run the following command
```
bitbake core-image-base
```

Occasionally, the build can fail due to internet connectivity issues or due to an oversight in the dependency tree. These issues are normally resolved by just re-executing the command above.

## Burning the image
The most straightforward way to burn a bootable image to the SD card is to use `bmaptool` from Intel. On Ubuntu, this package can be installed with `sudo apt install bmap-tools`. Most distributions of Linux should have a similar package that can be installed.

To burn the image, you need to locate the output image from the build system and to identify the device to which you would like to copy the image. The output image files are called `core-image-base-raspberrypi0-wifi.wic.bz2` and `core-image-base-raspberrypi0-wifi.wic.bmap` should be located under `poky/build/tmp/deploy/images/raspberrypi0-wifi`. The device (probably an SD card) that you want to write to will usually be something like `/dev/sdX` or `/dev/mmcX`. The easiest way to find out is to inspect the output of `dmesg` before and after inserting the SD card into your computer. You will need to unmount the device before burning the image. Be careful not to write the image to the device where your OS is installed.

```
unmount /dev/DEVICE*
sudo bmaptool copy PATH/TO/core-image-base-raspberrypi0-wifi.wic.bz2 /dev/DEVICE
```

## Booting the image and accessing the console
TODO

## Wifi configuration
TODO


