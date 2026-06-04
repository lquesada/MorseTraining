# Morse Training

Morse Training is a native Android application designed to provide a highly responsive, high-fidelity Morse code practice environment.

Homepage: [morsetraining.com](https://morsetraining.com)

## Features

- **Sample-Accurate Timing:** Uses a custom audio-loop slaved state machine to guarantee mathematically perfect dit and dah lengths. Immune to OS thread jitter and GC pauses.
- **Keying Logic:** Supports 6 distinct keying modes: Straight Key, Iambic A, Iambic B, Ultimatic, Cootie (sideswiper), and Bug (semi-automatic).
- **Click-Free Audio:** Features a real-time `AudioTrack` synthesizer with a 5ms exponential envelope to eliminate digital clicks during key down/up.
- **Hardware Integration:**
  - Multi-touch capable on-screen paddles.
  - Full support for external USB keyboards and physical Morse adapters mapping to keystrokes.
  - Implements Pre-IME interception to prevent the Android soft keyboard from aggressively consuming hardware events.
- **Real-Time Decoding:** Visual Morse code interpretation into text, supporting both strict timing mode and flexible timing mode.
- **Configurable Settings:** Adjustable Words Per Minute (WPM), audio frequency, audio waveform (Triangle or Sawtooth), volume, and paddle polarity.

## Supported Keyer Modes (Deep Dive)

Morse Training includes reference-grade implementations of six classical and modern keyer behaviors. Below is an in-depth analysis of their operating logic, timing dynamics, and source-level implementation.

---

### 1. Straight Key (`straight`)

#### How It Works
The **Straight Key** is the most basic, traditional form of manual keying. The audio output directly mirrors the physical contact state: when the key is pressed, the tone sounds; when the key is released, the tone stops. The operator manually controls the precise duration of every dit, dah, and element/character/word spacing.

To facilitate real-time textual decoding, the keyer measures the elapsed time of each manual activation. When the key is released, the system classifies the duration:
- If the duration is shorter than the midpoint between a standard dit and dah ($(\text{ditLength} + \text{dahLength}) / 2$), it registers as a dit (`.`).
- Otherwise, it registers as a dah (`-`).

#### Implementation Snippet
```java
public void handleStraightKey(boolean isPressed) {
    if (isPressed) {
        clearTimingTimeouts();
        if (!state.isTransmitting) {
            state.isTransmitting = true;
            toneEngine.setToneActive(true);
            notifyVisual(true);
            state.lastElementTime = System.currentTimeMillis();
        }
    } else {
        if (state.isTransmitting) {
            state.isTransmitting = false;
            toneEngine.setToneActive(false);
            notifyVisual(false);

            long now = System.currentTimeMillis();
            final double[] timings = getRecognitionTimings();

            long duration = now - (long) state.lastElementTime;
            String element = duration < (timings[0] + timings[1]) / 2 ? "." : "-";
            state.currentCode += element;
            state.lastElementTime = now;
            setupLetterWordTimeouts();
        }
    }
}
```

---

### 2. Iambic Mode A (`iambic-a`)

#### How It Works
An **Iambic** (or squeeze) keyer uses dual paddles: one for dits (typically left) and one for dahs (typically right). Squeezing both paddles simultaneously produces an alternating sequence of dits and dahs (`.-.-.-` or `-.-.-.`), depending on which paddle was closed first.

In **Iambic Mode A**, the keyer checks the state of the paddles only at the end of the currently playing element (dit or dah). If both paddles are released before the current element finishes, the keyer stops immediately without sending any further elements. This means the operator must "squeeze" slightly longer to ensure the alternating element is sent.

#### Implementation Snippet
In Iambic A, memory registers are cleared completely at the beginning of each element, meaning no squeeze state is stored outside of active contact:
```java
// Reset memory — must match reference exactly per mode
if ("iambic-a".equals(settings.mode)) {
    state.ditPressedDuringElement = false;
    state.dahPressedDuringElement = false;
}
```
The state machine resolves the next element via `determineNextElement()` at the end of the element:
```java
private String determineNextElement() {
    boolean ditHeld = state.ditCurrentlyPressed;
    boolean dahHeld = state.dahCurrentlyPressed;
    boolean squeezeHeld = ditHeld && dahHeld;
    boolean squeezeActive = squeezeHeld || ("iambic-b".equals(settings.mode) && state.squeezePressedDuringElement);

    boolean ditMemory = state.ditPressedDuringElement;
    boolean dahMemory = state.dahPressedDuringElement;

    // 1. Priority: Squeeze / Alternation
    if (squeezeActive ||
       (".".equals(state.lastElement) && ditHeld && dahMemory) ||
       ("-".equals(state.lastElement) && dahHeld && ditMemory)) {
        return ".".equals(state.lastElement) ? "-" : ".";
    }
    // 2. Priority: Current Press (if only one held)
    else if (ditHeld) return ".";
    else if (dahHeld) return "-";

    return null; // Stops immediately if nothing held or stored
}
```

---

### 3. Iambic Mode B (`iambic-b`)

#### How It Works
**Iambic Mode B** is identical to Mode A when paddles are held or squeezed continuously. However, it differs in its squeeze release memory. If both paddles are squeezed and then released *during* the transmission of an element, Mode B remembers this squeeze event. 

Upon completion of the current element, the keyer will automatically append one final, opposite element (a "trailing" element) before coming to a stop. For example, squeezing and releasing both paddles during a dit will automatically produce a dit followed by a dah (`.-`), making it easier to send characters like `C` (`-.-.`) with fewer distinct physical squeeze movements.

#### Implementation Snippet
The keyer implements this by saving the squeeze state in `squeezePressedDuringElement` and preserving paddle press memories during the active element:
```java
// Inside prepareElementState (for modes other than iambic-a)
if (".".equals(state.lastElement)) {
    state.ditPressedDuringElement = false;
} else {
    state.ditPressedDuringElement = state.ditCurrentlyPressed;
}
if ("-".equals(state.lastElement)) {
    state.dahPressedDuringElement = false;
} else {
    state.dahPressedDuringElement = state.dahCurrentlyPressed;
}

// Squeeze memory for the NEXT element
state.squeezePressedDuringElement = state.squeezeCurrentlyPressed;
```
If `squeezePressedDuringElement` is true at the element boundary, `squeezeActive` resolves to `true` inside `determineNextElement()`, triggering an alternating trailing element even if both physical paddles have already been released.

---

### 4. Ultimatic (`ultimatic`)

#### How It Works
The **Ultimatic** keyer is a dual-paddle mode designed to simplify keying by employing a "last-paddle-wins" priority mechanism. Unlike Iambic modes, squeezing both paddles together does not produce alternating dits and dahs. Instead, holding both paddles results in a continuous repeat of the element corresponding to the **most recently pressed paddle**.

For example:
1. Press and hold the dit paddle: `......` is sent.
2. While continuing to hold the dit paddle, press and hold the dah paddle: the keyer immediately stops sending dits and starts repeating dahs (`------`).
3. Release the dah paddle while still holding the dit paddle: the keyer immediately resumes repeating dits (`......`).

This makes sending letters like `A` (`.-`) or `N` (`-.`) extremely fluid, as you can simply overlay one paddle press on top of another.

#### Implementation Snippet
The keyer tracks the last paddle pressed in `handlePaddlePress()` as `state.ultimaticLastPaddle`. Simultaneous presses are resolved in `determineNextUltimaticElement()`:
```java
private String determineNextUltimaticElement() {
    boolean ditHeld = state.ditCurrentlyPressed;
    boolean dahHeld = state.dahCurrentlyPressed;
    boolean squeezeHeld = ditHeld && dahHeld;
    
    if (squeezeHeld) {
        return state.ultimaticLastPaddle; // Most recently pressed paddle wins
    } else if (ditHeld) {
        return ".";
    } else if (dahHeld) {
        return "-";
    }
    // Fall back to memory registers if tapped during an element
    else if (state.ditPressedDuringElement && state.dahPressedDuringElement) {
        return state.ultimaticLastPaddle;
    } else if (state.ditPressedDuringElement) {
        return ".";
    } else if (state.dahPressedDuringElement) {
        return "-";
    }
    return null;
}
```

---

### 5. Cootie Key / Sideswiper (`cootie`)

#### How It Works
A **Cootie Key** (historically called a *sideswiper*) uses a dual-paddle or double-sided single lever that is wired in parallel. Operationally, both paddles act as simple straight keys connected in an `OR` configuration. The tone is active if *either* paddle is pressed, or if *both* are pressed.

Unlike Iambic or Ultimatic modes, there is no automatic timing. The operator manually forms all dits and dahs by alternating strokes between the left and right sides. This mechanical distribution reduces hand fatigue, giving the transmitted code a unique rhythmic swing (known as "sideswiper juice"). Real-time text decoding uses the same midpoint classification logic as the straight key when all paddles are fully released.

#### Implementation Snippet
```java
private void handleCootieKey() {
    boolean anyPressed = state.ditCurrentlyPressed || state.dahCurrentlyPressed;
    if (anyPressed) {
        clearTimingTimeouts();
        if (!state.isTransmitting) {
            state.isTransmitting = true;
            toneEngine.setToneActive(true);
            notifyVisual(true);
            state.lastElementTime = System.currentTimeMillis();
        }
    } else {
        if (state.isTransmitting) {
            state.isTransmitting = false;
            toneEngine.setToneActive(false);
            notifyVisual(false);

            long now = System.currentTimeMillis();
            final double[] timings = getRecognitionTimings();

            long duration = now - (long) state.lastElementTime;
            String element = duration < (timings[0] + timings[1]) / 2 ? "." : "-";
            state.currentCode += element;
            state.lastElementTime = now;
            setupLetterWordTimeouts();
        }
    }
}
```

---

### 6. Bug / Semi-Automatic (`bug`)

#### How It Works
A **Bug** (famously manufactured by Vibroplex) is a semi-automatic mechanical keyer. It features asymmetric controls to automate dits while keeping dahs fully manual:
- **Dit Side (typically left):** Holding this side activates a pendulum mechanism that generates a continuous, automatic string of timed, perfectly spaced dits (`......`).
- **Dah Side (typically right):** Works exactly like a straight key. Closing it generates a continuous tone for as long as the operator holds it down, allowing manual control of dah duration.

#### Implementation & Transition Logic
Because this is a dual-paddle system combining automatic and manual elements, the keyer handles transition states carefully:
1. **Dah to Dit Transition:** If the manual key (dah) is released while the dit paddle is held, the keyer stops the key tone, classifies the element, waits for a standard inter-element gap (one dit length), and then automatically resumes generating timed dits.
2. **Dit to Dah Transition:** If the manual key (dah) is pressed while an automatic dit is playing, the keyer finishes the active dit and its trailing gap, cancels any queued subsequent dits, and immediately transitions to a continuous manual key tone.

#### Implementation Snippet
Checking paddle states and scheduling automatic dits during the dit-side silence gap:
```java
private void updateQueuedBugElement() {
    if (state.ditCurrentlyPressed && !state.dahCurrentlyPressed) {
        final double[] timings = getTransmissionTimings();
        double toneDuration = timings[0];
        double silenceDuration = timings[2];

        toneEngine.queueNextElement(toneDuration, silenceDuration,
                this::onQueuedBugDitStart,
                this::onBugDitToneEnd,
                this::onBugDitSilenceEnd);
    } else {
        toneEngine.cancelQueuedElement();
    }
}
```
Handling manual dah key state changes and rescheduling automatic dits on release:
```java
private void handleBugKeyStateChange(boolean dahJustPressed, boolean dahJustReleased) {
    if (dahJustPressed) {
        if (state.bugKeyActive) return;

        if (state.isTransmitting || state.iambicScheduled) {
            // Dit in progress — cancel the next queued automatic dit
            toneEngine.cancelQueuedElement();
        } else {
            bugStartKeyTone();
        }
    } else if (dahJustReleased) {
        if (!state.bugKeyActive) return;

        bugStopKeyTone();

        // If the dit paddle is still held, schedule automatic dits after the gap
        if (state.ditCurrentlyPressed) {
            final double[] timings = getTransmissionTimings();
            long gapMs = (long) timings[2];
            state.isTransmitting = true;
            timingHandler.postDelayed(() -> {
                state.isTransmitting = false;
                if (state.ditCurrentlyPressed && !state.dahCurrentlyPressed) {
                    handleBugDitPress();
                }
            }, gapMs);
        }
    }
}
```

---

## Requirements

- **Android Studio** (for building)
- An Android device running Android 5.0 (API level 21) or higher.

## Building and Running

This project uses Gradle. A suite of shell scripts is provided for ease of use:

- `./clean.sh` - Cleans the build environment.
- `./run_device.sh` - Builds the app and installs the debug APK on a connected device via ADB.
- `./run_tests.sh` - Executes the full suite of local unit tests (verifies logic and sample-accurate timing).
- `./deploy.sh` - Builds the production release bundle.

Alternatively, open the `MorseKeyer` folder in Android Studio and build the project using the standard IDE tools.

## Development

Create a `local.properties` file in the project root with the following content (adjust paths and passwords for your local SDK and signing keys):

```properties
sdk.dir=/home/[USER]/Android/Sdk
storeFile=/home/[USER]/[PATH]/[FILE].jks
storePassword=[PASS]
keyAlias=[ALIAS]
keyPassword=[PASS]
```

## Architecture

At its core, Morse Training completely foregoes Android's asynchronous `Handler.postDelayed()` scheduling for Morse timing. Instead, the `ToneEngine` uses a background thread to generate PCM samples and calculates exact elapsed time. It invokes a synchronous `AudioTickCallback` back to the `MorseKeyer` state machine at approximately 5ms intervals. This ensures perfect rhythm and spacing regardless of Android system load.

## AI-Assisted Development

This application has been extensively developed leveraging Large Language Models (LLMs) for coding assistance. While the architecture, design, and testing are human-driven, significant portions of the codebase, documentation, and logic have been generated, refactored, or refined utilizing artificial intelligence.

## License

qFT8 is **Source-Available** software. Its license is intentionally more restrictive than standard Open Source Initiative (OSI) licenses to protect the amateur radio community. It explicitly prohibits commercial exploitation by individuals or companies, ensuring the software remains a free resource for radio amateurs.

By using this software, you agree to the conditions in the [LICENSE](LICENSE) file, including the non-commercial limitations and liability disclaimers.

---

Created by Luis Quesada Torres ([github.com/lquesada](https://github.com/lquesada)).
