# Generates a text file with the ADU applicability info
# for manufacturer and model and copies/installs that file into the image.

# Environment variables that can be used to configure the behaviour of this recipe.
# MANUFACTURER          The manufacturer string that will be written to the manufacturer
#                       file and reported through the Device Information PnP Interface.
# MODEL                 The model string that wil be written to the model file and
#                       reported through the Device Information PnP Interface.
# ADU_SOFTWARE_VERSION  The software version for the image/firmware. Will be written to
#                       the version file that is read by ADU Client.

LICENSE="CLOSED"

# Generate the manufacturer, model, and version files
do_compile() {
    echo "${MANUFACTURER}" > adu-manufacturer
    echo "${MODEL}" > adu-model
    echo "${ADU_SOFTWARE_VERSION}" > adu-version

    echo "connection_string = ${CONNECTIONSTRING}" > adu-conf.txt
    echo "aduc_manufacturer = aduc${MANUFACTURER}" >> adu-conf.txt
    echo "aduc_model = adu_${MODEL}" >> adu-conf.txt
    echo "manufacturer = ${MANUFACTURER}" >> adu-conf.txt
    echo "model = ${MODEL}" >> adu-conf.txt
}

# Install the files on the image in /etc
do_install() {
    bbwarn "test2"
    install -d ${D}${sysconfdir}
    install -d ${D}"/adu"
    install -m ugo=r adu-manufacturer ${D}${sysconfdir}/adu-manufacturer
    install -m ugo=r adu-model ${D}${sysconfdir}/adu-model
    install -m ugo=r adu-version ${D}${sysconfdir}/adu-version
    install -m ugo=r adu-conf ${D}/adu/adu-conf.txt
}

FILES_${PN} += "${sysconfdir}/adu-manufacturer"
FILES_${PN} += "${sysconfdir}/adu-model"
FILES_${PN} += "${sysconfdir}/adu-version"
FILES_${PN} += "/adu/adu-conf.txt"


inherit allarch
