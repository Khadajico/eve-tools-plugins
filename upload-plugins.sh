#!/bin/bash

cd target/netbeans_site
for i in `ls`; do curl -T $i -u $FTP_USER:$FTP_PASS ftp://$FTP_SERVER/eve-tools-plugins; done
