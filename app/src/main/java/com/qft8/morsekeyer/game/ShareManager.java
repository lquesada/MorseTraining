package com.qft8.morsekeyer.game;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.FileProvider;

import com.qft8.morsekeyer.R;
import com.qft8.morsekeyer.lang.LanguageManager;
import com.qft8.morsekeyer.lang.MorseLanguage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShareManager {

    private static int dp(Context context, float value) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }

    public static View createShareView(Activity activity, String keyerType, int wpm, String timePlayed, int words, int score, int record, List<SummaryView.SummaryRow> params, boolean isInfiniteMode, boolean isKochMode, int kochTarget, int kochLevel, boolean isDarkInitially, Runnable onBack, Runnable onQuit) {
        final LinearLayout contentWrapper = new LinearLayout(activity);
        final FrameLayout previewContainer = new FrameLayout(activity);
        final LinearLayout rightColumn = new LinearLayout(activity);
        final android.widget.TableLayout selectors = new android.widget.TableLayout(activity);
        final LinearLayout btnRow = new LinearLayout(activity);
        
        rightColumn.setOrientation(LinearLayout.VERTICAL);
        rightColumn.setGravity(Gravity.CENTER_VERTICAL);
        
        Runnable rearrangeLayouts = () -> {
            contentWrapper.removeAllViews();
            rightColumn.removeAllViews();
            
            contentWrapper.setOrientation(LinearLayout.VERTICAL);
            
            LinearLayout.LayoutParams previewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f);
            previewParams.rightMargin = 0;
            previewParams.bottomMargin = dp(activity, 16);
            previewContainer.setLayoutParams(previewParams);
            contentWrapper.addView(previewContainer);
            
            contentWrapper.addView(selectors);
            contentWrapper.addView(btnRow);
        };

        LinearLayout root = new LinearLayout(activity) {
            @Override
            protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                rearrangeLayouts.run();
            }
        };
        root.setOrientation(LinearLayout.VERTICAL);

        // Dialog background color
        int bgCol = isDarkInitially ? 0xFF1A1A1A : 0xFFFFFFFF;
        int textPrimary = isDarkInitially ? 0xFFFFFFFF : 0xFF000000;
        int textSecondary = isDarkInitially ? 0xFFAAAAAA : 0xFF666666;
        int barCol = isDarkInitially ? 0xFF2A2A2A : 0xFFDDDDDD;
        int utlCol = isDarkInitially ? 0xFF444444 : 0xFFD0D0D0;
        
        root.setBackgroundColor(bgCol);

        // TOP BAR (Matching game_top_bar exactly)
        LinearLayout topBar = new LinearLayout(activity);
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setBackgroundColor(barCol);
        topBar.setPadding(dp(activity, 3), dp(activity, 3), dp(activity, 3), dp(activity, 3));
        topBar.setGravity(Gravity.CENTER_VERTICAL);
        
        android.widget.ImageButton btnBack = new android.widget.ImageButton(activity);
        btnBack.setImageResource(R.drawable.ic_arrow_back);
        btnBack.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        btnBack.setColorFilter(isDarkInitially ? 0xFFFFFFFF : 0xFF000000);
        
        int pad = dp(activity, 12);
        int w = dp(activity, 54);
        int h = dp(activity, 54);
        int marginEnd = dp(activity, 8);
        
        if (activity != null) {
            android.widget.ImageButton template = activity.findViewById(com.qft8.morsekeyer.R.id.game_btn_back);
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
            if (onBack != null) onBack.run();
        });
        
        LinearLayout.LayoutParams backBtnParams = new LinearLayout.LayoutParams(w, h);
        backBtnParams.rightMargin = marginEnd;
        topBar.addView(btnBack, backBtnParams);

        // Spacer
        android.widget.Space space1 = new android.widget.Space(activity);
        topBar.addView(space1, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

        TextView title = new TextView(activity);
        title.setText(LanguageManager.get(MorseLanguage.SHARE_PREVIEW));
        title.setTextColor(textPrimary);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setSingleLine(true);
        title.setEllipsize(android.text.TextUtils.TruncateAt.END);
        
        topBar.addView(title, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        // Spacer
        android.widget.Space space2 = new android.widget.Space(activity);
        topBar.addView(space2, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

        // Dummy view for symmetry (54dp width, 8dp marginStart)
        android.view.View dummyView = new android.view.View(activity);
        LinearLayout.LayoutParams dummyParams = new LinearLayout.LayoutParams(dp(activity, 54), dp(activity, 54));
        dummyParams.leftMargin = dp(activity, 8);
        topBar.addView(dummyView, dummyParams);

        // Flash overlay for visual indicator
        android.view.View flashOverlay = new android.view.View(activity);
        flashOverlay.setBackgroundColor(0xFFFFFFFF);
        flashOverlay.setVisibility(android.view.View.GONE);
        flashOverlay.setTag("share_flash_overlay");
        
        FrameLayout topBarWrapper = new FrameLayout(activity);
        topBarWrapper.addView(topBar, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, dp(activity, 60)));
        topBarWrapper.addView(flashOverlay, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        root.addView(topBarWrapper, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(activity, 60)));

        contentWrapper.setPadding(dp(activity, 20), dp(activity, 10), dp(activity, 20), dp(activity, 16));
        LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f);
        contentWrapper.setLayoutParams(contentParams);

        selectors.setColumnStretchable(1, true);

        GradientDrawable spinnerBg = new GradientDrawable();
        spinnerBg.setShape(GradientDrawable.RECTANGLE);
        spinnerBg.setCornerRadius(dp(activity, 8));
        spinnerBg.setColor(bgCol);
        spinnerBg.setStroke(dp(activity, 1), utlCol);

        // Language Spinner
        android.widget.TableRow langRow = new android.widget.TableRow(activity);
        langRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView langLabel = new TextView(activity);
        langLabel.setText(LanguageManager.get(MorseLanguage.LANGUAGE));
        langLabel.setTextColor(textPrimary);
        langLabel.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
        langLabel.setPadding(0, 0, dp(activity, 16), 0);
        android.widget.TableRow.LayoutParams langLabelParams = new android.widget.TableRow.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, dp(activity, 48));
        langLabelParams.gravity = Gravity.CENTER_VERTICAL;
        langRow.addView(langLabel, langLabelParams);

        Spinner langSpinner = new Spinner(activity);
        langSpinner.setBackground(spinnerBg);
        Map<String, String> langs = LanguageManager.getAvailableLanguages();
        
        List<String> langKeys = new ArrayList<>();
        List<String> langNames = new ArrayList<>();
        String currentKey = LanguageManager.getCurrentKey();
        
        langKeys.add(currentKey);
        langNames.add(langs.get(currentKey));
        
        if (!"en".equals(currentKey) && langs.containsKey("en")) {
            langKeys.add("en");
            langNames.add(langs.get("en"));
        }
        
        java.util.Set<String> excludeKeys = new java.util.HashSet<>();
        excludeKeys.add(currentKey);
        excludeKeys.add("en");
        
        List<Map.Entry<String, String>> remaining = LanguageManager.getSortedLanguages(excludeKeys);
        for (Map.Entry<String, String> entry : remaining) {
            langKeys.add(entry.getKey());
            langNames.add(entry.getValue());
        }
        
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, langNames);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(langAdapter);
        langSpinner.setSelection(0);
        android.widget.TableRow.LayoutParams langParams = new android.widget.TableRow.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 48));
        langRow.addView(langSpinner, langParams);

        android.widget.TableLayout.LayoutParams langRowParams = new android.widget.TableLayout.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        langRowParams.bottomMargin = dp(activity, 8);
        selectors.addView(langRow, langRowParams);

        // Theme Spinner
        android.widget.TableRow themeRow = new android.widget.TableRow(activity);
        themeRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView themeLabel = new TextView(activity);
        themeLabel.setText(LanguageManager.get(MorseLanguage.THEME));
        themeLabel.setTextColor(textPrimary);
        themeLabel.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
        themeLabel.setPadding(0, 0, dp(activity, 16), 0);
        android.widget.TableRow.LayoutParams themeLabelParams = new android.widget.TableRow.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, dp(activity, 48));
        themeLabelParams.gravity = Gravity.CENTER_VERTICAL;
        themeRow.addView(themeLabel, themeLabelParams);

        Spinner themeSpinner = new Spinner(activity);
        themeSpinner.setBackground(spinnerBg);
        List<String> themeOptions = new ArrayList<>();
        if (isDarkInitially) {
            themeOptions.add(LanguageManager.get(MorseLanguage.DARK_THEME));
            themeOptions.add(LanguageManager.get(MorseLanguage.LIGHT_THEME));
        } else {
            themeOptions.add(LanguageManager.get(MorseLanguage.LIGHT_THEME));
            themeOptions.add(LanguageManager.get(MorseLanguage.DARK_THEME));
        }
        ArrayAdapter<String> themeAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, themeOptions);
        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(themeAdapter);
        themeSpinner.setSelection(0);
        android.widget.TableRow.LayoutParams themeParams = new android.widget.TableRow.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 48));
        themeRow.addView(themeSpinner, themeParams);

        android.widget.TableLayout.LayoutParams themeRowParams = new android.widget.TableLayout.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        themeRowParams.bottomMargin = dp(activity, 16);
        selectors.addView(themeRow, themeRowParams);

        // layout rearranged later

        // Buttons
        btnRow.setOrientation(LinearLayout.HORIZONTAL);
        btnRow.setGravity(Gravity.CENTER);
        btnRow.setWeightSum(2f);
        
        int surfaceCol = isDarkInitially ? 0xFF2A2A2A : 0xFFF5F5F5;
        int borderCol = isDarkInitially ? 0xFF444444 : 0xFFE0E0E0;

        TextView cancelBtn = new TextView(activity);
        cancelBtn.setText(LanguageManager.get(MorseLanguage.CANCEL));
        cancelBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        cancelBtn.setTypeface(Typeface.DEFAULT_BOLD);
        cancelBtn.setGravity(Gravity.CENTER);
        cancelBtn.setPadding(dp(activity, 16), dp(activity, 18), dp(activity, 16), dp(activity, 18));
        cancelBtn.setTextColor(textPrimary);
        GradientDrawable cancelBg = new GradientDrawable();
        cancelBg.setShape(GradientDrawable.RECTANGLE);
        cancelBg.setCornerRadius(dp(activity, 16));
        cancelBg.setColor(surfaceCol);
        cancelBg.setStroke(dp(activity, 1), borderCol);
        cancelBtn.setBackground(cancelBg);
        cancelBtn.setOnClickListener(v -> {
            if (onBack != null) onBack.run();
        });
        LinearLayout.LayoutParams cancelParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        cancelParams.rightMargin = dp(activity, 6);
        btnRow.addView(cancelBtn, cancelParams);

        TextView shareBtn = new TextView(activity);
        shareBtn.setText(LanguageManager.get(MorseLanguage.SHARE));
        shareBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        shareBtn.setTypeface(Typeface.DEFAULT_BOLD);
        shareBtn.setGravity(Gravity.CENTER);
        shareBtn.setPadding(dp(activity, 16), dp(activity, 18), dp(activity, 16), dp(activity, 18));
        shareBtn.setTextColor(textPrimary);
        GradientDrawable shareBg = new GradientDrawable();
        shareBg.setShape(GradientDrawable.RECTANGLE);
        shareBg.setCornerRadius(dp(activity, 16));
        shareBg.setColor(isDarkInitially ? 0xFF444444 : 0xFFCCCCCC);
        shareBtn.setBackground(shareBg);
        
        LinearLayout.LayoutParams shareParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        shareParams.leftMargin = dp(activity, 6);
        btnRow.addView(shareBtn, shareParams);

        rearrangeLayouts.run();

        root.addView(contentWrapper);


        
        final View[] currentShareView = new View[1];
        final String[] currentLangToShare = {LanguageManager.getCurrentKey()};
        
        Runnable updatePreview = () -> {
            boolean isDark = themeSpinner.getSelectedItem().toString().equals(LanguageManager.get(MorseLanguage.DARK_THEME));
            String originalLang = LanguageManager.getCurrentKey();
            LanguageManager.init(currentLangToShare[0]);
            
            View shareView = createMatchShareView(activity, keyerType, wpm, timePlayed, words, score, record, params, isInfiniteMode, isKochMode, kochTarget, kochLevel, isDark);
            currentShareView[0] = shareView;

            // Render view offscreen for preview
            int widthSpec = View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY);
            int heightSpecUnspecified = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            shareView.measure(widthSpec, heightSpecUnspecified);
            
            int measuredHeight = shareView.getMeasuredHeight();
            if (measuredHeight < 1350) measuredHeight = 1350;
            
            int heightSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.EXACTLY);
            shareView.measure(widthSpec, heightSpec);
            shareView.layout(0, 0, 1080, measuredHeight);

            Bitmap b = Bitmap.createBitmap(shareView.getMeasuredWidth(), shareView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            shareView.draw(c);
            
            // Draw a thick grey border directly on the preview bitmap
            // so it perfectly traces the image bounds.
            android.graphics.Paint borderPaint = new android.graphics.Paint();
            borderPaint.setStyle(android.graphics.Paint.Style.STROKE);
            borderPaint.setColor(0xFFAAAAAA);
            borderPaint.setStrokeWidth(12); // 12px on 1080px canvas
            c.drawRect(0, 0, b.getWidth(), b.getHeight(), borderPaint);

            ImageView previewImage = new ImageView(activity);
            previewImage.setImageBitmap(b);
            previewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
            previewImage.setAdjustViewBounds(true);
            
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            );
            imageParams.gravity = Gravity.CENTER;
            
            previewContainer.removeAllViews();
            previewContainer.addView(previewImage, imageParams);

            LanguageManager.init(originalLang);
        };

        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentLangToShare[0] = langKeys.get(position);
                updatePreview.run();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePreview.run();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        shareBtn.setOnClickListener(v -> {
            View view = currentShareView[0];
            if (view != null) {
                Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                view.draw(canvas);

                File cachePath = new File(activity.getCacheDir(), "images");
                cachePath.mkdirs();
                try {
                    File file = new File(cachePath, "morse_score.png");
                    FileOutputStream stream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    stream.close();

                    Uri contentUri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", file);

                    if (contentUri != null) {
                        String originalLang = LanguageManager.getCurrentKey();
                        LanguageManager.init(currentLangToShare[0]);
                        String promo = LanguageManager.get(MorseLanguage.SHARE_PROMO_TEXT);
                        String subj = LanguageManager.get(MorseLanguage.SHARE_SUBJECT);
                        LanguageManager.init(originalLang);

                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        shareIntent.setDataAndType(contentUri, activity.getContentResolver().getType(contentUri));
                        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, promo);
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, subj);
                        
                        Intent receiverIntent = new Intent(activity, ShareReceiver.class);
                        PendingIntent pi = PendingIntent.getBroadcast(activity, 0, receiverIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                        
                        ShareReceiver.onShareAppSelected = () -> {
                            activity.runOnUiThread(() -> {
                                if (onBack != null) onBack.run();
                            });
                        };
                        
                        activity.startActivity(Intent.createChooser(shareIntent, LanguageManager.get(MorseLanguage.SHARE), pi.getIntentSender()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        updatePreview.run();
        
        return root;
    }

    public static void shareDirectly(Activity activity, String keyerType, int wpm, String timePlayed, int words, int score, int record, List<SummaryView.SummaryRow> params, boolean isInfiniteMode, boolean isKochMode, int kochTarget, int kochLevel, boolean isDarkTheme, Runnable onComplete) {
        View view = createMatchShareView(activity, keyerType, wpm, timePlayed, words, score, record, params, isInfiniteMode, isKochMode, kochTarget, kochLevel, isDarkTheme);
        view.measure(
            View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(1920, View.MeasureSpec.UNSPECIFIED)
        );
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        File cachePath = new File(activity.getCacheDir(), "images");
        cachePath.mkdirs();
        try {
            File file = new File(cachePath, "morse_score.png");
            FileOutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();

            Uri contentUri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", file);

            if (contentUri != null) {
                String promo = LanguageManager.get(MorseLanguage.SHARE_PROMO_TEXT);
                String subj = LanguageManager.get(MorseLanguage.SHARE_SUBJECT);

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.setDataAndType(contentUri, activity.getContentResolver().getType(contentUri));
                shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                shareIntent.putExtra(Intent.EXTRA_TEXT, promo);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, subj);
                
                Intent receiverIntent = new Intent(activity, ShareReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(activity, 0, receiverIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                
                ShareReceiver.onShareAppSelected = () -> {
                    activity.runOnUiThread(() -> {
                        if (onComplete != null) onComplete.run();
                    });
                };
                
                activity.startActivity(Intent.createChooser(shareIntent, LanguageManager.get(MorseLanguage.SHARE), pi.getIntentSender()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int px(float value) {
        return (int) (value * 3.0f);
    }

    private static View createMatchShareView(Context context, String keyerType, int wpm, String timePlayed, int words, int score, int record, List<SummaryView.SummaryRow> params, boolean isInfiniteMode, boolean isKochMode, int kochTarget, int kochLevel, boolean darkTheme) {
        int bgCol = darkTheme ? 0xFF1A1A1A : 0xFFFFFFFF;
        int textPrimary = darkTheme ? 0xFFFFFFFF : 0xFF000000;
        int textSecondary = darkTheme ? 0xFFAAAAAA : 0xFF555555;
        int surfaceCol = darkTheme ? 0xFF2A2A2A : 0xFFF5F5F5;
        int borderCol = darkTheme ? 0xFF444444 : 0xFFE0E0E0;

        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(bgCol);
        // Expand panes to 95% width (27px padding left and right)
        root.setPadding(px(27), px(25), px(27), px(30));

        // Logo and Title Row
        LinearLayout headerRow = new LinearLayout(context);
        headerRow.setOrientation(LinearLayout.HORIZONTAL);
        headerRow.setGravity(Gravity.TOP);
        // Padding below logo
        headerRow.setPadding(0, 0, 0, px(18));

        ImageView logo = new ImageView(context);
        logo.setImageResource(R.drawable.morse_logo);
        GradientDrawable logoBg = new GradientDrawable();
        logoBg.setShape(GradientDrawable.RECTANGLE);
        logoBg.setCornerRadius(px(16));
        logo.setBackground(logoBg);
        logo.setClipToOutline(true);

        LinearLayout.LayoutParams logoParams = new LinearLayout.LayoutParams(px(66), px(66));
        logoParams.rightMargin = px(16);
        headerRow.addView(logo, logoParams);

        LinearLayout titleCol = new LinearLayout(context);
        titleCol.setOrientation(LinearLayout.VERTICAL);
        titleCol.setGravity(Gravity.TOP);
        
        TextView appTitle = new TextView(context);
        appTitle.setText("Morse Training");
        appTitle.setTextColor(textPrimary);
        appTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(32));
        appTitle.setTypeface(Typeface.DEFAULT_BOLD);
        appTitle.setSingleLine(true);
        appTitle.setIncludeFontPadding(false);
        appTitle.setEllipsize(android.text.TextUtils.TruncateAt.END);
        titleCol.addView(appTitle);
        
        TextView modeTitle = new TextView(context);
        String modeText;
        if (isKochMode) {
            String modeName = (keyerType == null) ? LanguageManager.get(MorseLanguage.RX) : LanguageManager.get(MorseLanguage.TX);
            modeText = "Koch " + modeName;
        } else {
            modeText = (keyerType == null) ? LanguageManager.get(MorseLanguage.RX) : LanguageManager.get(MorseLanguage.TX);
        }
        modeTitle.setText(modeText);
        modeTitle.setTextColor(textSecondary);
        modeTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(28));
        modeTitle.setIncludeFontPadding(false);
        androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(modeTitle, px(8), px(28), 1, TypedValue.COMPLEX_UNIT_PX);
        modeTitle.setSingleLine(true);
        LinearLayout.LayoutParams modeTitleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, px(34));
        titleCol.addView(modeTitle, modeTitleParams);

        LinearLayout.LayoutParams titleColParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        headerRow.addView(titleCol, titleColParams);

        root.addView(headerRow);



        // Results Card (Merged with Record)
        LinearLayout statsCard = createCard(context, surfaceCol, borderCol);
        TextView statsHeader = new TextView(context);
        statsHeader.setText(LanguageManager.get(MorseLanguage.MATCH_RESULTS));
        statsHeader.setTextColor(textSecondary);
        statsHeader.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(14));
        statsHeader.setTypeface(Typeface.DEFAULT_BOLD);
        statsHeader.setPadding(0, 0, 0, px(8));
        statsCard.addView(statsHeader);

        if (isKochMode) {
            addStatRow(context, statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim(), score + " / " + kochTarget);
        } else {
            addStatRow(context, statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim(), String.valueOf(score));
        }
        boolean isStandardTime = timePlayed.equals("3:00") || timePlayed.equals("5:00") || timePlayed.equals("7:00") || timePlayed.equals("10:00") || timePlayed.equals("20:00") || timePlayed.equals("60:00");
        Integer timeColor = null;
        if (isStandardTime) {
            timeColor = 0xFF00C853;
        }
        addStatRow(context, statsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.TIME).replace(":", "").trim(), timePlayed, timeColor);

        if (isKochMode) {
            TextView levelTxt = new TextView(context);
            levelTxt.setText(LanguageManager.get(MorseLanguage.LEVEL) + ": " + kochLevel);
            levelTxt.setTextColor(textPrimary);
            levelTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(18));
            levelTxt.setGravity(Gravity.CENTER);
            levelTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams levelParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            levelParams.bottomMargin = px(8);
            root.addView(levelTxt, levelParams);

            TextView targetTxt = new TextView(context);
            targetTxt.setText(LanguageManager.get(score >= kochTarget ? MorseLanguage.TARGET_MET : MorseLanguage.TARGET_NOT_MET));
            targetTxt.setTextColor(score >= kochTarget ? 0xFF00C853 : 0xFFD50000);
            targetTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(20));
            targetTxt.setGravity(Gravity.CENTER);
            targetTxt.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams targetParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            targetParams.bottomMargin = px(10);
            root.addView(targetTxt, targetParams);
        }

        root.addView(statsCard);

        // Spacer
        View spacer1 = new View(context);
        spacer1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, px(10)));
        root.addView(spacer1);

        // Settings Card
        LinearLayout paramsCard = createCard(context, surfaceCol, borderCol);
        TextView paramsHeader = new TextView(context);
        paramsHeader.setText(LanguageManager.get(MorseLanguage.MATCH_SETTINGS));
        paramsHeader.setTextColor(textSecondary);
        paramsHeader.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(14));
        paramsHeader.setTypeface(Typeface.DEFAULT_BOLD);
        paramsHeader.setPadding(0, 0, 0, px(8));
        paramsCard.addView(paramsHeader);

        String translatedKeyerType = "Iambic A";
        if ("straight".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_STRAIGHT);
        else if ("iambic-a".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_IAMBIC_A);
        else if ("iambic-b".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_IAMBIC_B);
        else if ("ultimatic".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_ULTIMATIC);
        else if ("bug".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_BUG);
        else if ("cootie".equals(keyerType)) translatedKeyerType = LanguageManager.get(MorseLanguage.MODE_COOTIE);

        if (keyerType != null) {
            addStatRow(context, paramsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.KEY_MODE), translatedKeyerType);
        }
        addStatRow(context, paramsCard, textPrimary, textSecondary, LanguageManager.get(MorseLanguage.WPM_SPEED), String.valueOf(wpm));
        for (SummaryView.SummaryRow row : params) {
            addStatRow(context, paramsCard, textPrimary, textSecondary, LanguageManager.get(row.labelKey), row.value);
        }
        root.addView(paramsCard);

        // Expandable Spacer
        View flexSpacer = new View(context);
        flexSpacer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f));
        root.addView(flexSpacer);

        // Footer URL
        TextView footer = new TextView(context);
        footer.setText("morsetraining.com");
        footer.setTextColor(textSecondary);
        footer.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(16));
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, px(18), 0, 0);
        root.addView(footer);

        return root;
    }

    private static LinearLayout createCard(Context context, int surfaceCol, int borderCol) {
        LinearLayout card = new LinearLayout(context);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(px(16), px(16), px(16), px(16));

        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setCornerRadius(px(16));
        bg.setColor(surfaceCol);
        bg.setStroke(px(2), borderCol);
        card.setBackground(bg);

        return card;
    }

    private static void addStatRow(Context context, LinearLayout parent, int textPrimary, int textSecondary, String label, String value) {
        addStatRow(context, parent, textPrimary, textSecondary, label, value, null);
    }

    private static void addStatRow(Context context, LinearLayout parent, int textPrimary, int textSecondary, String label, String value, Integer valueColorOverride) {
        LinearLayout row = new LinearLayout(context);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, px(3), 0, px(3));

        TextView labelView = new TextView(context);
        labelView.setText(label);
        labelView.setTextColor(textSecondary);
        labelView.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(14));
        LinearLayout.LayoutParams labelParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        row.addView(labelView, labelParams);

        TextView valueView = new TextView(context);
        valueView.setText(value);
        valueView.setTextColor(valueColorOverride != null ? valueColorOverride : textPrimary);
        valueView.setTextSize(TypedValue.COMPLEX_UNIT_PX, px(14));
        valueView.setTypeface(Typeface.DEFAULT_BOLD);
        valueView.setGravity(Gravity.END);
        row.addView(valueView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        parent.addView(row);
    }
}
