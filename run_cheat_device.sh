#!/bin/bash

# Define paths
ANDROID_SDK="$HOME/Android/Sdk"
ADB="$ANDROID_SDK/platform-tools/adb"
[ -x "$ADB" ] || ADB="$(command -v adb 2>/dev/null)"

# With more than one device attached, ask which one instead of failing. A serial can also be
# given as the first argument (or in $MORSE_DEVICE / $QFT8_DEVICE / $ANDROID_SERIAL).
SERIAL="$("$(dirname "$0")/tools/pick_device.sh" "$@")" || exit 1

echo "🔨 Building and installing APK (CHEAT MODE)..."
# We use assembleDebug to build with the cheatMode flag
./gradlew assembleDebug -PcheatMode=true

if [ $? -ne 0 ]; then
    echo "❌ Build failed!"
    exit 1
fi

APK_PATH="app/build/outputs/apk/debug/app-debug.apk"

echo "📦 Installing to $SERIAL..."
if ! $ADB -s "$SERIAL" install -t -r "$APK_PATH"; then
    echo "⚠️  Install refused -- most likely this phone has a build signed with a different key."
    echo "    Replacing it means uninstalling first, which ERASES the app's settings and data"
    echo "    on $SERIAL."
    printf "    Uninstall and install clean? [y/N]: "
    read -r reply
    case "$reply" in
        y|Y|yes|YES)
            $ADB -s "$SERIAL" uninstall com.qft8.morsekeyer 2>/dev/null || true
            $ADB -s "$SERIAL" install -t -r "$APK_PATH" || exit 1
            ;;
        *)
            echo "    Left as it is."
            exit 1
            ;;
    esac
fi

echo "🚀 Launching application..."
$ADB -s "$SERIAL" shell am start -n com.qft8.morsekeyer/.MainActivity
