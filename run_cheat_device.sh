#!/bin/bash

# Define paths
ANDROID_SDK="$HOME/Android/Sdk"
ADB="$ANDROID_SDK/platform-tools/adb"

echo "📱 Checking for connected physical device..."
# -d targets the only connected USB device. Returns error if 0 or >1 devices.
DEVICE_CHECK=$($ADB devices -l | grep -v "emulator" | grep -v "List of devices attached" | grep "device")

if [ -z "$DEVICE_CHECK" ]; then
    echo "❌ No physical device found or authorized. Please connect your phone and enable USB Debugging."
    exit 1
fi

echo "✅ Device found: $DEVICE_CHECK"

echo "🔨 Building and installing APK (CHEAT MODE)..."
# We use assembleDebug to build with the cheatMode flag
./gradlew assembleDebug -PcheatMode=true

if [ $? -ne 0 ]; then
    echo "❌ Build failed!"
    exit 1
fi

APK_PATH="app/build/outputs/apk/debug/app-debug.apk"

echo "📦 Installing to device..."
$ADB -d install -t -r $APK_PATH

echo "🚀 Launching application..."
$ADB -d shell am start -n com.qft8.morsekeyer/.MainActivity
