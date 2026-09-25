#!/bin/bash
# Which phone/device to install on. Prints the chosen serial on stdout;
# everything else goes to stderr, so callers can do:
#   SERIAL="$("$(dirname "$0")/tools/pick_device.sh" "$@")" || exit 1
#
# The order is: a serial given as an argument, then $MORSE_DEVICE / $QFT8_DEVICE / $ANDROID_SERIAL,
# then -- if only one device is attached -- that one, and otherwise a numbered menu.
set -u

ADB="${ADB:-$HOME/Android/Sdk/platform-tools/adb}"
[ -x "$ADB" ] || ADB="$(command -v adb 2>/dev/null)"
if [ -z "${ADB:-}" ] || [ ! -x "$ADB" ]; then
    echo "adb not found (looked in ~/Android/Sdk/platform-tools and on PATH)." >&2
    exit 1
fi

# Attached and ready: "<serial>\tdevice ...". Anything else (unauthorized, offline, no permissions)
# is not something we can install on.
SERIALS=()
LABELS=()
while IFS= read -r line; do
    case "$line" in
        ""|"List of devices attached"*) continue ;;
    esac
    serial="$(echo "$line" | awk '{print $1}')"
    state="$(echo "$line" | awk '{print $2}')"
    [ "$state" = "device" ] || continue
    model="$(echo "$line" | tr ' ' '\n' | sed -n 's/^model://p')"
    [ -n "$model" ] || model="unknown model"
    SERIALS+=("$serial")
    LABELS+=("$(echo "$model" | tr '_' ' ')  ($serial)")
done < <("$ADB" devices -l 2>/dev/null)

want="${1:-${MORSE_DEVICE:-${QFT8_DEVICE:-${ANDROID_SERIAL:-}}}}"
if [ -n "$want" ]; then
    for s in "${SERIALS[@]:-}"; do
        if [ "$s" = "$want" ]; then
            echo "$s"
            exit 0
        fi
    done
    echo "Device '$want' is not attached (or not authorized)." >&2
    [ "${#SERIALS[@]}" -gt 0 ] && printf '  attached: %s\n' "${LABELS[@]}" >&2
    exit 1
fi

if [ "${#SERIALS[@]}" -eq 0 ]; then
    echo "No device found. Connect one and enable USB debugging (check: $ADB devices -l)." >&2
    exit 1
fi

if [ "${#SERIALS[@]}" -eq 1 ]; then
    echo "Using ${LABELS[0]}" >&2
    echo "${SERIALS[0]}"
    exit 0
fi

echo "Several devices are attached:" >&2
for i in "${!SERIALS[@]}"; do
    echo "  $((i + 1))) ${LABELS[$i]}" >&2
done

while true; do
    printf 'Install on which one? [1-%d, q to quit]: ' "${#SERIALS[@]}" >&2
    # From stdin, so a terminal, a pipe and a here-doc all work. Nothing to read (a script, CI, or
    # a closed stdin) means no choice was made: fail and let the caller pass a serial instead.
    if ! read -r answer; then
        echo >&2
        echo "No choice given. Pass a serial, or set MORSE_DEVICE." >&2
        exit 1
    fi
    case "$answer" in
        q|Q) echo "Cancelled." >&2; exit 1 ;;
        ''|*[!0-9]*) echo "  Not a number." >&2 ;;
        *)
            if [ "$answer" -ge 1 ] && [ "$answer" -le "${#SERIALS[@]}" ]; then
                echo "Using ${LABELS[$((answer - 1))]}" >&2
                echo "${SERIALS[$((answer - 1))]}"
                exit 0
            fi
            echo "  Out of range." >&2
            ;;
    esac
done
