require et-dvb-modules.inc

SRCDATE = "20190927"

SRC_URI = "http://source.mynonpublic.com/xtrend/${MACHINE}-drivers-${KV}-6.3.0-${SRCDATE}.zip"

SRC_URI[md5sum] = "7fd6a54cb7ee94574c6299ebc2fe2548"
SRC_URI[sha256sum] = "690e121c4fdbe2a0a7b259307518bf8adec28b534a472582493bea032630ec2e"

COMPATIBLE_MACHINE = "^(et1x000)$"
