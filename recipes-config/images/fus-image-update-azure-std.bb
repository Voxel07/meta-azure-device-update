require recipes-config/images/fus-image-update-std.bb

DESCRIPTION = "F&S standard azure image"
LICENSE = "MIT"
FIRMWARE_VERSION ?= "20210708"

CORE_IMAGE_EXTRA_INSTALL += " \
    azure-device-update   \
"
#    adu-agent-service \
