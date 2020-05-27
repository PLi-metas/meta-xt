require conf/machine/include/et.inc

PREFERRED_PROVIDER_virtual/blindscan-dvbs = "et-blindscan-dvbs-utils"

MKUBIFS_ARGS = "-m 2048 -e 126976 -c 4096"
UBINIZE_ARGS = "-m 2048 -p 128KiB"

IMAGE_CMD_ubi_prepend = " \
	rm -Rf ${IMAGE_ROOTFS}/tmp/*; \
	"

MACHINE_FEATURES += "externalwifi textlcd middleflash"

# Broken bootloader can only flash around 100 MB
FLASHSIZE = "96"

PREFERRED_VERSION_linux-etxx00 = "3.8.7"
