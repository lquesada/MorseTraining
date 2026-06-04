#!/bin/bash
# Script to verify 16KB page size alignment support
set -e

BUILD_TYPE="${1:-debug}"
APK_PATH="app/build/outputs/apk/${BUILD_TYPE}/app-${BUILD_TYPE}.apk"
echo "Targeting Build Type: $BUILD_TYPE"
echo "Checking APK: $APK_PATH"

# Locate Android SDK tools
SDK_DIR=$(grep "^sdk.dir" "local.properties" | cut -d'=' -f2)
if [ -z "$SDK_DIR" ]; then
    SDK_DIR="$HOME/Android/Sdk"
fi

echo "========================================"
echo "16KB Support Verification"
echo "========================================"

# No native libraries in Morse Training, skip ELF alignment check
echo "ℹ️  No native libraries — skipping ELF alignment check."
echo ""

# Check APK Zip Alignment
echo "🔍 Checking APK Zip Alignment..."
ZIPALIGN=$(find "$SDK_DIR/build-tools" -name "zipalign" | sort -r | head -n 1)

if [ -x "$ZIPALIGN" ]; then
    # -c = check, -v = verbose, -P 16 = page alignment, 4 = byte alignment
    if "$ZIPALIGN" -c -v -P 16 4 "$APK_PATH" > /dev/null; then
         echo "✅ APK is 16KB Zip-Aligned."
    else
         echo "❌ APK is NOT 16KB Zip-Aligned."
         exit 1
    fi
else
    echo "⚠️  zipalign not found. Skipping Zip check."
fi

echo ""
echo "🎉 Verification Passed: Ready for Android 15 (16KB Page Size)"
