DESCRIPTION = "	This includes a extended overlay.ini to the application file.	\
		This is needed allow write access to the /adu folder and /etc"
LICENCE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "\
	file://application \
"
S = "${WORKDIR}"
