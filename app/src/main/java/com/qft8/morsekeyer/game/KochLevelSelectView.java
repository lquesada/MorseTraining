package com.qft8.morsekeyer.game;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qft8.morsekeyer.lang.LanguageManager;
import com.qft8.morsekeyer.lang.MorseLanguage;
import java.util.function.Consumer;

public class KochLevelSelectView extends FrameLayout {

    public static final String[] KOCH_CHARS = {
        "K", "M", "R", "S", "U", "A", "P", "T", "L", "O",
        "W", "I", ".", "N", "J", "E", "F", "0", "Y", ",",
        "V", "G", "5", "/", "Q", "9", "Z", "H", "3", "8",
        "B", "?", "4", "2", "7", "C", "1", "D", "6", "X"
    };

    private static final int COLS = 4;
    private final int totalLevels = 40;
    private int highestCompletedLevel;
    private final Consumer<Integer> onLevelClick;
    private final Runnable onBackClick;

    private int cBg, cBar, cUtl, cText;
    private boolean isDarkTheme;

    public KochLevelSelectView(Context context, int highestCompletedLevel, Consumer<Integer> onLevelClick, Runnable onBackClick) {
        super(context);
        this.highestCompletedLevel = highestCompletedLevel;
        this.onLevelClick = onLevelClick;
        this.onBackClick = onBackClick;
    }

    public void applyTheme(int cBg, int cBar, int cUtl, int cText, boolean isDarkTheme) {
        this.cBg = cBg;
        this.cBar = cBar;
        this.cUtl = cUtl;
        this.cText = cText;
        this.isDarkTheme = isDarkTheme;
        removeAllViews();
        buildUI();
    }

    private int dp(float value) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, value,
                getResources().getDisplayMetrics());
    }

    private void buildUI() {
        setBackgroundColor(cBg);

        LinearLayout root = new LinearLayout(getContext());
        root.setOrientation(LinearLayout.VERTICAL);

        // TOP BAR
        FrameLayout topBar = new FrameLayout(getContext());
        topBar.setBackgroundColor(cBar);
        topBar.setPadding(dp(3), dp(3), dp(3), dp(3));

        // Back arrow
        android.widget.ImageButton backBtn = new android.widget.ImageButton(getContext());
        backBtn.setImageResource(com.qft8.morsekeyer.R.drawable.ic_arrow_back);
        backBtn.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        backBtn.setPadding(dp(12), dp(12), dp(12), dp(12));
        backBtn.setMinimumWidth(0);
        backBtn.setMinimumHeight(0);
        backBtn.setColorFilter(cText);
        
        // Clone the EXACT background drawable from the game menu button to guarantee identical size/insets
        if (getContext() instanceof android.app.Activity) {
            android.widget.ImageButton template = ((android.app.Activity) getContext()).findViewById(com.qft8.morsekeyer.R.id.game_menu_btn_back);
            if (template != null && template.getBackground() != null) {
                backBtn.setBackground(template.getBackground().getConstantState().newDrawable().mutate());
            }
        }
        backBtn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(cUtl));
        
        backBtn.setOnClickListener(v -> onBackClick.run());

        FrameLayout.LayoutParams backParams = new FrameLayout.LayoutParams(dp(54), dp(54));
        backParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
        topBar.addView(backBtn, backParams);

        // Title
        TextView title = new TextView(getContext());
        title.setText(LanguageManager.get(MorseLanguage.KOCH_METHOD));
        title.setTextColor(cText);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setSingleLine();
        title.setEllipsize(android.text.TextUtils.TruncateAt.END);
        title.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams titleParams = new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        titleParams.gravity = Gravity.CENTER;
        titleParams.leftMargin = dp(56);
        titleParams.rightMargin = dp(56);
        topBar.addView(title, titleParams);

        LinearLayout.LayoutParams topBarParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, dp(60));
        root.addView(topBar, topBarParams);

        // SCROLLABLE LEVEL GRID
        ScrollView scrollView = new ScrollView(getContext());

        LinearLayout gridContainer = new LinearLayout(getContext());
        gridContainer.setOrientation(LinearLayout.VERTICAL);
        gridContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        gridContainer.setPadding(dp(12), dp(24), dp(12), dp(24));

        scrollView.addView(gridContainer);
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, 0, 1f);
        root.addView(scrollView, scrollParams);

        int containerWidth = getResources().getDisplayMetrics().widthPixels;
        int containerPad = dp(24);
        int buttonMargin = dp(4);
        
        final int buttonSize = (containerWidth - containerPad - (buttonMargin * 2 * COLS)) / COLS;
        int actualRows = (int) Math.ceil((double) totalLevels / COLS);

        android.graphics.Typeface mono = androidx.core.content.res.ResourcesCompat.getFont(getContext(), com.qft8.morsekeyer.R.font.roboto_mono);

        for (int row = 0; row < actualRows; row++) {
            LinearLayout rowLayout = new LinearLayout(getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setGravity(Gravity.CENTER);

            for (int col = 0; col < COLS; col++) {
                int level = row * COLS + col + 1;
                if (level > totalLevels) break;

                String newChar = KOCH_CHARS[level - 1];

                TextView btn = new TextView(getContext());
                btn.setText(level + ": " + newChar);
                btn.setTypeface(mono, Typeface.BOLD);
                btn.setGravity(Gravity.CENTER);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, buttonSize * 0.22f);

                GradientDrawable bg = new GradientDrawable();
                bg.setShape(GradientDrawable.OVAL);

                if (level <= highestCompletedLevel) {
                    bg.setColor(isDarkTheme ? 0xFF008800 : 0xFF00AA00); // Green
                    btn.setTextColor(0xFFFFFFFF);
                } else {
                    bg.setColor(isDarkTheme ? 0xFF444444 : 0xFFDDDDDD); // Grey
                    btn.setTextColor(cText);
                }

                btn.setOnClickListener(v -> onLevelClick.accept(level));
                btn.setBackground(bg);

                LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                        buttonSize, buttonSize);
                btnParams.setMargins(buttonMargin, buttonMargin, buttonMargin, buttonMargin);
                rowLayout.addView(btn, btnParams);
            }

            gridContainer.addView(rowLayout);
        }

        // RESET BUTTON
        TextView resetBtn = new TextView(getContext());
        resetBtn.setText(LanguageManager.get(MorseLanguage.RESET_PROGRESS));
        resetBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        resetBtn.setTextColor(0xFFFF0000);
        resetBtn.setPadding(dp(16), dp(16), dp(16), dp(16));
        resetBtn.setGravity(Gravity.CENTER);
        
        android.util.TypedValue outValue = new android.util.TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        resetBtn.setBackgroundResource(outValue.resourceId);

        resetBtn.setOnClickListener(v -> showResetDialog());

        LinearLayout.LayoutParams resetParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        resetParams.topMargin = dp(32);
        gridContainer.addView(resetBtn, resetParams);

        addView(root, new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    private void showResetDialog() {
        int barCol = isDarkTheme ? 0xFF2A2A2A : 0xFFDDDDDD;
        int textCol = isDarkTheme ? 0xFFFFFFFF : 0xFF000000;
        
        FrameLayout overlay = new FrameLayout(getContext());
        overlay.setBackgroundColor(isDarkTheme ? 0xAA000000 : 0x66000000);
        overlay.setOnClickListener(v -> {}); // block clicks
        
        LinearLayout dialog = new LinearLayout(getContext());
        dialog.setOrientation(LinearLayout.VERTICAL);
        dialog.setBackgroundColor(barCol);
        dialog.setPadding(dp(24), dp(24), dp(24), dp(24));
        
        TextView text = new TextView(getContext());
        text.setText(LanguageManager.get(MorseLanguage.RESET_PROGRESS_CONFIRM));
        text.setTextColor(textCol);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        text.setGravity(Gravity.CENTER);
        
        LinearLayout buttons = new LinearLayout(getContext());
        buttons.setOrientation(LinearLayout.HORIZONTAL);
        buttons.setGravity(Gravity.END);
        buttons.setPadding(0, dp(24), 0, 0);
        
        android.util.TypedValue outValue = new android.util.TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        
        TextView btnCancel = new TextView(getContext());
        btnCancel.setText(LanguageManager.get(MorseLanguage.CANCEL));
        btnCancel.setTextColor(textCol);
        btnCancel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        btnCancel.setPadding(dp(16), dp(8), dp(16), dp(8));
        btnCancel.setBackgroundResource(outValue.resourceId);
        btnCancel.setOnClickListener(v -> removeView(overlay));
        
        TextView btnReset = new TextView(getContext());
        btnReset.setText(LanguageManager.get(MorseLanguage.RESET));
        btnReset.setTextColor(0xFFFF0000);
        btnReset.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        btnReset.setPadding(dp(16), dp(8), dp(16), dp(8));
        btnReset.setBackgroundResource(outValue.resourceId);
        btnReset.setOnClickListener(v -> {
            android.content.SharedPreferences prefs = getContext().getSharedPreferences("morseKeyerSettings", android.content.Context.MODE_PRIVATE);
            prefs.edit().putInt("koch_highest_completed_level", 0).apply();
            removeView(overlay);
            // Re-render
            removeAllViews();
            KochLevelSelectView.this.highestCompletedLevel = 0;
            buildUI();
            if (getContext() instanceof com.qft8.morsekeyer.MainActivity) {
                ((com.qft8.morsekeyer.MainActivity)getContext()).gameController.updateLanguage();
            }
        });
        
        buttons.addView(btnCancel);
        buttons.addView(btnReset);
        
        dialog.addView(text);
        dialog.addView(buttons);
        
        FrameLayout.LayoutParams dialogParams = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        dialogParams.gravity = Gravity.CENTER;
        dialogParams.leftMargin = dp(24);
        dialogParams.rightMargin = dp(24);
        
        overlay.addView(dialog, dialogParams);
        
        addView(overlay, new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }
}
