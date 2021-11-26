SUMMARY = "Template C++ Controller for the Pi-Puck"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "argos3-pipuck"
RDEPENDS_${PN} = "argos3-pipuck"

inherit cmake

SRC_URI = " \
   file://my_pipuck_controller.cpp \
   file://my_pipuck_controller.h \
   file://configuration.argos.in \
   file://CMakeLists.txt \
"

S = "${WORKDIR}/"
  
FILES_${PN} += "${libdir}/argos3/*"
FILES_${PN} += "${datadir}/argos3/*"
