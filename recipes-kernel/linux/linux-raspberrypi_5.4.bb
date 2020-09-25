LINUX_VERSION ?= "5.4.51"
LINUX_RPI_BRANCH ?= "rpi-5.4.y"

SRCREV = "95a969f451f6ed61029741411c1c9aa44023e465"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-raspberrypi:"

require linux-raspberrypi.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_EXTRA_ARGS_append_rpi = " DTC_FLAGS='-@ -H epapr'"

SRC_URI = " \
    git://github.com/raspberrypi/linux.git;branch=${LINUX_RPI_BRANCH} \
    file://0001-Revert-selftests-bpf-Skip-perf-hw-events-test-if-the.patch \
    file://0002-Revert-selftests-bpf-Fix-perf_buffer-test-on-systems.patch \
    file://0003-dts-Add-Pi-Puck-device-tree-overlay.patch \
    file://powersave.cfg \
    file://cryptography.cfg \
    file://iio.cfg \
"

