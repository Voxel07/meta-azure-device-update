# Introduction 

This project meta-azure-device-update serves as an example of embedding device update agent in a custom Linux-based system.

**Disclaimer:**
There is no guarantee or support for this project. Please modify and customize the project to fit your need, and reference this example as needed.

# Prerequisite

The following instructions are based on Yocto Project, please find the basics of Yocto Project in https://www.yoctoproject.org/.
The following instruction will guide you to create a Raspberry Pi Poky Yocto image with device update agent embedded.

# Yocto Layers, Recipes, and Configuration

There are three main areas that will be covered:

* Yocto build configurations
* Meta-azure-device-update recipe
* Image install with A/B partitions

## Yocto build configurations

This section describes the most important files of the Yocto build, including
'bblayers.conf.sample' and 'local.conf.sample' as well as the Yocto layers that need to be used.

| Layer Name      | Description |
| ------------- | ---------- |
| meta-azure-device-update | Provides the configuration and contains the recipes for installing both the ADU Agent and its dependencies as well as integrating them into the Yocto build layers.|

#### bblayers.conf.sample

Usually this file would be located under `yocto/config-templates/raspberrypi3`.  
The 'bblayers.conf.sample' shows the complete list of Yocto layers included in
the build.

```shell
POKY_BBLAYERS_CONF_VERSION = "3"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
  ##OEROOT##/meta \
  ##OEROOT##/meta-poky \
  ##OEROOT##/meta-yocto-bsp \
  ##OEROOT##/../meta-openembedded/meta-oe \
  ##OEROOT##/../meta-openembedded/meta-multimedia \
  ##OEROOT##/../meta-openembedded/meta-networking \
  ##OEROOT##/../meta-openembedded/meta-python \
  ##OEROOT##/../meta-azure-device-update \
  "
```
