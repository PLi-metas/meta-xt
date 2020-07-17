SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(et13000|beyonwizu4)$"

PV = "${KV}+${SRCDATE}"

KV = "4.9.51"
SRCDATE = "20180411"

SRC_URI = "http://source.mynonpublic.com/xtrend/beyonwizu4-drivers-${KV}-6.3.0-${SRCDATE}.zip"

SRC_URI[md5sum] = "8531611aed3c257bbff831ba343d7998"
SRC_URI[sha256sum] = "796fcf70fae36c212773e7fd6d8f8b2de39b39d4ddac5544cc8a267b5ecd192b"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}

do_populate_sysroot() {
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KV}/extra
	install -d ${D}/${sysconfdir}/modules-load.d
	for i in tpm modloader modloader2 dvb; do
		install -m 0755 ${WORKDIR}/$i.ko ${D}${base_libdir}/modules/${KV}/extra
		echo $i >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
	done
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf ${base_libdir}/modules/${KV}/extra"
