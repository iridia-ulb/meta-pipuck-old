SUMMARY = "Template for C++ development on the Pi-Puck"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
   file://my_pipuck_controller.cpp \
   file://my_pipuck_controller.h \
   file://configuration.argos.in \
   file://CMakeLists.txt \
"

do_install() {
   install -d ${D}/home/root/argos3-pipuck-template
   install -m 0644 ${WORKDIR}/my_pipuck_controller.cpp ${D}/home/root/argos3-pipuck-template/my_pipuck_controller.cpp
   install -m 0644 ${WORKDIR}/my_pipuck_controller.h ${D}/home/root/argos3-pipuck-template/my_pipuck_controller.h
   install -m 0644 ${WORKDIR}/CMakeLists.txt ${D}/home/root/argos3-pipuck-template/CMakeLists.txt
   install -m 0644 ${WORKDIR}/configuration.argos.in ${D}/home/root/argos3-pipuck-template/configuration.argos.in
}

FILES_${PN} += " \
   /home/root/argos3-pipuck-template/* \
"

