# meta-pipuck

## Description

## Dependencies

git clone git://git.yoctoproject.org/poky --branch dunfell --single-branch
git clone git://git.openembedded.org/meta-openembedded --branch dunfell --single-branch
git clone https://github.com/allsey87/meta-pipuck.git

## Quick Start

TEMPLATECONF=meta-pipuck/conf source oe-init-build-env

bitbake core-image-base

sudo bmaptool copy ~/core-image-base-raspberrypi0-wifi.wic.bz2 /dev/XXX


