#!/bin/bash
./gradlew assembleRelease

# Extract sdk.dir from local.properties
SDK_DIR=$(grep "^sdk.dir" local.properties | cut -d'=' -f2)

if [ -z "$SDK_DIR" ]; then
    echo "sdk.dir not found in local.properties. Assuming adb is in PATH."
    ADB="adb"
else
    ADB="$SDK_DIR/platform-tools/adb"
fi

$ADB install -r app/build/outputs/apk/release/app-release.apk
$ADB shell am start -n com.qft8.morsekeyer/.MainActivity
