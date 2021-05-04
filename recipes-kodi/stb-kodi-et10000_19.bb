require xtrend-stb-kodi.inc

RDEPENDS_${PN} += "xtrend-v3ddriver-et10000"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=v3d-mipsel \
    -DWITH_FFMPEG=stb \
"

COMPATIBLE_MACHINE = "^(et10000)$"
