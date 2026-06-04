package com.qft8.morsekeyer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/**
 * Custom root layout that intercepts key events BEFORE the IME.
 * dispatchKeyEventPreIme() is called before InputMethodService gets the event,
 * which is critical for USB keyboard adapters whose keys would otherwise
 * be consumed by the soft keyboard / IME layer.
 */
public class KeyInterceptLayout extends FrameLayout {

    public interface KeyCallback {
        boolean onKeyEventPreIme(KeyEvent event);
    }

    private KeyCallback keyCallback;

    public KeyInterceptLayout(Context context) {
        super(context);
    }

    public KeyInterceptLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyInterceptLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setKeyCallback(KeyCallback callback) {
        this.keyCallback = callback;
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (keyCallback != null && keyCallback.onKeyEventPreIme(event)) {
            return true;
        }
        return super.dispatchKeyEventPreIme(event);
    }
}
