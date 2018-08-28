SUMMARY = "image update support"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "xtrend"
LICENSE = "proprietary"
PACKAGE_ARCH := "${MACHINE_ARCH}"

require conf/license/license-gplv2.inc

COMPATIBLE_MACHINE = "et13000|beyonwizu4"

ALLOW_EMPTY_${PN} = "1"

S = "${WORKDIR}"

addtask deploy before do_build after do_install

SRCDATE = "20170906"

SRC_URI = "http://source.mynonpublic.com/xtrend/vmlinuz-initrd-et13000-${SRCDATE}.zip"

SRC_URI[md5sum] = "0c32eae195397157ad53a20bc58780b3"
SRC_URI[sha256sum] = "49a8c0127800fbedbe1d2d4f29cbcda527c4a385cd157f6c2f530215b7174829"

inherit deploy
do_deploy() {
    if [ -e update.bin  ]; then
    install -m 0644 update.bin  ${DEPLOYDIR}/${MACHINE}_update.bin
    fi
}
