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
    private final Runnable onNextLevel;
    private final Runnable onShare;
    private final boolean darkTheme;
    private final Activity activity;
    private final boolean isInfiniteMode;
    private final boolean isKochMode;
    private final boolean isCustomKochMode;
    private final int kochTarget;
    private final int kochLevel;

    public SummaryView(Activity activity, String keyerType, int wpm, String timePlayed,
                       int words, int score, int record, List<SummaryRow> params,
                       boolean isInfiniteMode, boolean isKochMode, boolean isCustomKochMode, int kochTarget, int kochLevel, Runnable onRetry, Runnable onQuit, Runnable onNextLevel, Runnable onShare, boolean darkTheme) {
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
        this.isKochMode = isKochMode;
        this.isCustomKochMode = isCustomKochMode;
        this.kochTarget = kochTarget;
        this.kochLevel = kochLevel;
        this.onRetry = onRetry;
        this.onQuit = onQuit;
        this.onNextLevel = onNextLevel;
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
        int accentCol = 0xFF007ACC;
        int barCol = darkTheme ? 0xFF2A2A2A : 0xFFDDDDDD;
        int utlCol = darkTheme ? 0xFF444444 : 0xFFD0D0D0;
        
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(bgCol);

        // TOP BAR (Matching game_top_bar exactly)
        LinearLayout topBar = new LinearLayout(getContext());
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setBackgroundColor(barCol);
        topBar.setPadding(dp(3), dp(3), dp(3), dp(3));
        topBar.setGravity(Gravity.CENTER_VERTICAL);
        
        android.widget.ImageButton btnBack = new android.widget.ImageButton(getContext());
        btnBack.setImageResource(R.drawable.ic_arrow_back);
        btnBack.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnBack.setColorFilter(darkTheme ? 0xFFFFFFFF : 0xFF000000);
        
        int pad = dp(12);
        int w = dp(54);
        int h = dp(54);
        int marginEnd = dp(8);
        
        if (getContext() instanceof android.app.Activity) {
            android.widget.ImageButton template = ((android.app.Activity) getContext()).findViewById(com.qft8.morsekeyer.R.id.game_btn_back);
            if (template != null) {
                if (template.getBackground() != null) {
                    btnBack.setBackground(template.getBackground().getConstantState().newDrawable().mutate());
                } else {
                    btnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
                }
                pad = template.getPaddingTop();
                w = template.getLayoutParams().width;
                h = template.getLayoutParams().height;
                if (template.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams) {
                    marginEnd = ((android.view.ViewGroup.MarginLayoutParams) template.getLayoutParams()).rightMargin;
                }
            } else {
                btnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
            }
        } else {
            btnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
        }
        
        btnBack.setMinimumWidth(0);
        btnBack.setMinimumHeight(0);
        btnBack.setPadding(pad, pad, pad, pad);
        
        btnBack.setOnClickListener(v -> {
            if (onQuit != null) onQuit.run();
        });
        
        LinearLayout.LayoutParams backBtnParams = new LinearLayout.LayoutParams(w, h);
        backBtnParams.rightMargin = marginEnd;
        topBar.addView(btnBack, backBtnParams);

        // Spacer
        android.widget.Space space1 = new android.widget.Space(getContext());
        topBar.addView(space1, new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f));

        TextView title = new TextView(getContext());
        title.setText(LanguageManager.get(MorseLanguage.MATCH_COMPLETED));
        title.setTextColor(textPrimary);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setSingleLine(true);
        title.setEllipsize(android.text.TextUtils.TruncateAt.END);
        
        topBar.addView(title, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        // Spacer
        android.widget.Space space2 = new android.widget.Space(getContext());
        topBar.addView(space2, new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f));

        // Dummy view for symmetry (54dp width, 8dp marginStart)
        android.view.View dummyView = new android.view.View(getContext());
        LinearLayout.LayoutParams dummyParams = new LinearLayout.LayoutParams(dp(54), dp(54));
        dummyParams.leftMargin = dp(8);
        topBar.addView(dummyView, dummyParams);

        // Flash overlay for visual indicator
        View flashOverlay = new View(getContext());
        flashOverlay.setBackgroundColor(0xFFFFFFFF);
        flashOverlay.setVisibility(View.GONE);
        flashOverlay.setTag("summary_flash_overlay");
        // Add to a wrapper so flash overlay works over the linear layout
        android.widget.FrameLayout topBarWrapper = new android.widget.FrameLayout(getContext());
        topBarWrapper.addView(topBar, new android.widget.FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, dp(60)));
        topBarWrapper.addView(flashOverlay, new android.widget.FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        addView(topBarWrapper, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, dp(60)));

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

        if (isKochMode) {
            addStatRow(statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim(), score + " / " + kochTarget);
        } else {
            addStatRow(statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim(), String.valueOf(score));
        }
        boolean isStandardTime = timePlayed.equals("3:00") || timePlayed.equals("5:00") || timePlayed.equals("7:00") || timePlayed.equals("10:00") || timePlayed.equals("20:00") || timePlayed.equals("60:00");
        Integer timeColor = null;
        if (isStandardTime) {
            timeColor = 0xFF00C853;
        }
        addStatRow(statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.TIME).replace(":", "").trim(), timePlayed, timeColor);
        LinearLayout.LayoutParams statsCardParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        statsCardParams.bottomMargin = dp(20);
        
        if (isKochMode && !isCustomKochMode) {
            TextView levelTxt = new TextView(getContext());
            levelTxt.setText(LanguageManager.get(MorseLanguage.LEVEL) + ": " + kochLevel);
            levelTxt.setTextColor(textPrimary);
            levelTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            levelTxt.setGravity(Gravity.CENTER);
            levelTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams levelParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            levelParams.bottomMargin = dp(8);
            root.addView(levelTxt, levelParams);

            TextView targetTxt = new TextView(getContext());
            targetTxt.setText(LanguageManager.get(score >= kochTarget ? MorseLanguage.TARGET_MET : MorseLanguage.TARGET_NOT_MET));
            targetTxt.setTextColor(score >= kochTarget ? 0xFF00C853 : 0xFFD50000);
            targetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            targetTxt.setGravity(Gravity.CENTER);
            targetTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams targetParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            targetParams.bottomMargin = dp(24);
            root.addView(targetTxt, targetParams);
        } else if (isKochMode && isCustomKochMode) {
            TextView targetTxt = new TextView(getContext());
            targetTxt.setText(LanguageManager.get(score >= kochTarget ? MorseLanguage.TARGET_MET : MorseLanguage.TARGET_NOT_MET));
            targetTxt.setTextColor(score >= kochTarget ? 0xFF00C853 : 0xFFD50000);
            targetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            targetTxt.setGravity(Gravity.CENTER);
            targetTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams targetParams = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            targetParams.bottomMargin = dp(24);
            root.addView(targetTxt, targetParams);
        }

        root.addView(statsCard, statsCardParams);
        root.addView(paramsCard, paramsCardViewParams);

        // HIGH SCORE TEXT
        if (!isInfiniteMode && !isKochMode) {
            TextView highScoreTxt = new TextView(getContext());
            highScoreTxt.setText(LanguageManager.get(MorseLanguage.YOUR_HIGH_SCORE_IS) + ": " + record);
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
        
        if (isKochMode) {
            // BACK BUTTON
            TextView backBtn = new TextView(getContext());
            backBtn.setText(LanguageManager.get(MorseLanguage.BACK));
            backBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            backBtn.setTypeface(Typeface.DEFAULT_BOLD);
            backBtn.setGravity(Gravity.CENTER);
            backBtn.setPadding(dp(16), dp(18), dp(16), dp(18));
            backBtn.setTextColor(textPrimary);
            GradientDrawable backBg = new GradientDrawable();
            backBg.setShape(GradientDrawable.RECTANGLE);
            backBg.setCornerRadius(dp(16));
            backBg.setColor(surfaceCol);
            backBg.setStroke(dp(1), borderCol);
            backBtn.setBackground(backBg);
            backBtn.setOnClickListener(v -> {
                if (onQuit != null) onQuit.run();
            });

            // ACTION BUTTON (Next Level or Try Again)
            boolean passed = score >= kochTarget;
            boolean showNextLevel = passed && !isCustomKochMode;
            TextView actionBtn = new TextView(getContext());
            actionBtn.setText(LanguageManager.get(showNextLevel ? MorseLanguage.NEXT_LEVEL : MorseLanguage.TRY_AGAIN));
            actionBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            actionBtn.setTypeface(Typeface.DEFAULT_BOLD);
            actionBtn.setTextColor(0xFFFFFFFF);
            actionBtn.setGravity(Gravity.CENTER);
            actionBtn.setPadding(dp(16), dp(18), dp(16), dp(18));

            GradientDrawable actionBg = new GradientDrawable();
            actionBg.setShape(GradientDrawable.RECTANGLE);
            actionBg.setCornerRadius(dp(16));
            actionBg.setColor(accentCol);
            actionBtn.setBackground(actionBg);

            actionBtn.setOnClickListener(v -> {
                if (showNextLevel && onNextLevel != null) {
                    onNextLevel.run();
                } else if (onRetry != null) {
                    onRetry.run();
                }
            });

            LinearLayout.LayoutParams btnParams1 = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, 1f);
            btnParams1.rightMargin = dp(6);
            LinearLayout.LayoutParams btnParams2 = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, 1f);
            btnParams2.leftMargin = dp(6);
            
            buttonsRow.addView(backBtn, btnParams1);
            buttonsRow.addView(actionBtn, btnParams2);
        } else if (isInfiniteMode) {
            TextView contBtn = new TextView(getContext());
            contBtn.setText(LanguageManager.get(MorseLanguage.CONTINUE));
            contBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            contBtn.setTypeface(Typeface.DEFAULT_BOLD);
            contBtn.setGravity(Gravity.CENTER);
            contBtn.setPadding(dp(16), dp(18), dp(16), dp(18));
            contBtn.setTextColor(textPrimary);
            GradientDrawable contBg = new GradientDrawable();
            contBg.setShape(GradientDrawable.RECTANGLE);
            contBg.setCornerRadius(dp(16));
            contBg.setColor(surfaceCol);
            contBg.setStroke(dp(1), borderCol);
            contBtn.setBackground(contBg);
            contBtn.setOnClickListener(v -> {
                if (onQuit != null) onQuit.run();
            });
            LinearLayout.LayoutParams contParams = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, 2f);
            buttonsRow.addView(contBtn, contParams);
        } else {
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
            
            // RETRY BUTTON
            TextView retryBtn = new TextView(getContext());
            retryBtn.setText(LanguageManager.get(MorseLanguage.TRY_AGAIN));
            retryBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            retryBtn.setTypeface(Typeface.DEFAULT_BOLD);
            retryBtn.setTextColor(0xFFFFFFFF);
            retryBtn.setGravity(Gravity.CENTER);
            retryBtn.setPadding(dp(16), dp(18), dp(16), dp(18));

            GradientDrawable retryBg = new GradientDrawable();
            retryBg.setShape(GradientDrawable.RECTANGLE);
            retryBg.setCornerRadius(dp(16));
            retryBg.setColor(accentCol);
            retryBtn.setBackground(retryBg);

            retryBtn.setOnClickListener(v -> {
                if (onRetry != null) onRetry.run();
            });

            LinearLayout.LayoutParams btnParams1 = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, 1f);
            btnParams1.rightMargin = dp(6);
            LinearLayout.LayoutParams btnParams2 = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, 1f);
            btnParams2.leftMargin = dp(6);
            
            buttonsRow.addView(quitBtn, btnParams1);
            buttonsRow.addView(retryBtn, btnParams2);
        }

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
        addStatRow(parent, textPrimary, textSecondary, label, value, null);
    }

    private void addStatRow(LinearLayout parent, int textPrimary, int textSecondary, String label, String value, Integer valueColorOverride) {
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
        valueView.setTextColor(valueColorOverride != null ? valueColorOverride : textPrimary);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        valueView.setTypeface(Typeface.DEFAULT_BOLD);
        valueView.setGravity(Gravity.END);
        row.addView(valueView, new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        parent.addView(row);
    }
}
