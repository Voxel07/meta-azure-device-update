# Creates the base image for ADU that can we used to flash an SD card.
# This image is also used to populate the ADU update image.

DESCRIPTION = "ADU base image"
SECTION = ""
LICENSE="CLOSED"

IMAGE_FEATURES += "splash debug-tweaks ssh-server-openssh tools-debug tools-profile"

# connman - provides network connectivity.
# parted - provides disk partitioning utility.
# fw-env-conf - installs fw_env.config file for fw utils. (fw_*)
IMAGE_INSTALL_append = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    openssh connman connman-client \
    parted fw-env-conf \
    adu-agent-service \
    "

export IMAGE_BASENAME = "adu-base-image"

# This must be at the bottom of this file.
inherit core-image
