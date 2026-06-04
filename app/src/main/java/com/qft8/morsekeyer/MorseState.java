package com.qft8.morsekeyer;

/**
 * Mutable state object — exact reproduction of morseState and paddleState
 * from index.html.
 */
public class MorseState {

    // morseState fields (from index.html)
    public String currentCode = "";
    public double lastElementTime = 0.0;
    public boolean isTransmitting = false;
    public String lastElement = "";
    public double elementStartTime = 0.0;
    public boolean iambicScheduled = false;

    // paddleState fields (from index.html)
    public boolean ditCurrentlyPressed = false;
    public boolean dahCurrentlyPressed = false;
    public boolean ditPressedDuringElement = false;
    public boolean dahPressedDuringElement = false;
    public boolean squeezeCurrentlyPressed = false;
    public boolean squeezePressedDuringElement = false;
    public boolean isWordGapPending = false;
    public String ultimaticLastPaddle = "";
    public boolean bugKeyActive = false;
    public boolean isSequencePlaying = false;
    public String sequenceCode = "";
    public int sequenceIndex = 0;
}
