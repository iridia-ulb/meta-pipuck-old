DESCRIPTION = "ARGoS: a parallel, multi-engine simulator for heterogeneous swarm robotics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
HOMEPAGE = "http://www.argos-sim.info/"

DEPENDS = "lua"
RDEPENDS_${PN} = "lua"

inherit cmake

SRC_URI = " \
   git://github.com/ilpincy/argos3;protocol=http \
   file://0001-Remove-malign-double-flag.patch \
   file://0002-Fix-compiler-and-linker-flags.patch \
"

SRCREV = "8b36a52dc56f6bffcb027eac05ae9c172a742a35"

S = "${WORKDIR}/git"

OECMAKE_SOURCEPATH = "${S}/src"

EXTRA_OECMAKE += "-DARGOS_BUILD_FOR=pipuck -DARGOS_DOCUMENTATION=OFF"

FILES_${PN}-doc += "${prefix}/doc"

