require xtrend-stb-kodi.inc

RDEPENDS_${PN}_append = "et-v3ddriver-${MACHINE} platform-util-${MACHINE} et-dvb-modules-kodi-${MACHINE}"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=nextv-cortexa15 \
    -DWITH_FFMPEG=stb \
"

COMPATIBLE_MACHINE = "^(et1x000)$"
