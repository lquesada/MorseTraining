package com.qft8.morsekeyer;

import org.junit.Test;
import static org.junit.Assert.*;

public class SquareCheckBoxDrawableTest {

    @Test
    public void testDimensions() {
        SquareCheckBoxDrawable drawable = new SquareCheckBoxDrawable(30, 4.0f, 3.0f, 3.5f,
                0xFFAAAAAA, 0xFF007ACC, 0xFFFFFFFF);
        assertEquals(30, drawable.getIntrinsicWidth());
        assertEquals(30, drawable.getIntrinsicHeight());
        assertTrue(drawable.isStateful());
    }

    @Test
    public void testDensityConstructor() {
        float density = 2.0f;
        SquareCheckBoxDrawable drawable = new SquareCheckBoxDrawable(density,
                0xFFAAAAAA, 0xFF007ACC, 0xFFFFFFFF);
        assertEquals(40, drawable.getIntrinsicWidth()); // (int)(20 * 2.0 + 0.5)
        assertEquals(40, drawable.getIntrinsicHeight());
    }

    @Test
    public void testStateChanges() {
        SquareCheckBoxDrawable drawable = new SquareCheckBoxDrawable(30, 4.0f, 3.0f, 3.5f,
                0xFFAAAAAA, 0xFF007ACC, 0xFFFFFFFF);
        assertFalse(drawable.isChecked());

        // Checked state
        int[] checkedState = new int[]{android.R.attr.state_checked, android.R.attr.state_enabled};
        drawable.setState(checkedState);
        assertTrue(drawable.isChecked());

        // Unchecked state
        int[] uncheckedState = new int[]{android.R.attr.state_enabled};
        drawable.setState(uncheckedState);
        assertFalse(drawable.isChecked());

        // Manual setChecked
        drawable.setChecked(true);
        assertTrue(drawable.isChecked());
        drawable.setChecked(false);
        assertFalse(drawable.isChecked());
    }

    @Test
    public void testMutate() {
        SquareCheckBoxDrawable drawable = new SquareCheckBoxDrawable(30, 4.0f, 3.0f, 3.5f,
                0xFFAAAAAA, 0xFF007ACC, 0xFFFFFFFF);
        assertSame(drawable, drawable.mutate());
    }
}
