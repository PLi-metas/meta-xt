require recipes-mediacenter/kodi/stb-kodi_19.bb

PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=dreambox-mipsel \
    -DWITH_FFMPEG=stb \
"
