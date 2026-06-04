#!/bin/bash

echo "Uninstalling existing application..."
SDK_DIR_KV=$(grep "^sdk.dir" "local.properties" | cut -d'=' -f2)
ADB="${SDK_DIR_KV}/platform-tools/adb"
if [ ! -x "$ADB" ]; then
    ADB=$(which adb)
fi

if [ -x "$ADB" ]; then
    echo "Found adb at $ADB"
    "$ADB" uninstall com.qft8.morsekeyer || true
    echo "Uninstall command finished."
else
    echo "WARNING: adb not found! Skipping uninstall. This may cause 'INSTALL_FAILED_UPDATE_INCOMPATIBLE' errors."
fi
echo ""
