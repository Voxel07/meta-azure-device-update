DESCRIPTION = "This changes the user group of /etc/fw_version to allow adu-agent to modify it"
LICENCE = "MIT"

do_install_append(){
    chgrp 800 ${D}${sysconfdir}/fw_version
}