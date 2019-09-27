SUMMARY = "Hardware drivers for ${MACHINE_DRIVER}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "et1x000"

PV = "${KV}+${SRCDATE}"

KV = "4.1.37"
SRCDATE = "20190927"

SRC_URI = "http://source.mynonpublic.com/xtrend/${MACHINE}-drivers-${KV}-6.3.0-${SRCDATE}.zip"

SRC_URI[md5sum] = "7fd6a54cb7ee94574c6299ebc2fe2548"
SRC_URI[sha256sum] = "690e121c4fdbe2a0a7b259307518bf8adec28b534a472582493bea032630ec2e"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}
do_populate_sysroot() {
}

do_install() {
	install -d ${D}/lib/modules/${KV}/extra
	install -d ${D}/${sysconfdir}/modules-load.d
	for i in tpm modloader modloader2 dvb; do
		install -m 0755 ${WORKDIR}/$i.ko ${D}/lib/modules/${KV}/extra
		echo $i >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
	done
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf /lib/modules/${KV}/extra"
