#!/bin/bash

# Configuration
VERSION_FILE="VERSION"
BUILD_DIR="build"


echo "========================================"
echo "Morse Training Build Script"
echo "========================================"

echo "Cleaning up previous builds"
./clean.sh
echo """"

# 1. Check for local.properties
if [ ! -f "local.properties" ]; then
    echo "ERROR: local.properties not found!"
    echo "Please create local.properties with SDK location and signing keys:"
    echo "sdk.dir=/path/to/android/sdk"
    echo "storeFile=/path/to/keystore.jks"
    echo "storePassword=..."
    echo "keyAlias=..."
    echo "keyPassword=..."
    exit 1
fi

# 2. Extract Version
if [ -f "$VERSION_FILE" ]; then
    VERSION=$(cat "$VERSION_FILE" | xargs)
else
    echo "ERROR: VERSION file not found!"
    exit 1
fi

if [ -f "CODE_VERSION" ]; then
    CODE_VERSION=$(cat "CODE_VERSION" | xargs)
else
    CODE_VERSION="1"
fi

TIMESTAMP=$(date +"%Y%m%d-%H%M%S")
APK_NAME="MorseTraining-v${VERSION}-b${CODE_VERSION}-${TIMESTAMP}.apk"
AAB_NAME="MorseTraining-v${VERSION}-b${CODE_VERSION}-${TIMESTAMP}.aab"

echo "Version: $VERSION"
echo "Code Version: $CODE_VERSION"
echo "Timestamp: $TIMESTAMP"
echo ""

# 3. Run Unit Tests
echo "Running Unit Tests..."
./run_tests.sh
if [ $? -ne 0 ]; then
    echo "Unit Tests Failed! Aborting build."
    exit 1
fi
echo ""



# 5. Build Release Artifacts
echo "Building Release Packages..."
./gradlew assembleRelease bundleRelease
if [ $? -ne 0 ]; then
    echo "Build Failed!"
    exit 1
fi

# 5.5 Verify 16KB Page Size Compatibility
echo "Verifying 16KB Compatibility..."
./verify_16k.sh release
if [ $? -ne 0 ]; then
    echo "❌ 16KB Verification Failed!"
    exit 1
fi
echo ""

# 6. Copy and Rename Artifacts
echo "Copying artifacts..."
mkdir -p "$BUILD_DIR"

# Source paths (standard Android Gradle plugin output)
SRC_APK="app/build/outputs/apk/release/app-release.apk"
SRC_AAB="app/build/outputs/bundle/release/app-release.aab"

if [ -f "$SRC_APK" ]; then
    cp "$SRC_APK" "$BUILD_DIR/$APK_NAME"
    echo "Created: $BUILD_DIR/$APK_NAME"
else
    echo "WARNING: APK not found at $SRC_APK"
fi

if [ -f "$SRC_AAB" ]; then
    cp "$SRC_AAB" "$BUILD_DIR/$AAB_NAME"
    echo "Created: $BUILD_DIR/$AAB_NAME"
else
    echo "WARNING: AAB not found at $SRC_AAB"
fi

echo ""
echo "========================================"
echo "Signature Verification"
echo "========================================"

# Locate SDK and apksigner
SDK_DIR=$(grep "^sdk.dir" "local.properties" | cut -d'=' -f2)
if [ -d "$SDK_DIR" ]; then
    APKSIGNER=$(find "$SDK_DIR/build-tools" -name apksigner | sort -r | head -n 1)
    if [ -x "$APKSIGNER" ]; then
        echo "Found apksigner at: $APKSIGNER"
    else
        echo "WARNING: apksigner not found in $SDK_DIR/build-tools"
        APKSIGNER=""
    fi
else
    echo "WARNING: Could not parse sdk.dir from local.properties"
    APKSIGNER=""
fi

# Verify AAB
if [ -f "$BUILD_DIR/$AAB_NAME" ]; then
    echo "Verifying AAB Signature..."
    
    # 1. Integrity Check
    if command -v jarsigner &> /dev/null; then
        jarsigner -verify "$BUILD_DIR/$AAB_NAME"
        if [ $? -eq 0 ]; then
            echo "AAB Integrity Checked: Valid."
        else
            echo "AAB Integrity Check Failed!"
        fi
    else
        echo "WARNING: jarsigner not found for integrity check."
    fi

    # 2. Print Certificate Details
    if command -v keytool &> /dev/null; then
        echo "AAB Certificate Details:"
        keytool -printcert -jarfile "$BUILD_DIR/$AAB_NAME"
    else
        echo "WARNING: keytool not found, cannot display certificate info."
    fi
fi

echo ""

# Verify APK
if [ -f "$BUILD_DIR/$APK_NAME" ]; then
    echo "Verifying APK Signature..."
    if [ -n "$APKSIGNER" ]; then
        "$APKSIGNER" verify --verbose --print-certs "$BUILD_DIR/$APK_NAME"
    else
        echo "Skipping apksigner check (tool not found)."
    fi
fi

echo ""
echo "========================================"
echo "Build Complete Successfully"
echo "========================================"
