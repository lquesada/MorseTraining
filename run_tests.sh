#!/bin/bash
echo "Building Project..."
bash ./gradlew assembleDebug
if [ $? -ne 0 ]; then
    echo "ERROR: Build Failed! Aborting tests."
    exit 1
fi

echo "Running Unit Tests..."
bash ./gradlew test
if [ $? -ne 0 ]; then
    echo ""
    echo "========================================"
    echo "UNIT TESTS FAILED"
    exit 1
fi

echo ""
echo "========================================"
echo "ALL UNIT TESTS PASSED"
