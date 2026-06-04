package com.qft8.morsekeyer.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qft8.morsekeyer.R;
import com.qft8.morsekeyer.lang.LanguageManager;
import com.qft8.morsekeyer.lang.MorseLanguage;

import java.util.List;

public class SummaryView extends LinearLayout {

    public static class SummaryRow {
        public final String labelKey;
        public final String value;

        public SummaryRow(String labelKey, String value) {
            this.labelKey = labelKey;
            this.value = value;
        }
    }

    private final String keyerType;
    private final int wpm;
    private final String timePlayed;
    private final int words;
    private final int score;
    private final int record;
    private final List<SummaryRow> params;
    private final Runnable onRetry;
    private final Runnable onQuit;
    private final Runnable onShare;
    private final boolean darkTheme;
    private final Activity activity;
    private final boolean isInfiniteMode;

    public SummaryView(Activity activity, String keyerType, int wpm, String timePlayed,
                       int words, int score, int record, List<SummaryRow> params,
                       boolean isInfiniteMode, Runnable onRetry, Runnable onQuit, Runnable onShare, boolean darkTheme) {
        super(activity);
        this.activity = activity;
        this.keyerType = keyerType;
        this.wpm = wpm;
        this.timePlayed = timePlayed;
        this.words = words;
        this.score = score;
        this.record = record;
        this.params = params;
        this.isInfiniteMode = isInfiniteMode;
        this.onRetry = onRetry;
        this.onQuit = onQuit;
        this.onShare = onShare;
        this.darkTheme = darkTheme;
        
        buildUI();
    }

    private int dp(float value) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, value,
                getResources().getDisplayMetrics());
    }

    private void buildUI() {
        int bgCol = darkTheme ? 0xFF1A1A1A : 0xFFFFFFFF;
        int textPrimary = darkTheme ? 0xFFFFFFFF : 0xFF000000;
        int textSecondary = darkTheme ? 0xFFAAAAAA : 0xFF555555;
        int surfaceCol = darkTheme ? 0xFF2A2A2A : 0xFFF5F5F5;
        int borderCol = darkTheme ? 0xFF444444 : 0xFFE0E0E0;
        int accentCol = darkTheme ? 0xFF00C0FF : 0xFF0080FF;
        int barCol = darkTheme ? 0xFF2A2A2A : 0xFFDDDDDD;
        int utlCol = darkTheme ? 0xFF444444 : 0xFFD0D0D0;
        
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(bgCol);

        // TOP BAR
        android.widget.FrameLayout topBar = new android.widget.FrameLayout(getContext());
        topBar.setBackgroundColor(barCol);
        topBar.setPadding(dp(3), dp(3), dp(3), dp(3));
        
        TextView title = new TextView(getContext());
        title.setText(LanguageManager.get(MorseLanguage.MATCH_COMPLETED));
        title.setTextColor(textPrimary);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setSingleLine(true);
        title.setEllipsize(android.text.TextUtils.TruncateAt.END);
        
        android.widget.FrameLayout.LayoutParams titleParams = new android.widget.FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        titleParams.leftMargin = dp(60);
        titleParams.rightMargin = dp(60);
        topBar.addView(title, titleParams);

        android.widget.ImageButton btnBack = new android.widget.ImageButton(getContext());
        btnBack.setImageResource(R.drawable.ic_arrow_back);
        btnBack.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnBack.setPadding(dp(12), dp(12), dp(12), dp(12));
        btnBack.setColorFilter(darkTheme ? 0xFFFFFFFF : 0xFF000000);
        btnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
        btnBack.setOnClickListener(v -> {
            if (onQuit != null) onQuit.run();
        });
        
        android.widget.FrameLayout.LayoutParams backBtnParams = new android.widget.FrameLayout.LayoutParams(dp(54), dp(54));
        backBtnParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
        topBar.addView(btnBack, backBtnParams);



        // Flash overlay for visual indicator
        View flashOverlay = new View(getContext());
        flashOverlay.setBackgroundColor(0xFFFFFFFF);
        flashOverlay.setVisibility(View.GONE);
        flashOverlay.setTag("summary_flash_overlay");
        topBar.addView(flashOverlay, new android.widget.FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        addView(topBar, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, dp(60)));

        // SCROLL VIEW FOR CONTENT
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setFillViewport(true);

        LinearLayout rootContainer = new LinearLayout(getContext());
        rootContainer.setOrientation(LinearLayout.HORIZONTAL);
        rootContainer.setGravity(Gravity.CENTER_VERTICAL);
        
        View spacerLeft = new View(getContext());
        rootContainer.addView(spacerLeft, new LinearLayout.LayoutParams(0, 1, 0.1f));

        LinearLayout root = new LinearLayout(getContext());
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(0, dp(24), 0, dp(24));
        
        rootContainer.addView(root, new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.8f));
        
        View spacerRight = new View(getContext());
        rootContainer.addView(spacerRight, new LinearLayout.LayoutParams(0, 1, 0.1f));

        // 1. MATCH SETTINGS CARD
        LinearLayout paramsCard = createCard(surfaceCol, borderCol);
        TextView paramsHeader = new TextView(getContext());
        paramsHeader.setText(LanguageManager.get(MorseLanguage.MATCH_SETTINGS));
        paramsHeader.setTextColor(textSecondary);
        paramsHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        paramsHeader.setTypeface(Typeface.DEFAULT_BOLD);
        paramsHeader.setLetterSpacing(0.05f);
        LinearLayout.LayoutParams paramsHeaderParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        paramsHeaderParams.bottomMargin = dp(8);
        paramsCard.addView(paramsHeader, paramsHeaderParams);

        String translatedKeyerType = "Iambic A";
        if ("straight".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_STRAIGHT);
        else if ("iambic-a".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_IAMBIC_A);
        else if ("iambic-b".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_IAMBIC_B);
        else if ("ultimatic".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_ULTIMATIC);
        else if ("bug".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_BUG);
        else if ("cootie".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_COOTIE);

        if (keyerType != null) {
            addStatRow(paramsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.KEY_MODE), translatedKeyerType);
        }
        addStatRow(paramsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.WPM_SPEED), String.valueOf(wpm));
        for (SummaryRow row : params) {
            addStatRow(paramsCard, textPrimary, textSecondary, LanguageManager.get(row.labelKey), row.value);
        }

        LinearLayout.LayoutParams paramsCardViewParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        paramsCardViewParams.bottomMargin = dp(28);

        // 2. MATCH RESULTS CARD
        LinearLayout statsCard = createCard(surfaceCol, borderCol);
        TextView statsHeader = new TextView(getContext());
        statsHeader.setText(LanguageManager.get(MorseLanguage.MATCH_RESULTS));
        statsHeader.setTextColor(textSecondary);
        statsHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        statsHeader.setTypeface(Typeface.DEFAULT_BOLD);
        statsHeader.setLetterSpacing(0.05f);
        LinearLayout.LayoutParams statsHeaderParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        statsHeaderParams.bottomMargin = dp(8);
        statsCard.addView(statsHeader, statsHeaderParams);

        addStatRow(statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim(), String.valueOf(score));
        boolean timeWeird = isInfiniteMode || !timePlayed.equals("3:00");
        addStatRow(statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.TIME).replace(":", "").trim(), timePlayed, timeWeird);
        LinearLayout.LayoutParams statsCardParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        statsCardParams.bottomMargin = dp(20);
        
        root.addView(statsCard, statsCardParams);
        root.addView(paramsCard, paramsCardViewParams);

        // HIGH SCORE TEXT
        if (!isInfiniteMode) {
            TextView highScoreTxt = new TextView(getContext());
            highScoreTxt.setText(LanguageManager.get(MorseLanguage.YOUR_HIGH_SCORE_IS) + " " + record);
            highScoreTxt.setTextColor(textSecondary);
            highScoreTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            highScoreTxt.setGravity(Gravity.CENTER);
            highScoreTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams highScoreParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            highScoreParams.bottomMargin = dp(24);
            root.addView(highScoreTxt, highScoreParams);
        }

        // BUTTONS ROW
        LinearLayout buttonsRow = new LinearLayout(getContext());
        buttonsRow.setOrientation(LinearLayout.HORIZONTAL);
        buttonsRow.setWeightSum(2f);
        
        // QUIT BUTTON
        TextView quitBtn = new TextView(getContext());
        quitBtn.setText(LanguageManager.get(MorseLanguage.QUIT_GAME));
        quitBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        quitBtn.setTypeface(Typeface.DEFAULT_BOLD);
        quitBtn.setGravity(Gravity.CENTER);
        quitBtn.setPadding(dp(16), dp(18), dp(16), dp(18));
        quitBtn.setTextColor(textPrimary);
        GradientDrawable quitBg = new GradientDrawable();
        quitBg.setShape(GradientDrawable.RECTANGLE);
        quitBg.setCornerRadius(dp(16));
        quitBg.setColor(surfaceCol);
        quitBg.setStroke(dp(1), borderCol);
        quitBtn.setBackground(quitBg);
        quitBtn.setOnClickListener(v -> {
            if (onQuit != null) onQuit.run();
        });
        LinearLayout.LayoutParams quitParams = new LinearLayout.LayoutParams(
                0, LayoutParams.WRAP_CONTENT, 1f);
        quitParams.rightMargin = dp(6);
        buttonsRow.addView(quitBtn, quitParams);

        // RETRY BUTTON
        TextView retryBtn = new TextView(getContext());
        retryBtn.setText(LanguageManager.get(MorseLanguage.TRY_AGAIN));
        retryBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        retryBtn.setTypeface(Typeface.DEFAULT_BOLD);
        retryBtn.setTextColor(textPrimary);
        retryBtn.setGravity(Gravity.CENTER);
        retryBtn.setPadding(dp(16), dp(18), dp(16), dp(18));

        GradientDrawable retryBg = new GradientDrawable();
        retryBg.setShape(GradientDrawable.RECTANGLE);
        retryBg.setCornerRadius(dp(16));
        retryBg.setColor(darkTheme ? 0xFF444444 : 0xFFCCCCCC);
        retryBtn.setBackground(retryBg);

        retryBtn.setOnClickListener(v -> {
            if (onRetry != null) onRetry.run();
        });

        LinearLayout.LayoutParams retryParams = new LinearLayout.LayoutParams(
                0, LayoutParams.WRAP_CONTENT, 1f);
        retryParams.leftMargin = dp(6);
        buttonsRow.addView(retryBtn, retryParams);

        LinearLayout.LayoutParams buttonsRowParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        root.addView(buttonsRow, buttonsRowParams);

        // SHARE BUTTON
        ImageView shareBtn = new ImageView(getContext());
        shareBtn.setImageResource(R.drawable.ic_share);
        shareBtn.setColorFilter(textPrimary);
        shareBtn.setPadding(dp(12), dp(12), dp(12), dp(12));

        GradientDrawable shareBg = new GradientDrawable();
        shareBg.setShape(GradientDrawable.RECTANGLE);
        shareBg.setCornerRadius(dp(12));
        shareBg.setColor(surfaceCol);
        shareBg.setStroke(dp(1), borderCol);
        shareBtn.setBackground(shareBg);

        shareBtn.setOnClickListener(v -> {
            if (onShare != null) onShare.run();
        });

        LinearLayout.LayoutParams shareParams = new LinearLayout.LayoutParams(
                dp(56), dp(56));
        shareParams.gravity = Gravity.END;
        shareParams.topMargin = dp(32);
        root.addView(shareBtn, shareParams);

        scrollView.addView(rootContainer);
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, 0, 1f);
        addView(scrollView, scrollParams);

        boolean showPaddles = activity.getSharedPreferences("morseKeyerSettings", Context.MODE_PRIVATE).getBoolean("showPaddles", true);
        if (showPaddles) {
            LinearLayout pContainer = new LinearLayout(getContext());
            pContainer.setOrientation(LinearLayout.HORIZONTAL);
            pContainer.setBackgroundColor(barCol);
            pContainer.setTag("summary_paddle_container");
            
            TextView pLeft = new TextView(getContext());
            pLeft.setBackgroundColor(darkTheme ? 0xFF444444 : 0xFFD0D0D0);
            pLeft.setGravity(Gravity.CENTER);
            pLeft.setTextColor(textPrimary);
            pLeft.setTypeface(null, Typeface.BOLD);
            pLeft.setTag("summary_paddle_left");
            
            View pDiv = new View(getContext());
            pDiv.setBackgroundColor(darkTheme ? 0xFF666666 : 0xFFCCCCCC);
            pDiv.setTag("summary_paddle_divider");
            
            TextView pRight = new TextView(getContext());
            pRight.setBackgroundColor(darkTheme ? 0xFF555555 : 0xFFC0C0C0);
            pRight.setGravity(Gravity.CENTER);
            pRight.setTextColor(textPrimary);
            pRight.setTypeface(null, Typeface.BOLD);
            pRight.setTag("summary_paddle_right");
            
            LinearLayout.LayoutParams lpLeft = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);
            LinearLayout.LayoutParams lpDiv = new LinearLayout.LayoutParams(dp(2), LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams lpRight = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);
            
            pContainer.addView(pLeft, lpLeft);
            pContainer.addView(pDiv, lpDiv);
            pContainer.addView(pRight, lpRight);
            
            addView(pContainer, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, dp(124)));
        }
    }

    private LinearLayout createCard(int surfaceCol, int borderCol) {
        LinearLayout card = new LinearLayout(getContext());
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(16), dp(16), dp(16));

        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setCornerRadius(dp(12));
        bg.setColor(surfaceCol);
        bg.setStroke(dp(1), borderCol);
        card.setBackground(bg);

        return card;
    }

    private void addStatRow(LinearLayout parent, int textPrimary, int textSecondary, String label, String value) {
        addStatRow(parent, textPrimary, textSecondary, label, value, false);
    }

    private void addStatRow(LinearLayout parent, int textPrimary, int textSecondary, String label, String value, boolean highlight) {
        LinearLayout row = new LinearLayout(getContext());
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, dp(4), 0, dp(4));

        TextView labelView = new TextView(getContext());
        labelView.setText(label);
        labelView.setTextColor(textSecondary);
        labelView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(
                0, LayoutParams.WRAP_CONTENT, 1f);
        row.addView(labelView, labelParams);

        TextView valueView = new TextView(getContext());
        valueView.setText(value);
        valueView.setTextColor(highlight ? 0xFFFF0000 : textPrimary);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        valueView.setTypeface(Typeface.DEFAULT_BOLD);
        valueView.setGravity(Gravity.END);
        row.addView(valueView, new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        parent.addView(row);
    }
}
