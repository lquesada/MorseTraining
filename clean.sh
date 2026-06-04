#!/bin/bash

echo "========================================"
echo "Cleaning Project"
echo "========================================"

# Directories to remove
rm -rf build
rm -rf app/build
rm -rf bin
rm -rf .gradle
rm -rf src_test_env
rm -rf app/.cxx

# Files to remove
rm -f crash.log
rm -f emulator_log.txt
rm -f emulator_stable.log
# no! don't remove this one :) rm -f local.properties

# Remove generated test output (if any other location)
# (None identified outside of bin/ or src_test_env/)

echo "Clean Complete."
echo "Removed: build, app/build, bin, .gradle, src_test_env, app/.cxx, logs"
echo "========================================"
