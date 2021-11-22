DESCRIPTION = "ARGoS: a parallel, multi-engine simulator for heterogeneous swarm robotics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
HOMEPAGE = "http://www.argos-sim.info/"

DEPENDS = "lua"
RDEPENDS_${PN} = "lua"

inherit cmake

SRC_URI = " \
   git://github.com/ilpincy/argos3;protocol=http \
"

SRCREV = "72d47a6f1731280756fe9f9bc07faddce9d67539"

S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH = "${S}/src"

EXTRA_OECMAKE += "-DARGOS_BUILD_FOR=pi-puck -DARGOS_DOCUMENTATION=OFF"

FILES_${PN}-doc += "${prefix}/doc"

