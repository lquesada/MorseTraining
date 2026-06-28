# Morse Training - Internal Documentation

## Settings & Persistence

### Default Values
All settings must have defined default values in `MorseSettings.java`. These defaults are used:
1. On the very first run of the app.
2. When the user clicks the **Reset to defaults** button.

Current defaults:
- **Key mode**: Iambic A
- **Strict timing**: Enabled
- **Words Per Minute**: 15
- **Volume**: 40%
- **Frequency**: 600 Hz
- **Tone Type**: Triangle
- **App Theme**: System setting
- **Text color**: Green
- **Text font size**: 28 (Slider: 13 - 60)
- **Table font size**: Default 0 delta (Slider: -5 - +5)
- **Ratio of table to text screen**: 50% (Slider: 20% - 80%)
- **Interletter spacing**: 100% (Slider: 10% - 500%)
- **Interword spacing**: 100% (Slider: 10% - 500%)
- **Next word indicators**: Enabled
- **Advanced Performance**: 25ms Buffer, 0.75ms Envelope, 4ms Chunk.

### Reset to Defaults Logic
The reset button in `MainActivity.java` performs the following atomic operations:
1. Calls `settings.resetToDefaults()`.
2. Saves the new settings to `SharedPreferences`.
3. Notifies the `ToneEngine` of hardware parameter changes (buffer, envelope, chunk).
4. Calls `applyTheme()` and `applyUiSettings()` to refresh the main screen.
5. Calls `syncSettingsDialog()` to update the open settings dialog widgets.
6. Rebuilds the Morse table if it's currently visible.

## UI Styling & Themes

### Theme Application
The app supports Dark, Light, and System themes. Theme switching is handled dynamically without destroying the activity or the settings dialog:
- `applyTheme()`: Updates color tokens (`C_BG`, `C_TEXT`, etc.) and applies them to the main layout.
- `updateDialogTheme()`: Recursively traverses the settings dialog view tree to apply theme colors to all widgets.
- **Status Bar**: The OS status bar is forced to stay **Black** with white icons across all themes to ensure visibility of system indicators (clock, battery).

### Typography
The app uses the **Roboto Mono** font (`roboto_mono.ttf`) for the Morse output screen and the Morse table to provide clear, slashed zeros and precise character alignment.

## Audio Engine Optimization

### Latency
The `ToneEngine` is optimized for sub-20ms latency on modern Android devices:
- Uses `AudioTrack.getNativeOutputSampleRate()` to avoid system resampling.
- Sets `android.os.Process.THREAD_PRIORITY_AUDIO` for the synthesis loop.
- Uses `USAGE_GAME` attributes to request the "Fast Track" mixer path.

### Click Prevention
To prevent digital clicks during rapid keying:
- Implements a configurable **Exponential Envelope** (Rise/Fall time).
- Resets the waveform phase only when the gain is near zero to ensure smooth transitions.

## Android Multi-Button Mouse Input Handling

### The Problem: Fragmented Event Pipelines
Handling simultaneous independent mouse buttons (e.g., holding Left click while tapping Right click) is notoriously difficult on Android due to an architectural flaw in how the OS routes mouse `MotionEvent`s:
1. **Initial Click (Touch Pipeline):** When the first mouse button is pressed, Android treats it as a standard finger touch and routes it through `dispatchTouchEvent()`.
2. **Subsequent Clicks (Generic Motion Pipeline):** When a second button is pressed while the first is held, Android re-categorizes the interaction as an `ACTION_BUTTON_PRESS`. This event is explicitly **omitted** from the Touch pipeline and is instead routed to `dispatchGenericMotionEvent()`.
3. **Stationary Pointer Drops:** If the mouse pointer coordinates do not change between clicks, `ViewRootImpl` and `ViewGroup` hierarchies may actively drop or filter out the generic motion events, preventing them from ever reaching a `View.onTouchListener`.

### The Master `handleMouseInput` Solution
To achieve true, browser-like independent multi-click processing, MorseKeyer implements a master window-level interceptor in `MainActivity.java`:

1. **Dual-Pipeline Interception:** Both `dispatchTouchEvent(MotionEvent)` and `dispatchGenericMotionEvent(MotionEvent)` are overridden at the Activity level. This catches the raw OS events before any `ViewGroup` filters drop them.
2. **Unified State Tracking:** Both overrides feed into a single `handleMouseInput(MotionEvent)` function.
3. **Hardcore Bitmask Override:** Android's high-level `event.getButtonState()` is often stale when a second button is pressed or released without cursor movement. To fix this, the app manually reconstructs the bitmask using the low-level `event.getActionButton()` hardware flag:
   ```java
   if (action == MotionEvent.ACTION_BUTTON_PRESS) {
       btnState |= event.getActionButton();
   } else if (action == MotionEvent.ACTION_BUTTON_RELEASE) {
       btnState &= ~event.getActionButton();
   }
   ```
4. **Flawless Reset:** To prevent stuck states caused by missed generic events, `btnState` is unconditionally reset to `0` whenever `ACTION_UP` or `ACTION_CANCEL` is received.

## Morse Keying Algorithm Reference

This section fully documents the six keying modes — **Straight Key**, **Iambic A**, **Iambic B**, **Ultimatic**, **Bug (Semi-Automatic)**, and **Cootie (Sideswiper)** — with enough detail for anyone to write a compatible keyer from scratch, in any language or platform.

---

### 1. Glossary

| Term | Definition |
|---|---|
| **Dit** (`.`) | The short element. Duration = 1 dit unit. |
| **Dah** (`-`) | The long element. Duration = 3 dit units. |
| **Element gap** | Silent gap between consecutive elements *within the same letter*. Duration = 1 dit unit. |
| **Letter gap** | Silent gap between letters. Duration = 3 dit units (strict). |
| **Word gap** | Silent gap between words. Duration = 7 dit units (strict). |
| **Dit unit** | The fundamental time unit: `1200 / WPM` milliseconds (PARIS standard). At 15 WPM → 80 ms. |
| **Squeeze** | Both paddles held simultaneously. |
| **Memory flag** | A boolean that records whether a paddle was *pressed at any point* during the current element + gap cycle (i.e. while `isTransmitting == true` OR `iambicScheduled == true`). |
| **Polarity** | Mapping of physical paddle sides to dit/dah. "Normal" = left→dit, right→dah. "Reverse" = left→dah, right→dit. |

---

### 2. Timing Calculations

All timing derives from a single value: the **dit unit length**.

```
ditUnit = 1200.0 / WPM    (in milliseconds)
```

#### 2.1 Transmission Timings (used for element generation)

These are always strict — the keyer auto-generates elements at exact standard durations:

| Timing | Value |
|---|---|
| Dit duration | `ditUnit` |
| Dah duration | `ditUnit × 3` |
| Element gap (inter-element silence) | `ditUnit` |
| Letter gap | `ditUnit × 3` |
| Word gap | `ditUnit × 7` |

#### 2.2 Recognition Timings (used for character/word decode)

These timings determine when accumulated elements (e.g. `.-`) are decoded into a character, and when a word boundary is inserted. They can be adjusted by the user:

| Timing | Value |
|---|---|
| Letter gap | `max(ditUnit × 3 × interletterFactor, ditUnit × 0.5)` |
| Word gap | `max(ditUnit × 7 × interwordFactor, letterGap + ditUnit × 0.5)` |

- In **strict mode**, `interletterFactor = 1.0` and `interwordFactor = 1.0` (standard PARIS).
- In **non-strict mode**, factors come from user settings (percentage / 100). The `max()` clamps prevent nonsensical zero or negative gaps, and ensure word gap is always at least 0.5 dit-units longer than letter gap.

---

### 3. State Variables

A keyer implementation needs the following mutable state:

#### 3.1 Morse Decode State

| Variable | Type | Initial | Purpose |
|---|---|---|---|
| `currentCode` | String | `""` | Accumulator of the current letter's elements (e.g. `".-"` for A). Reset after decode. |
| `lastElementTime` | Timestamp | `0` | When the last element ended (for straight key duration measurement). |
| `isTransmitting` | Boolean | `false` | `true` while an element's tone is actively playing. |
| `lastElement` | String | `""` | The most recently sent element (`"."` or `"-"`). Used by iambic alternation logic. |
| `iambicScheduled` | Boolean | `false` | `true` during the inter-element gap, while the next `handleIambic()` call is pending. |

#### 3.2 Paddle State (Iambic modes only)

| Variable | Type | Initial | Purpose |
|---|---|---|---|
| `ditCurrentlyPressed` | Boolean | `false` | Whether the dit paddle is physically held **right now**. |
| `dahCurrentlyPressed` | Boolean | `false` | Whether the dah paddle is physically held **right now**. |
| `ditPressedDuringElement` | Boolean | `false` | **Memory**: was the dit paddle pressed at *any* point during the current element+gap cycle? |
| `dahPressedDuringElement` | Boolean | `false` | **Memory**: was the dah paddle pressed at *any* point during the current element+gap cycle? |
| `squeezeCurrentlyPressed` | Boolean | `false` | Derived: `ditCurrentlyPressed AND dahCurrentlyPressed`. Updated on every press/release. |
| `squeezePressedDuringElement` | Boolean | `false` | **Memory**: was a squeeze active at *any* point during the current element+gap cycle? |
| `isWordGapPending` | Boolean | `false` | Whether a word-gap indicator is being shown (UI concern, not algorithm). |

---

### 4. Paddle Input Processing (Common to All Modes)

When a paddle press or release event arrives, the following steps execute **before** any mode-specific logic:

#### 4.1 On Press (`isPressed == true`)

1. **Map physical side to logical function** using polarity:
   - If polarity is `normal`: left → dit, right → dah.
   - If polarity is `reverse`: left → dah, right → dit.

2. **Set the `currentlyPressed` flag** for the resolved function:
   - e.g. `ditCurrentlyPressed = true`

3. **Set the memory flag if currently busy**:
   - If `isTransmitting == true` OR `iambicScheduled == true`, then also set the corresponding `pressedDuringElement` flag:
     - e.g. `ditPressedDuringElement = true`
   - This is the **tap memory** — it captures presses that occur *while another element is still playing or its gap is still running*. Without this, rapid taps between elements would be lost.

#### 4.2 On Release (`isPressed == false`)

1. **Map physical side to logical function** (same polarity logic).
2. **Clear the `currentlyPressed` flag**:
   - e.g. `ditCurrentlyPressed = false`
   - Note: the `pressedDuringElement` flag is **NOT** cleared on release. It persists until the iambic engine consumes it.

#### 4.3 Squeeze State Update (every press or release)

After every event:
```
squeezeCurrentlyPressed = ditCurrentlyPressed AND dahCurrentlyPressed
if squeezeCurrentlyPressed AND (isTransmitting OR iambicScheduled):
    squeezePressedDuringElement = true
```

#### 4.4 Mode Dispatch

After updating all flags:

- **Straight mode**: If the left paddle was the event source, call `handleStraightKey(isPressed)`. Right paddle is ignored in straight mode.
- **Iambic A, Iambic B, or Ultimatic**: If this is a press AND `isTransmitting == false`, call the respective handler (`handleIambic()` or `handleUltimatic()`). (Releases never trigger the engine; the scheduler handles continuation.)
- **Bug**: The dit-side (left paddle / `ditCurrentlyPressed`) uses timed dit elements like Iambic single-paddle behavior. The key-side (right paddle / `dahCurrentlyPressed`) uses straight-key continuous tone. See §6.9.

---

### 5. Straight Key Algorithm

The straight key is the simplest mode. The operator controls element timing manually — tone plays for exactly as long as the key is held.

#### 5.1 On Press

1. Cancel any pending letter/word recognition timeouts.
2. If not already transmitting:
   - Set `isTransmitting = true`.
   - Start tone.
   - Record `lastElementTime = now`.

#### 5.2 On Release

1. If transmitting:
   - Set `isTransmitting = false`.
   - Stop tone.
   - Measure `duration = now - lastElementTime`.
   - Classify the element:
     ```
     threshold = (ditDuration + dahDuration) / 2
     element = duration < threshold ? "." : "-"
     ```
     This places the threshold at 2 dit-units — any press shorter than that is a dit, longer is a dah.
   - Append `element` to `currentCode`.
   - Record `lastElementTime = now`.
   - Start letter/word recognition timeouts (see §7).

#### 5.3 Key Insight

In straight key mode, there is **no automatic element generation**. The keyer is purely a classifier — it measures how long you held the key and decides whether it was a dit or a dah. Character/word boundaries are detected by silence duration.

---

### 6. Automatic Keyer Algorithms (Iambic A, B, and Ultimatic)

These modes share the same fundamental timing and self-scheduling engine, but differ in how they decide which element to send next.

The engine is a **self-scheduling recursive loop**: `handleIambic()` decides what element to send, sends it, then schedules itself to run again after the element+gap completes.

#### 6.1 Guard

```
if isTransmitting OR iambicScheduled:
    return   // Do nothing — an element is in flight or its gap is running
```

This is critical. It prevents re-entry. The engine runs *exactly one element at a time*, with `handleIambic()` re-invoked only after both the element duration and the inter-element gap have elapsed.

#### 6.2 Compute Active Inputs

Read the current and remembered paddle states:

```
ditHeld  = ditCurrentlyPressed
dahHeld  = dahCurrentlyPressed
squeezeHeld = ditHeld AND dahHeld

// Mode-specific squeeze detection:
if mode == "iambic-a":
    squeezeActive = squeezeHeld                          // must be held NOW
if mode == "iambic-b":
    squeezeActive = squeezeHeld OR squeezePressedDuringElement   // remembered

ditMemory = ditPressedDuringElement
dahMemory = dahPressedDuringElement
```

#### 6.3 Priority-Based Element Selection

The engine uses a strict three-tier priority to decide what to send:

**Priority 1 — Squeeze / Alternation** (highest):
```
if squeezeActive
   OR (lastElement == "." AND ditHeld AND dahMemory)
   OR (lastElement == "-" AND dahHeld AND ditMemory):
    elementToSend = (lastElement == ".") ? "-" : "."
```
This handles:
- **Pure squeeze**: Both paddles held → alternate from whatever was last sent.
- **Cross-memory**: One paddle is held and the other was tapped during the previous element → alternate. This catches the common case where the operator releases one paddle and taps the other during the element's active period.

The sub-conditions `(lastElement == "." AND ditHeld AND dahMemory)` and `(lastElement == "-" AND dahHeld AND ditMemory)` ensure alternation only triggers when it makes physical sense: the *currently held* paddle matches the element just sent, and the *opposite* paddle was tapped (memorized). This prevents false triggers.

**Priority 2 — Single Paddle Held** (if no squeeze):
```
else if ditHeld:
    elementToSend = "."
else if dahHeld:
    elementToSend = "-"
```
This handles single-paddle repeats (holding the dit paddle generates continuous dits).

**Priority 3 — Memory Only** (nothing currently held):
```
else if ditMemory:
    elementToSend = "."
else if dahMemory:
    elementToSend = "-"
```
This captures "tap-and-release" — the operator tapped a paddle while an element was playing and has already released it. The memory flag ensures it isn't lost.

**No element**:
```
else:
    // Nothing to send. If currentCode is non-empty, start recognition timeouts.
    return
```

#### 6.4 Commit the Element

Once `elementToSend` is determined:

1. **Clear recognition timeouts** (a new element is being sent, so any pending decode is premature).
2. **Set `isTransmitting = true`**.
3. **Set `lastElement = elementToSend`** (record what we're about to send for next iteration's alternation logic).

#### 6.5 Reset Memory Flags (MODE-SPECIFIC — THIS IS THE CRITICAL DIFFERENCE)

##### Iambic A Memory Reset

```
ditPressedDuringElement = false
dahPressedDuringElement = false
```

**Both** memory flags are unconditionally cleared. This means:
- If the operator releases both paddles during an element, **nothing is queued** for the next cycle.
- Squeeze alternation stops *immediately* when both paddles are released — no "extra" element is produced.
- This is the traditional "clean stop" behavior preferred by operators who want tight control.

##### Iambic B Memory Reset

```
if lastElement == ".":
    ditPressedDuringElement = false          // clear the sent element's memory
else:
    ditPressedDuringElement = ditCurrentlyPressed   // reset opposite to CURRENT state

if lastElement == "-":
    dahPressedDuringElement = false          // clear the sent element's memory
else:
    dahPressedDuringElement = dahCurrentlyPressed   // reset opposite to CURRENT state
```

The logic is asymmetric:
- The flag for the element being **sent** is always cleared (consumed).
- The flag for the **opposite** element is reset to its **current physical state** — if the opposite paddle is currently held, the memory stays set.

This means:
- If the operator had both paddles squeezed and releases during an element, the opposite paddle's memory may still be set, causing **one additional alternation** after release. This is the defining "extra element" of Iambic B.
- The result is that a quick squeeze-and-release always completes the *current element plus one more*, giving a smoother feel for characters like C (`-.-.`) when both paddles are briefly squeezed.

#### 6.6 Squeeze Memory for Next Cycle

After resetting dit/dah memory, update squeeze memory:
```
squeezePressedDuringElement = squeezeCurrentlyPressed
```
This seeds the next iteration: if a squeeze is currently active, the next `handleIambic()` call will see it even if the operator releases before the gap ends.

#### 6.7 Tone Generation and Scheduling

```
duration = (elementToSend == ".") ? ditDuration : dahDuration

// 1. Start tone
startTone()

// 2. Schedule tone stop after element duration
after(duration):
    stopTone()
    isTransmitting = false
    currentCode += lastElement        // Append to the decode accumulator
    lastElementTime = now
    setupLetterWordTimeouts()         // Start recognition timer immediately

    // 3. Schedule next iambic cycle after inter-element gap
    iambicScheduled = true
    after(elementGap):
        iambicScheduled = false
        handleIambic()                // Recursive — checks paddles again
```

The two-phase scheduling is essential:
1. **Element phase** (`duration` ms): Tone plays. `isTransmitting = true`. Any paddle press during this time sets memory flags.
2. **Gap phase** (`elementGap` ms): Silence. `iambicScheduled = true`. Paddle presses **still set memory flags** (because the guard checks `iambicScheduled` too). This prevents lost inputs during the gap.
3. **Re-entry**: After the gap, `handleIambic()` runs again. If no paddle is pressed and no memory is set, the loop terminates naturally — it simply returns without doing anything. **Critically, it must NOT call `setupLetterWordTimeouts()` in this case**, because the recognition timers set in step 2 are already running with the correct reference point (end-of-tone). Restarting them here would add an extra dit-unit to the effective letter/word gap.

Note: Recognition timeouts (`setupLetterWordTimeouts()`) are started as soon as the element's tone ends (step 2), **not** after the inter-element gap. This ensures character recognition begins counting from the moment of silence, which is the semantically correct reference point. If another element is subsequently sent, the timeout is cancelled by `clearTimingTimeouts()` in step 1 of the next cycle. If the re-entry finds nothing to send, the existing timers are left undisturbed.

#### 6.8 Ultimatic Mode Logic

Ultimatic mode (developed by W6SRY) follows a **"last paddle pressed wins"** rule when both paddles are squeezed, instead of the alternating behavior of Iambic modes.

**Element Selection Priority:**
1. **Squeeze**: If both paddles are physically held (`ditHeld AND dahHeld`), return `ultimaticLastPaddle` (the logical element of the most recent press event).
2. **Single Paddle**: If only one paddle is held, return that element.
3. **Memory**: If no paddle is held but memory flags are set, return `ultimaticLastPaddle` if both were tapped during the previous cycle, otherwise the single tapped element.

**Memory Reset:**
Like Iambic A, Ultimatic mode clears **both** `ditPressedDuringElement` and `dahPressedDuringElement` flags immediately after an element is dispatched. This provides a "clean stop" — the keyer stops sending as soon as all paddles are released, without producing extra trailing elements.

---

### 7. Character and Word Recognition

After each element ends (in any mode), recognition timeouts are set up:

```
function setupLetterWordTimeouts():
    clearTimingTimeouts()       // Cancel any previous pending timeouts
    timings = getRecognitionTimings()

    // 1. Letter timeout
    after(timings.letterGap):
        if currentCode is not empty AND NOT isTransmitting:
            decode(currentCode)          // Look up in reverse Morse table
            currentCode = ""
            
            // 2. Word timeout (starts AFTER letter is decoded)
            after(timings.wordGap - timings.letterGap):
                if NOT isTransmitting AND currentCode is empty:
                    emit(" ")            // Insert word space
```

Key behaviors:
- The letter timeout fires `letterGap` ms after the last element ended.
- The word timeout fires `wordGap` ms after the last element ended (split as `letterGap + (wordGap - letterGap)` for sequential scheduling).
- Both are cancelled if a new element starts before they fire.
- If the decoded character is not found in the Morse table, `[?]` is emitted (unknown sequence).

---

### 8. Complete Lifecycle: Example Walkthrough

#### 8.1 Sending the letter "C" (`-.-.`) with Iambic A squeeze

1. Operator squeezes both paddles simultaneously.
2. `handlePaddlePress("left", true)` → `ditCurrentlyPressed = true`.
3. `handlePaddlePress("right", true)` → `dahCurrentlyPressed = true`, `squeezeCurrentlyPressed = true`.
4. Since `!isTransmitting`, `handleIambic()` is called.
5. `squeezeActive = true` (both held). `lastElement = ""` → `elementToSend = "."` (default when no prior element).
6. Tone plays for `ditUnit` ms. Memory flags cleared. `currentCode = "."`.
7. After gap: `handleIambic()` runs. `squeezeActive = true`, `lastElement = "."` → `elementToSend = "-"`. `currentCode = ".-"`.
8. After gap: `handleIambic()`. `squeezeActive = true`, `lastElement = "-"` → `elementToSend = "."`. `currentCode = ".-."`.
9. **Operator releases both paddles during element 3.**
10. After gap: `handleIambic()`. `squeezeActive = false` (Iambic A — must be held). No paddle held, no memory. **Returns without sending.** `currentCode = ".-."`.
11. Wait... but `".-."` is R, not C. The operator needs to keep squeezing through the 4th element!

Correct "C" execution: Operator holds squeeze through all 4 elements, or releases only after element 4 has been committed.

#### 8.2 Same "C" with Iambic B squeeze

Steps 1-9 identical. But at step 10:
10. `handleIambic()`. `squeezeActive = squeezeHeld(false) OR squeezePressedDuringElement(true) = true`. `lastElement = "."` → `elementToSend = "-"`. **One extra alternation occurs.** `currentCode = "-.-."`.
11. After gap: `handleIambic()`. Now `squeezePressedDuringElement` was reset to `squeezeCurrentlyPressed (false)` in step 6.6. No inputs. Stops. `currentCode = "-.-."` is decoded as "C".

This illustrates the fundamental difference: Iambic B produces one additional alternating element after squeeze release, which makes it more forgiving for characters with even numbers of elements.

---

### 9. Summary of Behavioral Differences

| Behavior | Straight | Iambic A | Iambic B | Ultimatic | Bug | Cootie |
|---|---|---|---|---|---|---|
| Element timing | Manual (operator controls duration) | Automatic | Automatic | Automatic | Dits: automatic; Key: manual | Manual |
| Squeeze behavior | N/A | Alternating (while held) | Alternating (held/remem.) | **Last-pressed wins** | Key side overrides dits | Both paddles = same key |
| Extra element after release | N/A | No | Yes (one extra) | No | No | N/A |
| Dit memory reset | N/A | Both flags cleared | Sent flag cleared | Both flags cleared | N/A (not used) | N/A |
| Dah memory reset | N/A | Both flags cleared | Sent flag cleared | Both flags cleared | N/A (not used) | N/A |
| Tap memory | N/A | Captured | Captured | Captured | Not used | N/A |
| Number of paddles | 1 (left only) | 2 | 2 | 2 | 2 | 2 |

---

#### 6.9 Bug (Semi-Automatic) Mode Logic

The Bug mode emulates a mechanical semi-automatic key ("Vibroplex" / "Bug"). It is a hybrid mode where one paddle produces automatic timed elements and the other acts as a manual straight key.

**Paddle Roles:**
- **Dit side** (left paddle in normal polarity): Produces automatic, WPM-timed dits — identical to single-paddle dit behavior in Iambic A. Hold the paddle and dits repeat with standard dit-length tone and dit-length gap.
- **Key side** (right paddle in normal polarity): Produces a continuous tone for as long as held — identical to the straight key. On release, the held duration is classified as dit or dah using the same threshold as straight key (`(ditDuration + dahDuration) / 2`).

**State Machine:**

| State | Dit pressed | Key pressed | Behavior |
|---|---|---|---|
| Idle | press | — | Start automatic dit sequence |
| Idle | — | press | Start continuous tone (straight key) |
| Dit element playing | — | press | Cancel queued next dit; current dit finishes, then transition to continuous tone |
| Dit element playing | release | — | Current dit finishes, no next element queued → idle |
| Key tone active | press | held | Continuous tone continues (dit side is ignored while key is active) |
| Key tone active | held | release | Stop tone, classify duration, insert dit-length gap, then start dits |
| Key tone active | — | release | Stop tone, classify duration → idle |

**Transition: Dit → Key (both held)**

When the key side is pressed while dits are playing:
1. The currently queued next dit element is cancelled.
2. The current dit tone + gap finishes naturally.
3. When the gap ends, the callback detects `dahCurrentlyPressed == true` and starts continuous tone via `toneEngine.setToneActive(true)`.
4. Dit sequence halts completely.

**Transition: Key → Dit (key released, dit still held)**

When the key side is released while the dit side is still held:
1. The continuous tone stops immediately.
2. Character recognition runs on the key-side duration.
3. A dit-length gap is scheduled (using `timingHandler.postDelayed`).
4. After the gap, if the dit paddle is still held and the key is not, automatic dits resume.

**Memory Reset:**
Bug mode does not use the dit/dah memory flags (`ditPressedDuringElement`, `dahPressedDuringElement`) or squeeze logic. The dit side uses only `ditCurrentlyPressed` to decide whether to queue another dit, and the key side uses only `dahCurrentlyPressed` for press/release detection. This simplicity is intentional — a real mechanical bug has no memory or squeeze interaction.

**UI Differences:**
- The right paddle label shows **"Key"** instead of the dash symbol ("–").
- When polarity is inverse, the labels swap: left shows "Key", right shows "·".

---

#### 6.10 Cootie (Sideswiper) Mode Logic

The Cootie mode emulates a sideswiper key. It is functionally a straight key with two physical inputs — both paddles produce the same continuous tone.

**Behavior:**
- **Either or both paddles pressed:** Tone is on. The keyer uses OR logic — if `ditCurrentlyPressed OR dahCurrentlyPressed`, the tone is active.
- **Neither paddle pressed:** Tone is off. Character recognition runs exactly as in straight key mode: the held duration is classified as dit or dah using the `(ditDuration + dahDuration) / 2` threshold.
- **Polarity:** Has no effect (both paddles are identical). The "Inverse paddles" setting is disabled in the UI when Cootie mode is selected.

**UI Differences:**
- Both paddle labels show **"Key"** (36sp text size).
- The inverse paddles checkbox is grayed out.

---

### 10. Implementation Notes

1. **Timer resolution**: The keyer relies on millisecond-precision timers. On mobile platforms, use the highest-resolution timer available (e.g. `System.currentTimeMillis()` or `performance.now()`). Jitter above ~5ms will noticeably affect feel at high WPM.

2. **Re-entrancy guard**: The `isTransmitting || iambicScheduled` guard in `handleIambic()` is essential. Without it, rapid paddle presses can cause overlapping elements. Every paddle press event calls `handleIambic()`, but only the first one (when idle) actually starts the loop.

3. **Memory flag window**: Memory flags are set not only during tone (`isTransmitting`) but also during the inter-element gap (`iambicScheduled`). This is critical — at high speeds, the gap is very short (e.g. 24ms at 50 WPM), and an operator pressing a paddle during this window expects the keyer to catch it.

4. **Polarity is an input mapping concern**: Polarity swapping is handled entirely in the input layer (`handlePaddlePress`). The iambic engine always works in terms of `dit` and `dah`, never `left` and `right`.

5. **Recognition vs transmission timings**: Transmission timings (for auto-generating element durations) are always strict PARIS standard. Recognition timings (for decode) can be relaxed by the user. This separation allows operators to practice with forgiving decode while still hearing properly-timed elements.

6. **Thread safety**: If your platform processes paddle input on a different thread than the timer callbacks, you must synchronize access to all state variables. In this implementation, everything runs on the main thread via `Handler(Looper.getMainLooper())`.
