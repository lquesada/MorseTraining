package com.qft8.morsekeyer;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class SquareCheckBoxDrawable extends Drawable {
    private final int size;
    private final float cornerRadius;
    private final float strokeWidth;
    private final float checkStrokeWidth;

    private int uncheckedStrokeColor;
    private int checkedBoxColor;
    private int checkColor;

    private boolean isChecked = false;
    private boolean isPressed = false;
    private boolean isEnabled = true;

    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();
    private final Path checkPath = new Path();

    public SquareCheckBoxDrawable(float density, int uncheckedStrokeColor, int checkedBoxColor, int checkColor) {
        this((int) (20 * density + 0.5f), 2.5f * density, 1.8f * density, 2.2f * density,
                uncheckedStrokeColor, checkedBoxColor, checkColor);
    }

    public SquareCheckBoxDrawable(int size, float cornerRadius, float strokeWidth, float checkStrokeWidth,
                                  int uncheckedStrokeColor, int checkedBoxColor, int checkColor) {
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.strokeWidth = strokeWidth;
        this.checkStrokeWidth = checkStrokeWidth;
        this.uncheckedStrokeColor = uncheckedStrokeColor;
        this.checkedBoxColor = checkedBoxColor;
        this.checkColor = checkColor;
    }

    public void setColors(int uncheckedStrokeColor, int checkedBoxColor, int checkColor) {
        this.uncheckedStrokeColor = uncheckedStrokeColor;
        this.checkedBoxColor = checkedBoxColor;
        this.checkColor = checkColor;
        invalidateSelf();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        if (this.isChecked != checked) {
            this.isChecked = checked;
            invalidateSelf();
        }
    }

    @Override
    public int getIntrinsicWidth() {
        return size;
    }

    @Override
    public int getIntrinsicHeight() {
        return size;
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public boolean setState(int[] stateSet) {
        boolean changed = onStateChange(stateSet);
        return super.setState(stateSet) || changed;
    }

    @Override
    protected boolean onStateChange(int[] state) {
        boolean checked = false;
        boolean pressed = false;
        boolean enabled = true;

        if (state != null) {
            enabled = false;
            for (int s : state) {
                if (s == android.R.attr.state_checked) {
                    checked = true;
                } else if (s == android.R.attr.state_pressed) {
                    pressed = true;
                } else if (s == android.R.attr.state_enabled) {
                    enabled = true;
                }
            }
        }

        boolean changed = (checked != isChecked) || (pressed != isPressed) || (enabled != isEnabled);
        if (changed) {
            this.isChecked = checked;
            this.isPressed = pressed;
            this.isEnabled = enabled;
            invalidateSelf();
            return true;
        }
        return super.onStateChange(state);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float w = bounds.width();
        float h = bounds.height();
        if (w <= 0 || h <= 0) return;

        float boxSize = Math.min(Math.min(w, h), size);
        float l = bounds.left + (w - boxSize) / 2f;
        float t = bounds.top + (h - boxSize) / 2f;
        float r = l + boxSize;
        float b = t + boxSize;

        int alpha = isEnabled ? 255 : 100;

        if (isChecked) {
            rect.set(l, t, r, b);
            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(checkedBoxColor);
            paint.setAlpha(alpha);
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);

            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(checkStrokeWidth);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setColor(checkColor);
            paint.setAlpha(alpha);

            float p1x = l + boxSize * 0.27f;
            float p1y = t + boxSize * 0.52f;
            float p2x = l + boxSize * 0.44f;
            float p2y = t + boxSize * 0.70f;
            float p3x = l + boxSize * 0.75f;
            float p3y = t + boxSize * 0.31f;

            checkPath.reset();
            checkPath.moveTo(p1x, p1y);
            checkPath.lineTo(p2x, p2y);
            checkPath.lineTo(p3x, p3y);
            canvas.drawPath(checkPath, paint);
        } else {
            float halfStroke = strokeWidth / 2f;
            rect.set(l + halfStroke, t + halfStroke, r - halfStroke, b - halfStroke);
            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(strokeWidth);
            int strokeColor = isPressed ? checkedBoxColor : uncheckedStrokeColor;
            paint.setColor(strokeColor);
            paint.setAlpha(alpha);
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public void setTintList(ColorStateList tint) {
        // No-op to preserve distinct square checkbox colors across OEM themes
    }

    @Override
    public void setTintMode(PorterDuff.Mode tintMode) {
        // No-op
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public Drawable mutate() {
        return this;
    }
}
