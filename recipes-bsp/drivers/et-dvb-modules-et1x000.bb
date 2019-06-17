SUMMARY = "Hardware drivers for ${MACHINE_DRIVER}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "et1x000"

PV = "${KV}+${SRCDATE}"

KV = "4.1.37"
SRCDATE = "20170918"

SRC_URI = "http://source.mynonpublic.com/xtrend/${MACHINE}-drivers-${KV}-6.3.0-${SRCDATE}.zip"

SRC_URI[md5sum] = "665818a65559cb09fbb4cf007b8a253f"
SRC_URI[sha256sum] = "db0c50fa38ef73fac52a7457bef062fdba2aa51b0af311ec08e6efb631926804"

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
