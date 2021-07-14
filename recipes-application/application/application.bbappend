DESCRIPTION = "This includes a extended overlay.ini to the application file. This is needed allow write acces to the /adu folder and /etc"
LICENCE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "\
	file://application \
"
S = "${WORKDIR}"

# RDEPENDS_${PM} += "squashfs-tools-native"

FILES_${PN} = "rw_fs/root/application/app_a.squashfs \
			   rw_fs/root/application/app_b.squashfs \
               rw_fs/root/application/current \
			  "

do_install_append() {
    rm -rf ${D}/rw_fs/root/application/current
	install -d ${D}/rw_fs/root/application/current
}

