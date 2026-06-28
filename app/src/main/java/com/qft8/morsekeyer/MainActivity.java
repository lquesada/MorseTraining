package com.qft8.morsekeyer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsControllerCompat;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.content.Context;
import android.view.ContextThemeWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import com.qft8.morsekeyer.lang.LanguageManager;
import static com.qft8.morsekeyer.lang.MorseLanguage.*;

import android.app.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private MorseSettings settings;
    private MorseState morseState;
    private ToneEngine toneEngine;
    private MorseKeyer keyer;

    private ImageButton btnSettings;
    private Button btnInfo;
    private ImageButton btnClear;
    private TextView txtOutput;
    private ScrollView scrollOutput, scrollTable;
    private LinearLayout middleLayout, tableContent, paddleContainer;
    private TextView paddleLeft, paddleRight;
    private View paddleDivider;

    // Game Controller
    public com.qft8.morsekeyer.game.GameController gameController;

    // Settings dialog widget refs (created dynamically)
    private Spinner dlgMode;
    private CheckBox dlgInverse, dlgStrict, dlgNoclick, dlgTable, dlgTableCodes, dlgVisual, dlgShowPaddles, dlgKeepAlive, dlgWhiteNoise, dlgNextWordIndicator, dlgKeepScreenOn, dlgChkPickLangThemeOnShare;
    private Spinner dlgLetterColor, dlgAppTheme, dlgLanguage, dlgKeyboardType;
    private String[] settingsLangKeys;
    private Button dlgWpmMinus, dlgWpmPlus;
    private TextView dlgTxtWpm, dlgTxtFreq, dlgTxtVol, dlgTxtBuffer, dlgTxtEnvelope, dlgTxtChunk;
    private TextView dlgTxtFontSize, dlgTxtTableFontSize, dlgTxtTableRatio, dlgTxtInterletterSpacing, dlgTxtInterwordSpacing;
    private TextView dlgLblInterletterSpacing, dlgLblInterwordSpacing;
    private TextView dlgLblWhiteNoiseVol, dlgLblWhiteNoiseFreq;
    private TextView dlgTxtWhiteNoiseVol, dlgTxtWhiteNoiseFreq;
    private SeekBar dlgSeekFreq, dlgSeekVol, dlgSeekBuffer, dlgSeekEnvelope, dlgSeekChunk;
    private SeekBar dlgSeekFontSize, dlgSeekTableFontSize, dlgSeekTableRatio, dlgSeekInterletterSpacing, dlgSeekInterwordSpacing;
    private SeekBar dlgSeekWhiteNoiseVol, dlgSeekWhiteNoiseFreq;
    private AlertDialog settingsDialog;
    private Map<String, Spinner> dlgDecoderSpinners = new HashMap<>();

    private Handler wpmHandler = new Handler(Looper.getMainLooper());
    private Map<Integer, String> touchMap = new HashMap<>();
    private boolean mouseLeftPaddlePressed = false;
    private boolean mouseRightPaddlePressed = false;
    private String mouseActiveSide = null;
    private Context dialogCtx;
    private boolean lastThemeDark;
    private boolean isSyncing = false;
    private PopupWindow tooltipWindow;
    private final Handler tooltipHandler = new Handler(Looper.getMainLooper());
    private final Runnable tooltipDismissRunnable = this::hideTooltip;
    private Runnable tooltipShowRunnable;
    private float lastTooltipX, lastTooltipY;
    private boolean tooltipMoved;




    private int C_BG, C_BAR, C_UTL, C_BTN, C_PP, C_PL, C_PR, C_TEXT, C_TERM, C_TABLE, C_W;
    private int C_ACT = 0xFF007ACC;
    private KeyInterceptLayout rootLayout;
    private LinearLayout contentLayout;
    private LinearLayout dialogRoot;
    private ScrollView dialogSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(0xFF000000);
        rootLayout = findViewById(R.id.root_layout);
        contentLayout = findViewById(R.id.content_layout);
        settings = new MorseSettings();
        settings.load(this);
        LanguageManager.init(settings.language);
        morseState = new MorseState();
        toneEngine = new ToneEngine();

        btnSettings = findViewById(R.id.btn_settings);
        btnInfo = findViewById(R.id.btn_info);
        btnClear = findViewById(R.id.btn_clear);
        txtOutput = findViewById(R.id.txt_output);
        scrollOutput = findViewById(R.id.scroll_output);
        scrollTable = findViewById(R.id.scroll_table);
        middleLayout = findViewById(R.id.middle_layout);
        tableContent = findViewById(R.id.table_content);
        paddleContainer = findViewById(R.id.paddle_container);
        paddleLeft = findViewById(R.id.paddle_left);
        paddleRight = findViewById(R.id.paddle_right);
        paddleDivider = findViewById(R.id.paddle_divider);

        gameController = new com.qft8.morsekeyer.game.GameController(this, contentLayout);

        applyTheme();

        if (settings.showTable) {
            buildMorseTable();
            scrollTable.setVisibility(View.VISIBLE);
            scrollTable.getViewTreeObserver().addOnScrollChangedListener(this::hideTooltip);
        }

        applyOrientation();
        applyUiSettings();

        toneEngine.setToneType(settings.toneType);
        toneEngine.setFrequency(settings.tone);
        toneEngine.setVolume(settings.vol);
        toneEngine.init();

        applyKeepScreenOn();

        keyer = new MorseKeyer(settings, morseState, toneEngine, new MorseKeyer.OutputCallback() {
            @Override
            public void onText(String text) {
                runOnUiThread(() -> {
                    String current = txtOutput.getText().toString();
                    if (current.endsWith("\u200B_")) {
                        txtOutput.setText(current.substring(0, current.length() - 2) + " ");
                    } else if (current.endsWith("_")) {
                        txtOutput.setText(current.substring(0, current.length() - 1) + " ");
                    }
                    txtOutput.append(text);
                    scrollOutput.post(() -> scrollOutput.fullScroll(View.FOCUS_DOWN));
                    
                    gameController.onDecode(text);
                });
            }

            @Override
            public void onWordGapPending() {
                runOnUiThread(() -> {
                    txtOutput.append("\u200B_");
                    scrollOutput.post(() -> scrollOutput.fullScroll(View.FOCUS_DOWN));
                    gameController.onWordGapPending();
                });
            }

            @Override
            public void onWordGapConfirmed() {
                runOnUiThread(() -> {
                    String current = txtOutput.getText().toString();
                    if (current.endsWith("\u200B_")) {
                        txtOutput.setText(current.substring(0, current.length() - 2) + " ");
                    } else if (current.endsWith("_")) {
                        txtOutput.setText(current.substring(0, current.length() - 1) + " ");
                    }
                    gameController.onWordGapConfirmed();
                });
            }
        });
        
        if (gameController != null) {
            gameController.setMorseKeyer(keyer);
        }

        keyer.setVisualCallback(new MorseKeyer.VisualCallback() {
            @Override
            public void onToneStart() {
                runOnUiThread(() -> {
                    if (settings.visual) {
                        findViewById(R.id.top_bar_flash).setVisibility(View.VISIBLE);
                        findViewById(R.id.game_top_bar_flash).setVisibility(View.VISIBLE);
                        findViewById(R.id.game_menu_top_bar_flash).setVisibility(View.VISIBLE);
                        if (gameController != null) {
                            gameController.onVisualFlash(true);
                        }
                    }
                    if (gameController != null) {
                        gameController.onToneStart();
                    }
                });
            }

            @Override
            public void onToneStop() {
                runOnUiThread(() -> {
                    findViewById(R.id.top_bar_flash).setVisibility(View.GONE);
                    findViewById(R.id.game_top_bar_flash).setVisibility(View.GONE);
                    findViewById(R.id.game_menu_top_bar_flash).setVisibility(View.GONE);
                    if (gameController != null) {
                        gameController.onVisualFlash(false);
                        gameController.onToneStop();
                    }
                });
            }
        });


        setupBlipButton(btnSettings, () -> showSettingsDialog());
        setupBlipButton(btnInfo, () -> showInfoDialog());
        
        setupBlipButton(btnClear, () -> txtOutput.setText(""));

        paddleLeft.setOnTouchListener((v, event) -> handlePaddleTouch(event, "left"));
        paddleRight.setOnTouchListener((v, event) -> handlePaddleTouch(event, "right"));
        
        if (gameController != null) {
            gameController.setPaddleListeners((v, event) -> handlePaddleTouch(event, "left"), (v, event) -> handlePaddleTouch(event, "right"));
        }

        applyMode();

        // Set up the pre-IME key interceptor for USB keyboards
        KeyInterceptLayout rootLayout = findViewById(R.id.root_layout);
        rootLayout.setKeyCallback(event -> {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && gameController != null && gameController.isRxGameActive()) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    gameController.onBackPressed();
                }
                return true;
            }
            return handleKeyAction(event.getKeyCode(), event.getAction(), event.getRepeatCount());
        });


        if (android.os.Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(
                    android.window.OnBackInvokedDispatcher.PRIORITY_DEFAULT,
                    () -> {
                        if (gameController != null && gameController.onBackPressed()) {
                            return;
                        }
                        finish();
                    }
            );
        }
    }



    private void setupBlipButton(View btn, Runnable action) {
        btn.setOnTouchListener((v, event) -> {
            int actionEvent = event.getAction();
            int activeColor = C_ACT;
            if (actionEvent == android.view.MotionEvent.ACTION_DOWN) {
                v.setBackgroundTintList(android.content.res.ColorStateList.valueOf(activeColor));
                if (btn instanceof android.widget.Button) {
                    ((android.widget.Button) btn).setTextColor(0xFFFFFFFF);
                } else if (btn instanceof android.widget.ImageButton) {
                    ((android.widget.ImageButton) btn).setColorFilter(0xFFFFFFFF);
                }
            } else if (actionEvent == android.view.MotionEvent.ACTION_UP || actionEvent == android.view.MotionEvent.ACTION_CANCEL) {
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    v.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
                    if (btn instanceof android.widget.Button) {
                        ((android.widget.Button) btn).setTextColor(C_TEXT);
                    } else if (btn instanceof android.widget.ImageButton) {
                        ((android.widget.ImageButton) btn).setColorFilter(C_TEXT);
                    }
                }, 80);
                if (actionEvent == android.view.MotionEvent.ACTION_UP) {
                    v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                    if (action != null) action.run();
                }
            }
            return true;
        });
    }

    private void applyMode() {
        boolean isStraight = "straight".equals(settings.mode);
        boolean isBug = "bug".equals(settings.mode);
        boolean isCootie = "cootie".equals(settings.mode);
        if (isStraight) {
            paddleRight.setVisibility(View.GONE);
            paddleDivider.setVisibility(View.GONE);
            paddleLeft.setText(LanguageManager.get(KEY));
            paddleLeft.setTextSize(36);
        } else if (isCootie) {
            paddleRight.setVisibility(View.VISIBLE);
            paddleDivider.setVisibility(View.VISIBLE);
            paddleLeft.setText(LanguageManager.get(KEY));
            paddleLeft.setTextSize(36);
            paddleRight.setText(LanguageManager.get(KEY));
            paddleRight.setTextSize(36);
        } else if (isBug) {
            paddleRight.setVisibility(View.VISIBLE);
            paddleDivider.setVisibility(View.VISIBLE);
            boolean inverse = "inverse".equals(settings.polarity);
            paddleLeft.setText(inverse ? LanguageManager.get(KEY) : "\u00B7");
            paddleLeft.setTextSize(inverse ? 36 : 72);
            paddleRight.setText(inverse ? "\u00B7" : LanguageManager.get(KEY));
            paddleRight.setTextSize(inverse ? 72 : 36);
        } else {
            paddleRight.setVisibility(View.VISIBLE);
            paddleDivider.setVisibility(View.VISIBLE);
            boolean inverse = "inverse".equals(settings.polarity);
            paddleLeft.setText(inverse ? "\u2013" : "\u00B7");
            paddleLeft.setTextSize(72);
            paddleRight.setText(inverse ? "\u00B7" : "\u2013");
            paddleRight.setTextSize(72);
        }

        // Apply same to game paddles
        if (gameController != null) {
            float density = getResources().getDisplayMetrics().scaledDensity;
            if (density <= 0) density = 1.0f;
            gameController.updatePaddleText(
                paddleLeft.getText().toString(),
                paddleLeft.getTextSize() / density,
                paddleRight.getText().toString(),
                paddleRight.getTextSize() / density,
                paddleRight.getVisibility(),
                paddleDivider.getVisibility()
            );
        }

        String modeLabel;
        if ("straight".equals(settings.mode))
            modeLabel = "Straight";
        else if ("iambic-a".equals(settings.mode))
            modeLabel = "Iambic A";
        else if ("ultimatic".equals(settings.mode))
            modeLabel = "Ultimatic";
        else if ("bug".equals(settings.mode))
            modeLabel = "Bug";
        else if ("cootie".equals(settings.mode))
            modeLabel = "Cootie";
        else
            modeLabel = "Iambic B";
    }

    private boolean isLight() {
        return "light".equals(settings.appTheme);
    }

    private void applyUiSettings() {
        if (txtOutput == null)
            return;
        txtOutput.setTextSize(settings.fontSize);
        int color = 0xFF00FF00;
        switch (settings.letterColor) {
            case "white":
                color = 0xFFFFFFFF;
                break;
            case "black":
                color = 0xFF000000;
                break;
            case "red":
                color = 0xFFFF0000;
                break;
            case "orange":
                color = 0xFFFFA500;
                break;
            case "yellow":
                color = 0xFFFFFF00;
                break;
            case "green":
                color = isLight() ? 0xFF008800 : 0xFF00FF00;
                break;
            case "cyan":
                color = 0xFF00FFFF;
                break;
            case "blue":
                color = isLight() ? 0xFF0000CC : 0xFF5555FF;
                break;
            case "purple":
                color = 0xFF800080;
                break;
            case "pink":
                color = 0xFFFFC0CB;
                break;
        }
        txtOutput.setTextColor(color);

        
        if (gameController != null) {
            gameController.updateVisualSettings(settings.fontSize, color, BuildConfig.CHEAT_MODE);
            gameController.updateLanguage();
        }
    }

    private void applyKeepScreenOn() {
        if (settings.keepScreenOn) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    private void applyTheme() {
        boolean dark = "dark".equals(settings.appTheme);

        boolean themeChanged = (dark != lastThemeDark);
        lastThemeDark = dark;

        if (dark) {
            C_BG = 0xFF1A1A1A;
            C_BAR = 0xFF2A2A2A;
            C_UTL = 0xFF444444;
            C_BTN = 0xFF333333;
            C_TEXT = 0xFFFFFFFF;
            C_TERM = 0xFF000000;
            C_TABLE = 0xFF111111;
            C_PL = 0xFF444444;
            C_PR = 0xFF555555;
            C_W = 0xFFFFFFFF;
            C_PP = C_ACT;
            if ("black".equals(settings.letterColor))
                settings.letterColor = "white";
        } else {
            C_BG = 0xFFFFFFFF;
            C_BAR = 0xFFE0E0E0;
            C_UTL = 0xFFD0D0D0;
            C_BTN = 0xFFC0C0C0;
            C_TEXT = 0xFF000000;
            C_TERM = 0xFFFFFFFF;
            C_TABLE = 0xFFE8E8E8;
            C_PL = 0xFFD0D0D0;
            C_PR = 0xFFC0C0C0;
            C_W = 0xFFFFFFFF;
            C_ACT = 0xFF007ACC;
            C_PP = C_ACT;
            if ("white".equals(settings.letterColor))
                settings.letterColor = "black";
        }

        // Apply colors to existing views
        if (contentLayout != null) {
            getWindow().setStatusBarColor(0xFF000000);
            new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView())
                    .setAppearanceLightStatusBars(false);
            contentLayout.setBackgroundColor(C_BG);
            findViewById(R.id.top_bar).setBackgroundColor(C_BAR);
            btnSettings.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
            btnSettings.setColorFilter(C_TEXT);
            btnInfo.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
            btnInfo.setTextColor(C_TEXT);
            btnClear.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
            btnClear.setColorFilter(C_TEXT);
            scrollOutput.setBackgroundColor(C_TERM);
            scrollTable.setBackgroundColor(C_TABLE);
            paddleContainer.setBackgroundColor(C_BAR);
            updatePaddleVisual("left", false);
            updatePaddleVisual("right", false);
            paddleLeft.setTextColor(C_TEXT);
            paddleRight.setTextColor(C_TEXT);
            findViewById(R.id.paddle_divider).setBackgroundColor(dark ? 0xFF666666 : 0xFFCCCCCC);
            
            if (gameController != null) {
                gameController.applyTheme(C_BG, C_TERM, C_PR, C_BAR, C_UTL, C_TEXT, dark);
            }
            
            if (tableContent.getChildCount() > 0)
                buildMorseTable();
            applyUiSettings();

            if (settingsDialog != null && settingsDialog.isShowing()) {
                updateDialogTheme();
            }
        }
    }

    private void updateDialogTheme() {
        if (settingsDialog == null || !settingsDialog.isShowing()) return;
        
        if (settingsDialog.getWindow() != null) {
            settingsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(C_BG));
        }
        if (dialogSv != null) dialogSv.setBackgroundColor(C_BG);
        if (dialogRoot != null) {
            applyThemeToDialogView(dialogRoot);
        }
        
        // Special update for footer buttons
        Button btnSave = settingsDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (btnSave != null) btnSave.setTextColor(0xFF007ACC);
        Button btnReset = settingsDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        if (btnReset != null) btnReset.setTextColor(0xFFCC0000);
    }

    private void applyThemeToDialogView(View v) {
        if (v instanceof TextView) {
            TextView tv = (TextView) v;
            // Don't override special colors (like Save/Reset which are handled elsewhere)
            tv.setTextColor(C_TEXT);
        }
        if (v instanceof Spinner) {
            if ("small".equals(v.getTag())) {
                applySmallSpinnerStyle((Spinner) v);
            } else {
                applySpinnerStyle((Spinner) v);
            }
        }
        if (v instanceof CheckBox) {
            CheckBox cb = (CheckBox) v;
            cb.setTextColor(C_TEXT);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                cb.setButtonTintList(android.content.res.ColorStateList.valueOf(C_TEXT));
            }
        }
        if (v instanceof RadioButton) {
            RadioButton rb = (RadioButton) v;
            rb.setTextColor(C_TEXT);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                rb.setButtonTintList(android.content.res.ColorStateList.valueOf(C_TEXT));
            }
        }
        if (v instanceof Button) {
            Button b = (Button) v;
            // Only style WPM buttons, not the footer buttons which are handled in updateDialogTheme
            if (b == dlgWpmMinus || b == dlgWpmPlus) {
                b.setTextColor(C_TEXT);
                b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
            }
        }
        if (v instanceof SeekBar) {
            SeekBar sb = (SeekBar) v;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                sb.setThumbTintList(android.content.res.ColorStateList.valueOf(C_ACT));
                sb.setProgressTintList(android.content.res.ColorStateList.valueOf(C_ACT));
            }
        }
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                applyThemeToDialogView(vg.getChildAt(i));
            }
        }
    }

    private void applySpinnerStyle(Spinner s) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(C_BTN);
        gd.setCornerRadius(dp(4));
        gd.setStroke(dp(1), (C_TEXT & 0x00FFFFFF) | 0x33000000);

        Bitmap bitmap = Bitmap.createBitmap(dp(12), dp(8), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(C_TEXT);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(dp(12), 0);
        path.lineTo(dp(6), dp(8));
        path.close();
        canvas.drawPath(path, paint);
        BitmapDrawable arrow = new BitmapDrawable(getResources(), bitmap);
        arrow.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);

        LayerDrawable ld = new LayerDrawable(new Drawable[] { gd, arrow });
        ld.setLayerInset(1, 0, 0, dp(12), 0);
        s.setBackground(ld);
        
        GradientDrawable popupGd = new GradientDrawable();
        popupGd.setColor(isLight() ? 0xFFF0F0F0 : 0xFF333333);
        popupGd.setCornerRadius(dp(4));
        popupGd.setStroke(dp(1), (C_TEXT & 0x00FFFFFF) | 0x33000000);
        s.setPopupBackgroundDrawable(popupGd);
        
        s.setMinimumHeight(dp(48));
        s.setPadding(dp(12), dp(8), dp(36), dp(8));
    }

    private void applySmallSpinnerStyle(Spinner s) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(C_BTN);
        gd.setCornerRadius(dp(4));
        gd.setStroke(dp(1), (C_TEXT & 0x00FFFFFF) | 0x33000000);

        Bitmap bitmap = Bitmap.createBitmap(dp(10), dp(6), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(C_TEXT);
        paint.setAntiAlias(true);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(dp(10), 0);
        path.lineTo(dp(5), dp(6));
        path.close();
        canvas.drawPath(path, paint);
        BitmapDrawable arrow = new BitmapDrawable(getResources(), bitmap);
        arrow.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);

        LayerDrawable ld = new LayerDrawable(new Drawable[] { gd, arrow });
        ld.setLayerInset(1, 0, 0, dp(8), 0);
        s.setBackground(ld);

        GradientDrawable popupGd = new GradientDrawable();
        popupGd.setColor(isLight() ? 0xFFF0F0F0 : 0xFF333333);
        popupGd.setCornerRadius(dp(4));
        popupGd.setStroke(dp(1), (C_TEXT & 0x00FFFFFF) | 0x33000000);
        s.setPopupBackgroundDrawable(popupGd);

        s.setMinimumHeight(dp(32));
        s.setPadding(dp(8), dp(2), dp(24), dp(2));
    }

    public void scrollOutputToBottom() {
        if (scrollOutput != null) {
            scrollOutput.post(() -> scrollOutput.fullScroll(View.FOCUS_DOWN));
        }
    }

    private <T> ArrayAdapter<T> themedAdapter(Context ctx, T[] items) {
        ArrayAdapter<T> a = new ArrayAdapter<T>(ctx, android.R.layout.simple_spinner_item, items) {
            @Override
            public View getView(int p, View cv, ViewGroup parent) {
                View v = super.getView(p, cv, parent);
                if (v instanceof TextView) {
                    ((TextView) v).setTextColor(C_TEXT);
                    ((TextView) v).setTextSize(15);
                }
                return v;
            }

            @Override
            public View getDropDownView(int p, View cv, ViewGroup parent) {
                View v = super.getDropDownView(p, cv, parent);
                if (v instanceof TextView) {
                    ((TextView) v).setTextColor(C_TEXT);
                    ((TextView) v).setTextSize(15);
                }
                return v;
            }
        };
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return a;
    }

    private ArrayAdapter<String> themedAdapterStr(Context ctx, ArrayList<String> items) {
        ArrayAdapter<String> a = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, items) {
            @Override
            public View getView(int p, View cv, ViewGroup parent) {
                View v = super.getView(p, cv, parent);
                if (v instanceof TextView) {
                    ((TextView) v).setTextColor(C_TEXT);
                    ((TextView) v).setTextSize(15);
                }
                return v;
            }

            @Override
            public View getDropDownView(int p, View cv, ViewGroup parent) {
                View v = super.getDropDownView(p, cv, parent);
                if (v instanceof TextView) {
                    ((TextView) v).setTextColor(C_TEXT);
                    ((TextView) v).setTextSize(15);
                }
                return v;
            }
        };
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return a;
    }

    private void updateViewColors(View v) {
        if (v == null)
            return;
        if (v instanceof TextView) {
            TextView tv = (TextView) v;
            // Don't update the reset button or the close button which have special colors
            if (tv.getText().toString().equals("Reset to defaults") || tv.getText().toString().equals("Close")) {
                // leave as is
            } else {
                tv.setTextColor(C_TEXT);
                if (tv instanceof CompoundButton) {
                    ((CompoundButton) tv).setButtonTintList(android.content.res.ColorStateList.valueOf(C_TEXT));
                }
            }
        }
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++)
                updateViewColors(vg.getChildAt(i));
        }
    }

    private int getDialogTheme() {
        boolean dark = "dark".equals(settings.appTheme);
        return dark ? android.R.style.Theme_DeviceDefault_Dialog : android.R.style.Theme_DeviceDefault_Light_Dialog;
    }

    public void showSettingsDialog() {
        dialogCtx = new ContextThemeWrapper(this, getDialogTheme());
        LinearLayout root = new LinearLayout(dialogCtx);
        root.setOrientation(LinearLayout.VERTICAL);
        this.dialogRoot = root;
        root.setPadding(dp(16), dp(12), dp(16), dp(4));

        // Mode
        root.addView(label(KEY_MODE));
        dlgMode = new Spinner(dialogCtx);
        dlgMode.setTag("MODE_SPINNER");
        String[] modes = {
            LanguageManager.get(MODE_STRAIGHT),
            LanguageManager.get(MODE_IAMBIC_A),
            LanguageManager.get(MODE_IAMBIC_B),
            LanguageManager.get(MODE_ULTIMATIC),
            LanguageManager.get(MODE_BUG),
            LanguageManager.get(MODE_COOTIE)
        };
        dlgMode.setAdapter(themedAdapter(dialogCtx, modes));
        applySpinnerStyle(dlgMode);
        LinearLayout.LayoutParams spLp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        spLp.setMargins(dp(16), 0, 0, dp(8));
        dlgMode.setLayoutParams(spLp);
        root.addView(dlgMode);

        dlgMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSyncing) return;
                keyer.handlePaddlePress("left", false);
                keyer.handlePaddlePress("right", false);
                updatePaddleVisual("left", false);
                updatePaddleVisual("right", false);
                switch (position) {
                    case 0: settings.mode = "straight"; break;
                    case 1: settings.mode = "iambic-a"; break;
                    case 2: settings.mode = "iambic-b"; break;
                    case 3: settings.mode = "ultimatic"; break;
                    case 4: settings.mode = "bug"; break;
                    case 5: settings.mode = "cootie"; break;
                }
                settings.save(MainActivity.this);
                applyMode();
                syncSettingsDialog();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        // WPM (inside mode)
        root.addView(subLabel(WPM_SPEED));
        LinearLayout wpmRow = hRow();
        wpmRow.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams wpmLp = (LinearLayout.LayoutParams) wpmRow.getLayoutParams();
        wpmLp.setMargins(dp(16), 0, 0, 0);
        wpmRow.setLayoutParams(wpmLp);
        dlgWpmMinus = togBtn("\u2212");
        dlgWpmPlus = togBtn("+");
        dlgWpmMinus.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF555555));
        dlgWpmPlus.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF555555));
        dlgWpmMinus.setTextSize(18);
        dlgWpmPlus.setTextSize(18);
        dlgWpmMinus.setPadding(0, 0, 0, 0);
        dlgWpmPlus.setPadding(0, 0, 0, 0);

        LinearLayout.LayoutParams btnLp = new LinearLayout.LayoutParams(dp(42), dp(42));
        btnLp.setMargins(0, 0, dp(10), dp(10));
        dlgWpmMinus.setLayoutParams(btnLp);
        dlgWpmPlus.setLayoutParams(btnLp);

        dlgTxtWpm = new TextView(this);
        dlgTxtWpm.setTextColor(C_TEXT);
        dlgTxtWpm.setTextSize(15);
        dlgTxtWpm.setTypeface(null, Typeface.BOLD);
        dlgTxtWpm.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams wpmTxtLp = new LinearLayout.LayoutParams(dp(46), dp(42));
        wpmTxtLp.setMargins(0, 0, dp(10), dp(10));
        dlgTxtWpm.setLayoutParams(wpmTxtLp);
        wpmRow.addView(dlgWpmMinus);
        wpmRow.addView(dlgTxtWpm);
        wpmRow.addView(dlgWpmPlus);
        root.addView(wpmRow);
        setupWpmBtn(dlgWpmMinus, -1);
        setupWpmBtn(dlgWpmPlus, 1);

        // Inverse & Strict (inside mode)
        dlgInverse = chkBox(INVERSE_PADDLES);
        dlgStrict = chkBox(STRICT_TIMING);
        root.addView(dlgInverse);
        root.addView(dlgStrict);

        dlgInverse.setOnClickListener(v -> {
            keyer.handlePaddlePress("left", false);
            keyer.handlePaddlePress("right", false);
            updatePaddleVisual("left", false);
            updatePaddleVisual("right", false);
            settings.polarity = dlgInverse.isChecked() ? "inverse" : "normal";
            settings.save(this);
            syncSettingsDialog();
        });
        dlgStrict.setOnClickListener(v -> {
            settings.strict = dlgStrict.isChecked();
            settings.save(this);
            syncSettingsDialog();
        });

        // Interletter spacing (inside mode)
        dlgLblInterletterSpacing = subLabel(INTERLETTER_SPACING);
        root.addView(dlgLblInterletterSpacing);
        LinearLayout ilRow = hRow();
        ilRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekInterletterSpacing = new SeekBar(this);
        dlgSeekInterletterSpacing.setMax(490); // 10 to 500
        dlgSeekInterletterSpacing.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtInterletterSpacing = new TextView(this);
        dlgTxtInterletterSpacing.setTextColor(C_TEXT);
        dlgTxtInterletterSpacing.setGravity(Gravity.CENTER);
        dlgTxtInterletterSpacing.setLayoutParams(new LinearLayout.LayoutParams(dp(60), -2));
        ilRow.addView(dlgSeekInterletterSpacing);
        ilRow.addView(dlgTxtInterletterSpacing);
        root.addView(ilRow);
        dlgSeekInterletterSpacing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                settings.interletterSpacing = 10 + progress;
                dlgTxtInterletterSpacing.setText(settings.interletterSpacing + "%");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                settings.save(MainActivity.this);
            }
        });

        // Interword spacing (inside mode)
        dlgLblInterwordSpacing = subLabel(INTERWORD_SPACING);
        root.addView(dlgLblInterwordSpacing);
        LinearLayout isRow = hRow();
        isRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekInterwordSpacing = new SeekBar(this);
        dlgSeekInterwordSpacing.setMax(490); // 10 to 500
        dlgSeekInterwordSpacing.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtInterwordSpacing = new TextView(this);
        dlgTxtInterwordSpacing.setTextColor(C_TEXT);
        dlgTxtInterwordSpacing.setGravity(Gravity.CENTER);
        dlgTxtInterwordSpacing.setLayoutParams(new LinearLayout.LayoutParams(dp(60), -2));
        isRow.addView(dlgSeekInterwordSpacing);
        isRow.addView(dlgTxtInterwordSpacing);
        root.addView(isRow);
        dlgSeekInterwordSpacing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                settings.interwordSpacing = 10 + progress;
                dlgTxtInterwordSpacing.setText(settings.interwordSpacing + "%");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                settings.save(MainActivity.this);
            }
        });

        // Tone
        root.addView(label(TONE));
        root.addView(subLabel(FREQUENCY));
        LinearLayout freqRow = hRow();
        LinearLayout.LayoutParams freqLp = (LinearLayout.LayoutParams) freqRow.getLayoutParams();
        freqLp.setMargins(dp(16), 0, 0, 0);
        freqRow.setLayoutParams(freqLp);
        dlgSeekFreq = new SeekBar(this);
        dlgSeekFreq.setMax(3850);
        dlgSeekFreq.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        dlgTxtFreq = new TextView(this);
        dlgTxtFreq.setTextColor(C_TEXT);
        dlgTxtFreq.setMinWidth(dp(64));
        dlgTxtFreq.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        dlgTxtFreq.setTextSize(15);
        freqRow.addView(dlgSeekFreq);
        freqRow.addView(dlgTxtFreq);
        root.addView(freqRow);
        dlgSeekFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int p, boolean u) {
                int f = 150 + p;
                dlgTxtFreq.setText(f + " Hz");
                settings.tone = f;
                toneEngine.setFrequency(f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sb) {
                settings.save(MainActivity.this);
            }
        });

        root.addView(subLabel(VOLUME));
        LinearLayout volRow = hRow();
        LinearLayout.LayoutParams volLp = (LinearLayout.LayoutParams) volRow.getLayoutParams();
        volLp.setMargins(dp(16), 0, 0, 0);
        volRow.setLayoutParams(volLp);
        dlgSeekVol = new SeekBar(this);
        dlgSeekVol.setMax(100);
        dlgSeekVol.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        dlgTxtVol = new TextView(this);
        dlgTxtVol.setTextColor(C_TEXT);
        dlgTxtVol.setMinWidth(dp(64));
        dlgTxtVol.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        dlgTxtVol.setTextSize(15);
        volRow.addView(dlgSeekVol);
        volRow.addView(dlgTxtVol);
        root.addView(volRow);
        dlgSeekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                dlgTxtVol.setText(p + "%");
                settings.vol = p;
                toneEngine.setVolume(p);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        root.addView(subLabel(ENVELOPE));
        LinearLayout envRow = hRow();
        envRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekEnvelope = new SeekBar(this);
        dlgSeekEnvelope.setMax(200); // 0.0 to 2.0
        dlgSeekEnvelope.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtEnvelope = new TextView(this);
        dlgTxtEnvelope.setTextColor(C_TEXT);
        dlgTxtEnvelope.setMinWidth(dp(64));
        dlgTxtEnvelope.setTextSize(15);
        envRow.addView(dlgSeekEnvelope);
        envRow.addView(dlgTxtEnvelope);
        root.addView(envRow);
        dlgSeekEnvelope.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                float ms = p / 100.0f;
                dlgTxtEnvelope.setText(String.format("%.2f ms", ms));
                settings.envelopeMs = ms;
                toneEngine.setEnvelopeMs(ms);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        dlgNoclick = chkBox(NOCLICK);
        LinearLayout.LayoutParams lpNoclick = (LinearLayout.LayoutParams) dlgNoclick.getLayoutParams();
        lpNoclick.topMargin = dp(8);
        dlgNoclick.setLayoutParams(lpNoclick);
        root.addView(dlgNoclick);
        dlgNoclick.setOnClickListener(v -> {
            settings.toneType = dlgNoclick.isChecked() ? "sawtooth" : "triangle";
            toneEngine.setToneType(settings.toneType);
            settings.save(this);
            syncSettingsDialog();
        });



        // Games
        root.addView(label(GAMES));
        
        // Keyboard Type
        root.addView(subLabel(KEYBOARD_TYPE));
        dlgKeyboardType = new Spinner(dialogCtx);
        dlgKeyboardType.setTag("KEYBOARD_SPINNER");
        String[] keyboardTypes = { "QWERTY", "QWERTZ", "AZERTY" };
        dlgKeyboardType.setAdapter(themedAdapter(dialogCtx, keyboardTypes));
        applySpinnerStyle(dlgKeyboardType);
        dlgKeyboardType.setLayoutParams(spLp);
        root.addView(dlgKeyboardType);

        // Choose language and theme when sharing scores
        dlgChkPickLangThemeOnShare = chkBox(PICK_LANG_THEME_ON_SHARE);
        root.addView(dlgChkPickLangThemeOnShare);

        // User Interface
        root.addView(label(USER_INTERFACE));

        // Language
        root.addView(subLabel(LANGUAGE));
        dlgLanguage = new Spinner(dialogCtx);
        dlgLanguage.setTag("LANG_SPINNER");
        List<Map.Entry<String, String>> remainingLangs = LanguageManager.getSortedLanguages(java.util.Collections.singleton("en"));
        settingsLangKeys = new String[remainingLangs.size() + 2];
        settingsLangKeys[0] = "system";
        settingsLangKeys[1] = "en";
        int keyIdx = 2;
        for (Map.Entry<String, String> entry : remainingLangs) {
            settingsLangKeys[keyIdx++] = entry.getKey();
        }
        
        String[] langNames = new String[settingsLangKeys.length];
        langNames[0] = LanguageManager.get(SYSTEM_SETTING);
        langNames[1] = LanguageManager.getAvailableLanguages().get("en");
        for (int i = 2; i < settingsLangKeys.length; i++) {
            langNames[i] = LanguageManager.getAvailableLanguages().get(settingsLangKeys[i]);
        }
        dlgLanguage.setAdapter(themedAdapter(dialogCtx, langNames));
        applySpinnerStyle(dlgLanguage);
        dlgLanguage.setLayoutParams(spLp);
        root.addView(dlgLanguage);
        dlgLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSyncing) return;
                String oldLang = settings.language;
                settings.language = settingsLangKeys[position];
                if (!oldLang.equals(settings.language)) {
                    settings.save(MainActivity.this);
                    LanguageManager.init(settings.language);
                    updateDialogStrings(dialogRoot);
                    applyMode();
                    if (settings.showTable) buildMorseTable();
                    applyUiSettings();
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Keyboard Type logic moved above User Interface
        
        // Find current selection
        int currentKbIdx = 0;
        for (int i = 0; i < keyboardTypes.length; i++) {
            if (keyboardTypes[i].equals(settings.keyboardType)) {
                currentKbIdx = i;
                break;
            }
        }
        dlgKeyboardType.setSelection(currentKbIdx);
        
        dlgChkPickLangThemeOnShare.setChecked(settings.pickLangThemeOnShare);
        dlgChkPickLangThemeOnShare.setOnCheckedChangeListener((btn, isChecked) -> {
            if (isSyncing) return;
            settings.pickLangThemeOnShare = isChecked;
            settings.save(MainActivity.this);
        });
        
        dlgKeyboardType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSyncing) return;
                String oldKb = settings.keyboardType;
                settings.keyboardType = keyboardTypes[position];
                if (!oldKb.equals(settings.keyboardType)) {
                    settings.save(MainActivity.this);
                    if (gameController != null) gameController.setupCustomKeyboard();
                    // No direct UI change until game is started
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
        dlgTable = chkBox(SHOW_TABLE);
        dlgTableCodes = chkBox(SHOW_TABLE_CODES);
        dlgVisual = chkBox(SHOW_VISUAL);
        dlgShowPaddles = chkBox(SHOW_PADDLES);
        dlgNextWordIndicator = chkBox(NEXT_WORD_INDICATOR);
        dlgKeepScreenOn = chkBox(KEEP_SCREEN_ON);
        root.addView(dlgTable);
        root.addView(dlgTableCodes);
        dlgVisual.setId(View.generateViewId());
        root.addView(dlgVisual);
        root.addView(dlgShowPaddles);
        root.addView(dlgNextWordIndicator);
        root.addView(dlgKeepScreenOn);

        dlgTable.setOnClickListener(v -> {
            settings.showTable = dlgTable.isChecked();
            settings.save(this);
            syncSettingsDialog();
            if (settings.showTable) {
                scrollTable.setVisibility(View.VISIBLE);
                if (tableContent.getChildCount() == 0)
                    buildMorseTable();
            } else {
                scrollTable.setVisibility(View.GONE);
            }
            applyOrientation();
        });
        dlgTableCodes.setOnClickListener(v -> {
            settings.showTableCodes = dlgTableCodes.isChecked();
            settings.save(this);
            syncSettingsDialog();
            if (settings.showTable) buildMorseTable();
        });
        dlgVisual.setOnClickListener(v -> {
            settings.visual = dlgVisual.isChecked();
            settings.save(this);
            syncSettingsDialog();
        });
        dlgShowPaddles.setOnClickListener(v -> {
            settings.showPaddles = dlgShowPaddles.isChecked();
            settings.save(this);
            syncSettingsDialog();
            applyOrientation();
        });
        dlgNextWordIndicator.setOnClickListener(v -> {
            settings.showNextWordIndicator = dlgNextWordIndicator.isChecked();
            settings.save(this);
            syncSettingsDialog();
        });
        dlgKeepScreenOn.setOnClickListener(v -> {
            settings.keepScreenOn = dlgKeepScreenOn.isChecked();
            settings.save(this);
            applyKeepScreenOn();
            syncSettingsDialog();
        });


        root.addView(subLabel(APP_THEME));
        dlgAppTheme = new Spinner(dialogCtx);
        dlgAppTheme.setTag("THEME_SPINNER");
        String[] themes = { "dark", "light" };
        String[] themesDisp = {
            LanguageManager.get(DARK_THEME),
            LanguageManager.get(LIGHT_THEME)
        };
        ArrayAdapter<String> adapterTheme = themedAdapter(dialogCtx, themesDisp);
        dlgAppTheme.setAdapter(adapterTheme);
        applySpinnerStyle(dlgAppTheme);
        dlgAppTheme.setLayoutParams(spLp);
        root.addView(dlgAppTheme);
        dlgAppTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String oldTheme = settings.appTheme;
                settings.appTheme = themes[position];
                if (!oldTheme.equals(settings.appTheme)) {
                    settings.save(MainActivity.this);
                    applyTheme();
                    syncSettingsDialog();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        root.addView(subLabel(TEXT_COLOR));
        dlgLetterColor = new Spinner(dialogCtx);
        dlgLetterColor.setTag("COLOR_SPINNER");
        applySpinnerStyle(dlgLetterColor);
        // We will update adapter in syncSettingsDialog
        dlgLetterColor.setLayoutParams(spLp);
        root.addView(dlgLetterColor);
        dlgLetterColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] currentColors = getAvailableColors();
                settings.letterColor = currentColors[position];
                settings.save(MainActivity.this);
                applyUiSettings();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        root.addView(subLabel(TEXT_FONT_SIZE));
        LinearLayout fsRow = hRow();
        fsRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekFontSize = new SeekBar(this);
        dlgSeekFontSize.setMax(47); // 13 to 60
        dlgSeekFontSize.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtFontSize = new TextView(this);
        dlgTxtFontSize.setTextColor(C_TEXT);
        dlgTxtFontSize.setGravity(Gravity.CENTER);
        dlgTxtFontSize.setLayoutParams(new LinearLayout.LayoutParams(dp(60), -2));
        fsRow.addView(dlgSeekFontSize);
        fsRow.addView(dlgTxtFontSize);
        root.addView(fsRow);
        dlgSeekFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                settings.fontSize = 13 + progress;
                dlgTxtFontSize.setText(settings.fontSize + " sp");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                settings.save(MainActivity.this);
                applyUiSettings();
            }
        });

        root.addView(subLabel(TABLE_FONT_SIZE));
        LinearLayout tfsRow = hRow();
        tfsRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekTableFontSize = new SeekBar(this);
        dlgSeekTableFontSize.setMax(10); // -5 to +5
        dlgSeekTableFontSize.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtTableFontSize = new TextView(this);
        dlgTxtTableFontSize.setTextColor(C_TEXT);
        dlgTxtTableFontSize.setGravity(Gravity.CENTER);
        dlgTxtTableFontSize.setLayoutParams(new LinearLayout.LayoutParams(dp(60), -2));
        tfsRow.addView(dlgSeekTableFontSize);
        tfsRow.addView(dlgTxtTableFontSize);
        root.addView(tfsRow);
        dlgSeekTableFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                settings.tableFontSizeDelta = progress - 5;
                dlgTxtTableFontSize.setText((settings.tableFontSizeDelta >= 0 ? "+" : "") + settings.tableFontSizeDelta);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                settings.save(MainActivity.this);
                if (settings.showTable) buildMorseTable();
            }
        });

        root.addView(subLabel(TABLE_RATIO));
        LinearLayout trRow = hRow();
        trRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekTableRatio = new SeekBar(this);
        dlgSeekTableRatio.setMax(60); // 20 to 80
        dlgSeekTableRatio.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtTableRatio = new TextView(this);
        dlgTxtTableRatio.setTextColor(C_TEXT);
        dlgTxtTableRatio.setGravity(Gravity.CENTER);
        dlgTxtTableRatio.setLayoutParams(new LinearLayout.LayoutParams(dp(60), -2));
        trRow.addView(dlgSeekTableRatio);
        trRow.addView(dlgTxtTableRatio);
        root.addView(trRow);
        dlgSeekTableRatio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) return;
                settings.tableRatio = 20 + progress;
                dlgTxtTableRatio.setText(settings.tableRatio + "%");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                settings.save(MainActivity.this);
                applyOrientation();
            }
        });

        // Advanced (performance)
        root.addView(label(ADVANCED));
        
        dlgKeepAlive = chkBox(KEEP_ALIVE);
        root.addView(dlgKeepAlive);
        dlgKeepAlive.setOnClickListener(v -> {
            settings.keepAlive = dlgKeepAlive.isChecked();
            toneEngine.setKeepAlive(settings.keepAlive);
            settings.save(this);
            syncSettingsDialog();
        });

        dlgWhiteNoise = chkBox(WHITE_NOISE);
        LinearLayout.LayoutParams wnLp = (LinearLayout.LayoutParams) dlgWhiteNoise.getLayoutParams();
        wnLp.setMargins(dp(40), 0, 0, dp(4));
        dlgWhiteNoise.setLayoutParams(wnLp);
        root.addView(dlgWhiteNoise);
        dlgWhiteNoise.setOnClickListener(v -> {
            settings.whiteNoise = dlgWhiteNoise.isChecked();
            toneEngine.setWhiteNoise(settings.whiteNoise);
            settings.save(this);
            syncSettingsDialog();
        });

        dlgLblWhiteNoiseVol = subLabel(VOLUME);
        LinearLayout.LayoutParams lblWnVolLp = (LinearLayout.LayoutParams) dlgLblWhiteNoiseVol.getLayoutParams();
        lblWnVolLp.setMargins(dp(40), 0, 0, 0);
        dlgLblWhiteNoiseVol.setLayoutParams(lblWnVolLp);
        root.addView(dlgLblWhiteNoiseVol);

        LinearLayout wnVolRow = hRow();
        wnVolRow.setPadding(dp(56), 0, 0, 0);
        dlgSeekWhiteNoiseVol = new SeekBar(this);
        dlgSeekWhiteNoiseVol.setMax(99); // 0.1 to 10.0 in 0.1 steps
        dlgSeekWhiteNoiseVol.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtWhiteNoiseVol = new TextView(this);
        dlgTxtWhiteNoiseVol.setTextColor(C_TEXT);
        dlgTxtWhiteNoiseVol.setMinWidth(dp(64));
        dlgTxtWhiteNoiseVol.setTextSize(15);
        wnVolRow.addView(dlgSeekWhiteNoiseVol);
        wnVolRow.addView(dlgTxtWhiteNoiseVol);
        root.addView(wnVolRow);

        dlgSeekWhiteNoiseVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                float v = 0.1f + p / 10.0f;
                dlgTxtWhiteNoiseVol.setText(String.format(java.util.Locale.US, "%.1f%%", v));
                settings.whiteNoiseVolume = v;
                toneEngine.setWhiteNoiseVolume(v);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        setupClickableLabel(dlgTxtWhiteNoiseVol, 0.1f, 10.0f, true, v -> {
            settings.whiteNoiseVolume = v;
            toneEngine.setWhiteNoiseVolume(v);
            dlgSeekWhiteNoiseVol.setProgress(Math.round((v - 0.1f) * 10.0f));
        });

        dlgLblWhiteNoiseFreq = subLabel(FREQUENCY);
        LinearLayout.LayoutParams lblWnFreqLp = (LinearLayout.LayoutParams) dlgLblWhiteNoiseFreq.getLayoutParams();
        lblWnFreqLp.setMargins(dp(40), 0, 0, 0);
        dlgLblWhiteNoiseFreq.setLayoutParams(lblWnFreqLp);
        root.addView(dlgLblWhiteNoiseFreq);

        LinearLayout wnFreqRow = hRow();
        wnFreqRow.setPadding(dp(56), 0, 0, 0);
        dlgSeekWhiteNoiseFreq = new SeekBar(this);
        dlgSeekWhiteNoiseFreq.setMax(3850); // 150 to 4000
        dlgSeekWhiteNoiseFreq.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtWhiteNoiseFreq = new TextView(this);
        dlgTxtWhiteNoiseFreq.setTextColor(C_TEXT);
        dlgTxtWhiteNoiseFreq.setMinWidth(dp(64));
        dlgTxtWhiteNoiseFreq.setTextSize(15);
        wnFreqRow.addView(dlgSeekWhiteNoiseFreq);
        wnFreqRow.addView(dlgTxtWhiteNoiseFreq);
        root.addView(wnFreqRow);

        dlgSeekWhiteNoiseFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                int hz = 150 + p;
                dlgTxtWhiteNoiseFreq.setText(hz + " Hz");
                settings.whiteNoiseFrequency = hz;
                toneEngine.setWhiteNoiseFrequency(hz);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        setupClickableLabel(dlgTxtWhiteNoiseFreq, 150, 4000, false, v -> {
            settings.whiteNoiseFrequency = (int)v;
            toneEngine.setWhiteNoiseFrequency((int)v);
            dlgSeekWhiteNoiseFreq.setProgress((int)v - 150);
        });

        root.addView(subLabel(AUDIO_BUFFER));
        LinearLayout bufRow = hRow();
        bufRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekBuffer = new SeekBar(this);
        dlgSeekBuffer.setMax(45); // 5 to 50
        dlgSeekBuffer.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtBuffer = new TextView(this);
        dlgTxtBuffer.setTextColor(C_TEXT);
        dlgTxtBuffer.setMinWidth(dp(64));
        dlgTxtBuffer.setTextSize(15);
        bufRow.addView(dlgSeekBuffer);
        bufRow.addView(dlgTxtBuffer);
        root.addView(bufRow);
        dlgSeekBuffer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                float ms = 5.0f + p;
                dlgTxtBuffer.setText(String.format("%.0f ms", ms));
                settings.bufferMs = ms;
                toneEngine.setBufferMs(ms);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        root.addView(subLabel(PROCESSING_CHUNK));
        LinearLayout chunkRow = hRow();
        chunkRow.setPadding(dp(16), 0, 0, 0);
        dlgSeekChunk = new SeekBar(this);
        dlgSeekChunk.setMax(95); // 0.5 to 10.0 in 0.1 steps
        dlgSeekChunk.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1));
        dlgTxtChunk = new TextView(this);
        dlgTxtChunk.setTextColor(C_TEXT);
        dlgTxtChunk.setMinWidth(dp(64));
        dlgTxtChunk.setTextSize(15);
        chunkRow.addView(dlgSeekChunk);
        chunkRow.addView(dlgTxtChunk);
        root.addView(chunkRow);
        dlgSeekChunk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar sb, int p, boolean u) {
                float ms = 0.5f + p / 10.0f;
                dlgTxtChunk.setText(String.format("%.1f ms", ms));
                settings.chunkMs = ms;
                toneEngine.setChunkMs(ms);
            }
            @Override public void onStartTrackingTouch(SeekBar sb) {}
            @Override public void onStopTrackingTouch(SeekBar sb) { settings.save(MainActivity.this); }
        });

        root.addView(infoText(PERFORMANCE_HINT));

        // Make labels clickable for direct input
        setupClickableLabel(dlgTxtFreq, 150, 4000, false, v -> {
            settings.tone = (int)v;
            toneEngine.setFrequency((int)v);
        });
        setupClickableLabel(dlgTxtVol, 0, 100, false, v -> {
            settings.vol = (int)v;
            toneEngine.setVolume((int)v);
        });
        setupClickableLabel(dlgTxtEnvelope, 0, 2, true, v -> {
            settings.envelopeMs = v;
            toneEngine.setEnvelopeMs(v);
        });
        setupClickableLabel(dlgTxtBuffer, 5, 50, false, v -> {
            settings.bufferMs = v;
            toneEngine.setBufferMs(v);
        });
        setupClickableLabel(dlgTxtChunk, 0.5f, 10, true, v -> {
            settings.chunkMs = v;
            toneEngine.setChunkMs(v);
        });
        setupClickableLabel(dlgTxtFontSize, 13, 60, false, v -> {
            settings.fontSize = (int)v;
            applyUiSettings();
        });
        setupClickableLabel(dlgTxtWpm, 1, 60, false, v -> {
            settings.wpm = (int)v;
            settings.save(this);
            syncSettingsDialog();
        });
        setupClickableLabel(dlgTxtTableFontSize, -5, 5, false, v -> {
            settings.tableFontSizeDelta = (int)v;
            if (settings.showTable) buildMorseTable();
        });
        setupClickableLabel(dlgTxtTableRatio, 20, 80, false, v -> {
            settings.tableRatio = (int)v;
            applyOrientation();
        });
        setupClickableLabel(dlgTxtInterletterSpacing, 10, 500, false, v -> {
            settings.interletterSpacing = (int)v;
        });
        setupClickableLabel(dlgTxtInterwordSpacing, 10, 500, false, v -> {
            settings.interwordSpacing = (int)v;
        });

        // Decoder behavior
        dlgDecoderSpinners.clear();
        if (!MorseTable.COLLISIONS.isEmpty()) {
            root.addView(label(DECODER_BEHAVIOR));
            
            // Calculate absolute max width for uniform column
            float maxSpTextWidth = 0;
            Paint p = new Paint();
            p.setTextSize(15 * getResources().getDisplayMetrics().scaledDensity);
            for (java.util.List<String> names : MorseTable.COLLISIONS.values()) {
                float w = p.measureText(MorseTable.formatCombined(names));
                if (w > maxSpTextWidth) maxSpTextWidth = w;
            }
            int fixedSpWidth = (int)maxSpTextWidth + dp(44);

            android.widget.TableLayout table = new android.widget.TableLayout(dialogCtx);
            table.setColumnShrinkable(1, false); // Prevent shrinking
            LinearLayout.LayoutParams tableLp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tableLp.gravity = Gravity.LEFT;
            tableLp.setMargins(dp(24), 0, 0, dp(8));
            table.setLayoutParams(tableLp);
            
            for (Map.Entry<String, List<String>> entry : MorseTable.COLLISIONS.entrySet()) {
                String code = entry.getKey();
                List<String> names = entry.getValue();

                String combined = MorseTable.formatCombined(names);

                android.widget.TableRow row = new android.widget.TableRow(dialogCtx);
                row.setGravity(Gravity.CENTER_VERTICAL);
                android.widget.TableLayout.LayoutParams rowLp = new android.widget.TableLayout.LayoutParams(
                        android.widget.TableLayout.LayoutParams.WRAP_CONTENT, android.widget.TableLayout.LayoutParams.WRAP_CONTENT);
                rowLp.setMargins(0, 0, 0, dp(4));
                row.setLayoutParams(rowLp);

                TextView codeTxt = new TextView(dialogCtx);
                codeTxt.setText(code);
                codeTxt.setTextColor(C_TEXT);
                codeTxt.setTextSize(15);
                codeTxt.setTypeface(androidx.core.content.res.ResourcesCompat.getFont(this, R.font.roboto_mono), Typeface.BOLD);
                codeTxt.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                android.widget.TableRow.LayoutParams txtLp = new android.widget.TableRow.LayoutParams(
                        android.widget.TableRow.LayoutParams.WRAP_CONTENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT);
                txtLp.rightMargin = dp(12);
                codeTxt.setLayoutParams(txtLp);
                row.addView(codeTxt);

                Spinner sp = new Spinner(dialogCtx);
                sp.setTag("small");
                List<String> options = new ArrayList<>();
                options.add(combined);
                for (String name : names) {
                    options.add(MorseTable.formatSymbol(name));
                }

                sp.setAdapter(themedAdapterStr(dialogCtx, new ArrayList<>(options)));
                applySmallSpinnerStyle(sp);
                
                android.widget.TableRow.LayoutParams spRowLp = new android.widget.TableRow.LayoutParams(
                        fixedSpWidth, android.widget.TableRow.LayoutParams.WRAP_CONTENT);
                sp.setLayoutParams(spRowLp);
                row.addView(sp);

                table.addView(row);

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (isSyncing) return;
                        String choice = options.get(position);
                        if (position == 0) {
                            settings.decoderChoices.remove(code);
                        } else {
                            settings.decoderChoices.put(code, choice);
                        }
                        settings.save(MainActivity.this);
                        if (settings.showTable) buildMorseTable();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                
                dlgDecoderSpinners.put(code, sp);
            }
            root.addView(table);
        }

        syncSettingsDialog();

        ScrollView sv = new ScrollView(dialogCtx);
        sv.setBackgroundColor(C_BG);
        sv.addView(root);
        this.dialogSv = sv;

        // Spacer before buttons
        View bottomSpacer = new View(this);
        bottomSpacer.setLayoutParams(new LinearLayout.LayoutParams(1, dp(10)));
        root.addView(bottomSpacer);

        LinearLayout titleLayout = new LinearLayout(dialogCtx);
        titleLayout.setOrientation(LinearLayout.HORIZONTAL);
        titleLayout.setGravity(Gravity.CENTER_VERTICAL);
        titleLayout.setLayoutParams(new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, dp(60)
        ));
        titleLayout.setPadding(dp(3), dp(3), dp(3), dp(3));
        
        android.widget.ImageView backBtn = new android.widget.ImageView(dialogCtx);
        backBtn.setImageResource(R.drawable.ic_arrow_back);
        backBtn.setColorFilter(C_TEXT);
        backBtn.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        LinearLayout.LayoutParams backBtnLp = new LinearLayout.LayoutParams(dp(54), dp(54));
        backBtnLp.setMarginEnd(dp(8));
        backBtn.setLayoutParams(backBtnLp);
        
        android.util.TypedValue outValue = new android.util.TypedValue();
        dialogCtx.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true);
        backBtn.setBackgroundResource(outValue.resourceId);
        backBtn.setPadding(dp(12), dp(12), dp(12), dp(12));
        backBtn.setOnClickListener(v -> {
            if (settingsDialog != null) settingsDialog.dismiss();
        });
        
        TextView titleView = new TextView(dialogCtx);
        titleView.setText(LanguageManager.get(SETTINGS_TITLE));
        titleView.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 24);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        titleView.setTextColor(C_TEXT);
        titleView.setTypeface(null, Typeface.BOLD);
        
        titleLayout.addView(backBtn);
        titleLayout.addView(titleView);

        settingsDialog = new AlertDialog.Builder(this, getDialogTheme())
                .setCustomTitle(titleLayout)
                .setView(sv)
                .setPositiveButton(LanguageManager.get(SAVE), null)
                .setNeutralButton(LanguageManager.get(RESET_DEFAULTS), null)
                .create();
        settingsDialog.show();

        Button btnSave = settingsDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (btnSave != null) {
            btnSave.setAllCaps(false);
            btnSave.setTypeface(null, Typeface.BOLD);
            btnSave.setTextColor(0xFF007ACC);
            float currentSizeSp = btnSave.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            btnSave.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, currentSizeSp + 2);
        }

        Button btnReset = settingsDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        if (btnReset != null) {
            btnReset.setAllCaps(false);
            // Nice red that works in both dark and light
            btnReset.setTextColor(0xFFCC0000);
            float currentSizeSp = btnReset.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            btnReset.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, currentSizeSp + 2);
            btnReset.setOnClickListener(v -> {
                settings.resetToDefaults();
                settings.save(this);
                LanguageManager.init(settings.language);
                toneEngine.setToneType(settings.toneType);
                toneEngine.setFrequency(settings.tone);
                toneEngine.setVolume(settings.vol);
                toneEngine.setBufferMs(settings.bufferMs);
                toneEngine.setEnvelopeMs(settings.envelopeMs);
                toneEngine.setChunkMs(settings.chunkMs);
                toneEngine.setKeepAlive(settings.keepAlive);
                toneEngine.setWhiteNoise(settings.whiteNoise);
                toneEngine.setWhiteNoiseVolume(settings.whiteNoiseVolume);
                toneEngine.setWhiteNoiseFrequency(settings.whiteNoiseFrequency);
                applyTheme();
                updateDialogStrings(dialogRoot);
                applyUiSettings();
                syncSettingsDialog();
                applyOrientation();
                applyKeepScreenOn();
            });
        }
        if (settingsDialog.getWindow() != null) {
            settingsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(C_BG));
            settingsDialog.getWindow().setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.95),
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private String getLocalizedColorName(String color) {
        switch (color) {
            case "white": return LanguageManager.get(COLOR_WHITE);
            case "black": return LanguageManager.get(COLOR_BLACK);
            case "red": return LanguageManager.get(COLOR_RED);
            case "orange": return LanguageManager.get(COLOR_ORANGE);
            case "yellow": return LanguageManager.get(COLOR_YELLOW);
            case "green": return LanguageManager.get(COLOR_GREEN);
            case "cyan": return LanguageManager.get(COLOR_CYAN);
            case "blue": return LanguageManager.get(COLOR_BLUE);
            case "purple": return LanguageManager.get(COLOR_PURPLE);
            case "pink": return LanguageManager.get(COLOR_PINK);
            default: return color.substring(0, 1).toUpperCase() + color.substring(1);
        }
    }

    private String[] getAvailableColors() {
        boolean dark = "dark".equals(settings.appTheme);
        if (dark)
            return new String[] { "white", "red", "orange", "yellow", "green", "cyan", "blue", "purple", "pink" };
        else
            return new String[] { "black", "red", "orange", "yellow", "green", "cyan", "blue", "purple", "pink" };
    }

    private void syncSettingsDialog() {
        if (dlgMode == null || isSyncing)
            return;
        isSyncing = true;

        int pos = 1;
        if ("straight".equals(settings.mode)) pos = 0;
        else if ("iambic-a".equals(settings.mode)) pos = 1;
        else if ("iambic-b".equals(settings.mode)) pos = 2;
        else if ("ultimatic".equals(settings.mode)) pos = 3;
        else if ("bug".equals(settings.mode)) pos = 4;
        else if ("cootie".equals(settings.mode)) pos = 5;
        dlgMode.setSelection(pos);

        dlgInverse.setChecked("inverse".equals(settings.polarity));
        boolean hideInverse = "straight".equals(settings.mode) || "cootie".equals(settings.mode);
        dlgInverse.setEnabled(!hideInverse);
        dlgInverse.setAlpha(hideInverse ? 0.4f : 1.0f);
        dlgTxtWpm.setText(String.valueOf(settings.wpm));
        dlgNoclick.setChecked("sawtooth".equals(settings.toneType));
        dlgStrict.setChecked(settings.strict);
        dlgSeekFreq.setProgress(settings.tone - 150);
        dlgTxtFreq.setText(settings.tone + " Hz");
        dlgSeekVol.setProgress(settings.vol);
        dlgTxtVol.setText(settings.vol + "%");
        dlgTable.setChecked(settings.showTable);
        dlgTableCodes.setChecked(settings.showTableCodes);
        dlgTableCodes.setEnabled(settings.showTable);
        dlgTableCodes.setAlpha(settings.showTable ? 1.0f : 0.4f);
        dlgVisual.setChecked(settings.visual);
        dlgShowPaddles.setChecked(settings.showPaddles);
        dlgNextWordIndicator.setChecked(settings.showNextWordIndicator);
        dlgKeepScreenOn.setChecked(settings.keepScreenOn);
        dlgKeepAlive.setChecked(settings.keepAlive);
        dlgWhiteNoise.setChecked(settings.whiteNoise);
        dlgWhiteNoise.setEnabled(settings.keepAlive);
        dlgWhiteNoise.setAlpha(settings.keepAlive ? 1.0f : 0.4f);

        dlgSeekWhiteNoiseVol.setProgress(Math.round((settings.whiteNoiseVolume - 0.1f) * 10.0f));
        dlgTxtWhiteNoiseVol.setText(String.format(java.util.Locale.US, "%.1f%%", settings.whiteNoiseVolume));
        dlgSeekWhiteNoiseFreq.setProgress(settings.whiteNoiseFrequency - 150);
        dlgTxtWhiteNoiseFreq.setText(settings.whiteNoiseFrequency + " Hz");

        boolean wnEnabled = settings.keepAlive && settings.whiteNoise;
        float wnAlpha = wnEnabled ? 1.0f : 0.4f;
        dlgLblWhiteNoiseVol.setEnabled(wnEnabled);
        dlgLblWhiteNoiseVol.setAlpha(wnAlpha);
        dlgSeekWhiteNoiseVol.setEnabled(wnEnabled);
        dlgSeekWhiteNoiseVol.setAlpha(wnAlpha);
        dlgTxtWhiteNoiseVol.setEnabled(wnEnabled);
        dlgTxtWhiteNoiseVol.setAlpha(wnAlpha);
        
        dlgLblWhiteNoiseFreq.setEnabled(wnEnabled);
        dlgLblWhiteNoiseFreq.setAlpha(wnAlpha);
        dlgSeekWhiteNoiseFreq.setEnabled(wnEnabled);
        dlgSeekWhiteNoiseFreq.setAlpha(wnAlpha);
        dlgTxtWhiteNoiseFreq.setEnabled(wnEnabled);
        dlgTxtWhiteNoiseFreq.setAlpha(wnAlpha);

        String[] themes = { "dark", "light" };
        for (int i = 0; i < themes.length; i++) {
            if (themes[i].equals(settings.appTheme)) {
                dlgAppTheme.setSelection(i);
                break;
            }
        }

        int lPos = 0;
        if (settingsLangKeys != null) {
            for (int i = 0; i < settingsLangKeys.length; i++) {
                if (settingsLangKeys[i].equals(settings.language)) {
                    lPos = i;
                    break;
                }
            }
        }
        dlgLanguage.setSelection(lPos);
        if (dlgKeyboardType != null) {
            String[] kbTypes = { "QWERTY", "QWERTZ", "AZERTY" };
            for (int i = 0; i < kbTypes.length; i++) {
                if (kbTypes[i].equals(settings.keyboardType)) {
                    dlgKeyboardType.setSelection(i);
                    break;
                }
            }
        }
        
        if (dlgChkPickLangThemeOnShare != null) {
            dlgChkPickLangThemeOnShare.setChecked(settings.pickLangThemeOnShare);
        }
        String[] currentColors = getAvailableColors();
        ArrayList<String> currentColorsDisp = new ArrayList<>();
        for (int i = 0; i < currentColors.length; i++) {
            currentColorsDisp.add(getLocalizedColorName(currentColors[i]));
        }
        Context adapterCtx = (dialogCtx != null) ? dialogCtx : this;
        ArrayAdapter<String> adapterCol = themedAdapterStr(adapterCtx, currentColorsDisp);
        dlgLetterColor.setAdapter(adapterCol);

        for (int i = 0; i < currentColors.length; i++) {
            if (currentColors[i].equals(settings.letterColor)) {
                dlgLetterColor.setSelection(i);
                break;
            }
        }

        dlgSeekFontSize.setProgress(settings.fontSize - 13);
        dlgTxtFontSize.setText(settings.fontSize + " sp");

        dlgSeekTableFontSize.setProgress(settings.tableFontSizeDelta + 5);
        dlgTxtTableFontSize.setText((settings.tableFontSizeDelta >= 0 ? "+" : "") + settings.tableFontSizeDelta);

        dlgSeekTableRatio.setProgress(settings.tableRatio - 20);
        dlgTxtTableRatio.setText(settings.tableRatio + "%");

        dlgSeekInterletterSpacing.setProgress((settings.strict ? 100 : settings.interletterSpacing) - 10);
        dlgTxtInterletterSpacing.setText(settings.strict ? "100%" : (settings.interletterSpacing + "%"));
        dlgSeekInterletterSpacing.setEnabled(!settings.strict);
        dlgSeekInterletterSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);
        dlgTxtInterletterSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);
        if (dlgLblInterletterSpacing != null) dlgLblInterletterSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);

        dlgSeekInterwordSpacing.setProgress((settings.strict ? 100 : settings.interwordSpacing) - 10);
        dlgTxtInterwordSpacing.setText(settings.strict ? "100%" : (settings.interwordSpacing + "%"));
        dlgSeekInterwordSpacing.setEnabled(!settings.strict);
        dlgSeekInterwordSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);
        dlgTxtInterwordSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);
        if (dlgLblInterwordSpacing != null) dlgLblInterwordSpacing.setAlpha(settings.strict ? 0.4f : 1.0f);

        dlgSeekBuffer.setProgress((int) (settings.bufferMs - 5));
        dlgTxtBuffer.setText(String.format("%.0f ms", settings.bufferMs));

        dlgSeekEnvelope.setProgress((int) (settings.envelopeMs * 100));
        dlgTxtEnvelope.setText(String.format("%.2f ms", settings.envelopeMs));

        dlgSeekChunk.setProgress((int) ((settings.chunkMs - 0.5f) * 10));
        dlgTxtChunk.setText(String.format("%.1f ms", settings.chunkMs));

        for (Map.Entry<String, Spinner> entry : dlgDecoderSpinners.entrySet()) {
            String code = entry.getKey();
            Spinner sp = entry.getValue();
            String currentChoice = settings.decoderChoices.get(code);
            int selIndex = 0;
            if (currentChoice != null) {
                // The options are 0: combined, 1: sym1, 2: sym2
                List<String> names = MorseTable.COLLISIONS.get(code);
                if (names != null) {
                    for (int j = 0; j < names.size(); j++) {
                        if (MorseTable.formatSymbol(names.get(j)).equals(currentChoice)) {
                            selIndex = j + 1;
                            break;
                        }
                    }
                }
            }
            sp.setSelection(selIndex);
        }

        applyMode();
        isSyncing = false;
    }

    private void setupWpmBtn(Button btn, int delta) {
        btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_UTL));
        btn.setTextColor(C_TEXT);
        btn.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    updateWpm(delta);
                    wpmHandler.postDelayed(() -> {
                        Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                updateWpm(delta);
                                wpmHandler.postDelayed(this, 120);
                            }
                        };
                        wpmHandler.post(r);
                    }, 180);
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    wpmHandler.removeCallbacksAndMessages(null);
                    return true;
            }
            return false;
        });
    }

    private void updateWpm(int delta) {
        settings.wpm = Math.max(1, Math.min(60, settings.wpm + delta));
        settings.save(this);
        syncSettingsDialog();
    }

    // ============================================================
    // Info dialog
    // ============================================================

    private void showInfoDialog() {
        String version = BuildConfig.APP_VERSION;
        String supportText = LanguageManager.get(SUPPORT_WINDLEREYE);
        String msg = LanguageManager.get(INFO_TEXT) + "\n\n" +
                "Copyright (c) 2026, Luis Quesada Torres (HB9IPH)\n\n" +
                supportText + "\n\n" +
                "version " + version;

        Context infoCtx = new ContextThemeWrapper(this, getDialogTheme());
        ScrollView sv = new ScrollView(infoCtx);
        sv.setBackgroundColor(C_BG);
        TextView tv = new TextView(infoCtx);
        
        android.text.SpannableString ss = new android.text.SpannableString(msg);
        int windlereyeIdx = msg.lastIndexOf("Windlereye");
        if (windlereyeIdx >= 0) {
            ss.setSpan(new android.text.style.URLSpan("https://windlereye.com"), windlereyeIdx, windlereyeIdx + 10, android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(ss);
        tv.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        
        tv.setTextColor(C_TEXT);
        tv.setPadding(dp(16), dp(16), dp(16), dp(16));
        tv.setTextSize(14);
        tv.setLineSpacing(0, 1.2f);

        LinearLayout container = new LinearLayout(infoCtx);
        container.setOrientation(LinearLayout.VERTICAL);
        container.addView(tv);

        // Spacer before buttons
        View bottomSpacer = new View(infoCtx);
        bottomSpacer.setLayoutParams(new LinearLayout.LayoutParams(1, dp(10)));
        container.addView(bottomSpacer);

        sv.addView(container);

        LinearLayout titleLayout = new LinearLayout(infoCtx);
        titleLayout.setOrientation(LinearLayout.HORIZONTAL);
        titleLayout.setGravity(Gravity.CENTER_VERTICAL);
        titleLayout.setLayoutParams(new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, dp(60)
        ));
        titleLayout.setPadding(dp(3), dp(3), dp(3), dp(3));
        
        android.widget.ImageView backBtn = new android.widget.ImageView(infoCtx);
        backBtn.setImageResource(R.drawable.ic_arrow_back);
        backBtn.setColorFilter(C_TEXT);
        backBtn.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        LinearLayout.LayoutParams backBtnLp = new LinearLayout.LayoutParams(dp(54), dp(54));
        backBtnLp.setMarginEnd(dp(8));
        backBtn.setLayoutParams(backBtnLp);
        
        android.util.TypedValue outValue = new android.util.TypedValue();
        infoCtx.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true);
        backBtn.setBackgroundResource(outValue.resourceId);
        backBtn.setPadding(dp(12), dp(12), dp(12), dp(12));
        
        TextView titleView = new TextView(infoCtx);
        titleView.setText(LanguageManager.get(INFO_TITLE));
        titleView.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 24);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        titleView.setTextColor(C_TEXT);
        titleView.setTypeface(null, Typeface.BOLD);
        
        titleLayout.addView(backBtn);
        titleLayout.addView(titleView);

        final AlertDialog[] diagRef = new AlertDialog[1];
        backBtn.setOnClickListener(v -> {
            if (diagRef[0] != null) diagRef[0].dismiss();
        });

        AlertDialog diag = new AlertDialog.Builder(this, getDialogTheme())
                .setCustomTitle(titleLayout)
                .setView(sv)
                .setPositiveButton(LanguageManager.get(CLOSE), null)
                .create();
        diagRef[0] = diag;
        diag.show();
        Button btnClose = diag.getButton(AlertDialog.BUTTON_POSITIVE);
        if (btnClose != null) {
            btnClose.setAllCaps(false);
            btnClose.setTypeface(null, Typeface.BOLD);
            btnClose.setTextColor(0xFF007ACC);
        }
        if (diag.getWindow() != null) {
            diag.getWindow().setBackgroundDrawable(new ColorDrawable(C_BG));
            diag.getWindow().setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.95),
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    // ============================================================
    // Paddle touch
    // ============================================================

    private boolean handlePaddleTouch(MotionEvent event, String side) {
        int action = event.getActionMasked();
        boolean isMouse = event.getToolType(0) == MotionEvent.TOOL_TYPE_MOUSE;

        if (isMouse) {
            return true;
        }

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                int id = event.getPointerId(event.getActionIndex());
                touchMap.put(id, side);
                keyer.handlePaddlePress(side, true);
                updatePaddleVisual(side, true);
                return true;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                int id = event.getPointerId(event.getActionIndex());
                String s = touchMap.remove(id);
                if (s != null) {
                    keyer.handlePaddlePress(s, false);
                    updatePaddleVisual(s, false);
                }
                return true;
            }
            case MotionEvent.ACTION_CANCEL: {
                for (Map.Entry<Integer, String> entry : touchMap.entrySet()) {
                    keyer.handlePaddlePress(entry.getValue(), false);
                    updatePaddleVisual(entry.getValue(), false);
                }
                touchMap.clear();
                return true;
            }
        }
        return true;
    }

    private void updatePaddleVisual(String side, boolean pressed) {
        if ("left".equals(side)) {
            paddleLeft.setBackgroundColor(pressed ? C_PP : C_PL);
        } else if ("right".equals(side)) {
            paddleRight.setBackgroundColor(pressed ? C_PP : C_PR);
        }
        if (gameController != null) {
            gameController.updatePaddleVisual(side, pressed, C_PP, "left".equals(side) ? C_PL : C_PR);
        }
    }

    // ============================================================
    // Keyboard — multiple layers to ensure USB keyboard adapters work
    // ============================================================

    // Track which sides are currently pressed via keyboard to avoid double-fire
    private boolean keyLeftPressed = false;
    private boolean keyRightPressed = false;

    private boolean handleKeyAction(int keyCode, int action, int repeatCount) {
        String side = keyToSide(keyCode);
        if (side == null)
            return false;

        if (action == KeyEvent.ACTION_DOWN) {
            if (repeatCount > 0)
                return true; // ignore auto-repeat
            boolean alreadyPressed = "left".equals(side) ? keyLeftPressed : keyRightPressed;
            if (alreadyPressed)
                return true; // already handled
            if ("left".equals(side))
                keyLeftPressed = true;
            else
                keyRightPressed = true;
            keyer.handlePaddlePress(side, true);
            updatePaddleVisual(side, true);
        } else if (action == KeyEvent.ACTION_UP) {
            if ("left".equals(side))
                keyLeftPressed = false;
            else
                keyRightPressed = false;
            keyer.handlePaddlePress(side, false);
            updatePaddleVisual(side, false);
        }
        return true;
    }


    private boolean handleMouseInput(MotionEvent event) {
        boolean isMouse = event.getToolType(0) == MotionEvent.TOOL_TYPE_MOUSE;
        if (!isMouse || paddleLeft == null || paddleRight == null) {
            return false;
        }

        int action = event.getActionMasked();
        int btnState = event.getButtonState();

        if (action == MotionEvent.ACTION_BUTTON_PRESS || action == MotionEvent.ACTION_DOWN) {
            btnState |= event.getActionButton();
        } else if (action == MotionEvent.ACTION_BUTTON_RELEASE) {
            btnState &= ~event.getActionButton();
        }

        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            btnState = 0;
        }

        if (mouseActiveSide == null) {
            if (btnState != 0) {
                int[] leftLoc = new int[2];
                paddleLeft.getLocationOnScreen(leftLoc);
                int rx = (int) event.getRawX();
                int ry = (int) event.getRawY();
                if (rx >= leftLoc[0] && rx < leftLoc[0] + paddleLeft.getWidth() &&
                    ry >= leftLoc[1] && ry < leftLoc[1] + paddleLeft.getHeight()) {
                    mouseActiveSide = "left";
                } else {
                    int[] rightLoc = new int[2];
                    paddleRight.getLocationOnScreen(rightLoc);
                    if (rx >= rightLoc[0] && rx < rightLoc[0] + paddleRight.getWidth() &&
                        ry >= rightLoc[1] && ry < rightLoc[1] + paddleRight.getHeight()) {
                        mouseActiveSide = "right";
                    }
                }
            }
        }

        if (mouseActiveSide != null) {
            boolean targetLeftPressed = false;
            boolean targetRightPressed = false;

            if (btnState != 0) {
                boolean primaryPressed = (btnState & MotionEvent.BUTTON_PRIMARY) != 0;
                boolean secondaryPressed = (btnState & MotionEvent.BUTTON_SECONDARY) != 0;

                if ("left".equals(mouseActiveSide)) {
                    targetLeftPressed = primaryPressed;
                    targetRightPressed = secondaryPressed;
                } else {
                    targetLeftPressed = secondaryPressed;
                    targetRightPressed = primaryPressed;
                }
            }

            if (targetLeftPressed != mouseLeftPaddlePressed) {
                mouseLeftPaddlePressed = targetLeftPressed;
                keyer.handlePaddlePress("left", mouseLeftPaddlePressed);
                updatePaddleVisual("left", mouseLeftPaddlePressed);
            }
            if (targetRightPressed != mouseRightPaddlePressed) {
                mouseRightPaddlePressed = targetRightPressed;
                keyer.handlePaddlePress("right", mouseRightPaddlePressed);
                updatePaddleVisual("right", mouseRightPaddlePressed);
            }

            if (btnState == 0) {
                mouseActiveSide = null;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (handleMouseInput(event)) {
            return true;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        if (handleMouseInput(event)) {
            return true;
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (gameController != null && gameController.canHandleBack()) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    gameController.onBackPressed();
                }
                return true;
            }
        }
        if (handleKeyAction(event.getKeyCode(), event.getAction(), event.getRepeatCount())) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (handleKeyAction(keyCode, KeyEvent.ACTION_DOWN, event.getRepeatCount())) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (handleKeyAction(keyCode, KeyEvent.ACTION_UP, 0)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private String keyToSide(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_LEFT_BRACKET: // [
            case KeyEvent.KEYCODE_A: // A
            case KeyEvent.KEYCODE_COMMA: // ,
            case KeyEvent.KEYCODE_DPAD_LEFT: // Arrow left
            case KeyEvent.KEYCODE_1:
            case KeyEvent.KEYCODE_0:
            case KeyEvent.KEYCODE_NUMPAD_1:
            case KeyEvent.KEYCODE_NUMPAD_0:
            case KeyEvent.KEYCODE_CTRL_LEFT: // Left Ctrl
            case KeyEvent.KEYCODE_SHIFT_LEFT: // Left Shift
            case KeyEvent.KEYCODE_ALT_LEFT: // Left Alt
            case KeyEvent.KEYCODE_NUMPAD_DOT: // Numpad .
            case KeyEvent.KEYCODE_F1: // F1
                return "left";
            case KeyEvent.KEYCODE_RIGHT_BRACKET: // ]
            case KeyEvent.KEYCODE_D: // D
            case KeyEvent.KEYCODE_S: // S
            case KeyEvent.KEYCODE_PERIOD: // .
            case KeyEvent.KEYCODE_DPAD_RIGHT: // Arrow right
            case KeyEvent.KEYCODE_3:
            case KeyEvent.KEYCODE_9:
            case KeyEvent.KEYCODE_NUMPAD_3:
            case KeyEvent.KEYCODE_NUMPAD_9:
            case KeyEvent.KEYCODE_CTRL_RIGHT: // Right Ctrl
            case KeyEvent.KEYCODE_SHIFT_RIGHT: // Right Shift
            case KeyEvent.KEYCODE_ALT_RIGHT: // Right Alt
            case KeyEvent.KEYCODE_NUMPAD_ENTER: // Numpad Enter
            case KeyEvent.KEYCODE_F2: // F2
                return "right";
        }
        return null;
    }

    // ============================================================
    // Morse table builder
    // ============================================================

    private void buildMorseTable() {
        tableContent.removeAllViews();
        List<MorseTableData.Section> sections = MorseTableData.getSections();
        int dp8 = dp(8), dp4 = dp(4), dp54 = dp(54);

        for (MorseTableData.Section section : sections) {
            TextView title = new TextView(this);
            title.setText(section.title);
            title.setTextColor(C_TEXT);
            title.setAlpha(0.6f);
            title.setTextSize(14);
            title.setTypeface(null, Typeface.BOLD);
            title.setPadding(0, dp8, 0, dp8);
            title.setGravity(Gravity.CENTER);
            tableContent.addView(title);

            LinearLayout flowRow = null;
            int cellSizeDp = 54 + settings.tableFontSizeDelta * 6;
            
            int screenWidth = getResources().getDisplayMetrics().widthPixels;
            int availableWidth = screenWidth;

            // Subtract padding (approx 12dp on each side) and calculate items per row
            int itemWidth = dp(cellSizeDp + 4);
            if (itemWidth <= 0) itemWidth = 1;
            int itemsPerRow = Math.max(1, (availableWidth - dp(24)) / itemWidth);

            for (int i = 0; i < section.items.size(); i++) {
                if (i % itemsPerRow == 0) {
                    flowRow = new LinearLayout(this);
                    flowRow.setOrientation(LinearLayout.HORIZONTAL);
                    flowRow.setGravity(Gravity.CENTER);
                    LinearLayout.LayoutParams rp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    rp.bottomMargin = dp4;
                    tableContent.addView(flowRow, rp);
                }

                MorseTableData.Item item = section.items.get(i);
                LinearLayout iv = new LinearLayout(this);
                iv.setOrientation(LinearLayout.VERTICAL);
                iv.setGravity(Gravity.CENTER);
                GradientDrawable bg = new GradientDrawable();
                bg.setColor(C_BTN);
                bg.setStroke(1, (C_BTN & 0x00FFFFFF) | 0x33000000);
                bg.setCornerRadius(dp(4));
                iv.setBackground(bg);
                iv.setPadding(dp(4), dp(4), dp(4), dp(4));

                int delta = settings.tableFontSizeDelta;
                int cellSize = dp(54 + delta * 6);
                LinearLayout.LayoutParams ip = new LinearLayout.LayoutParams(cellSize, cellSize);
                ip.setMargins(dp(2), 0, dp(2), 0);

                Typeface mono = androidx.core.content.res.ResourcesCompat.getFont(this, R.font.roboto_mono);

                TextView cv = new TextView(this);
                cv.setText(item.character);
                cv.setTextColor(C_TEXT);
                cv.setTextSize(13 + delta * 2);
                cv.setTypeface(mono, Typeface.BOLD);
                cv.setGravity(Gravity.CENTER);
                iv.addView(cv);

                if (item.morseCode != null && settings.showTableCodes) {
                    TextView mc = new TextView(this);
                    mc.setText(item.morseCode);
                    mc.setTextColor(C_TEXT);
                    mc.setTextSize(10 + delta);
                    mc.setAlpha(0.8f);
                    mc.setTypeface(mono, Typeface.BOLD);
                    mc.setGravity(Gravity.CENTER);
                    iv.addView(mc);
                }
                if (item.description != null) {
                    String fullText = item.character + " \u2014 " + item.description;
                    setupHoldTooltip(iv, fullText);
                }
                
                boolean isGrayedOut = false;
                if (item.morseCode != null && MorseTable.COLLISIONS.containsKey(item.morseCode)) {
                    String choice = settings.decoderChoices.get(item.morseCode);
                    if (choice != null) {
                        String defaultCombined = MorseTable.REVERSE_MORSE.get(item.morseCode);
                        if (!choice.equals(defaultCombined) && !choice.equals(item.character)) {
                            isGrayedOut = true;
                        }
                    }
                }
                if (isGrayedOut) {
                    iv.setAlpha(0.4f);
                } else {
                    iv.setAlpha(1.0f);
                }
                iv.setOnClickListener(v -> {
                    if (item.morseCode != null) {
                        keyer.playMorse(item.morseCode);
                    }
                });

                flowRow.addView(iv, ip);

            }
            tableContent.addView(new View(this), new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, dp(12)));
        }
    }

    // ============================================================
    // Helpers
    // ============================================================

    private void setupHoldTooltip(View v, String text) {
        v.setOnTouchListener((v1, event) -> {
            float x = event.getRawX();
            float y = event.getRawY();
                       if (event.getAction() == MotionEvent.ACTION_DOWN) {
                lastTooltipX = x;
                lastTooltipY = y;
                tooltipMoved = false;
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                float dx = x - lastTooltipX;
                float dy = y - lastTooltipY;
                if (Math.sqrt(dx*dx + dy*dy) > dp(8)) {
                    tooltipMoved = true;
                    hideTooltip();
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (!tooltipMoved) {
                    showTooltip(v1, text);
                    v1.performClick();
                }
            } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                hideTooltip();
            }
            return true;
        });
    }





    private void showTooltip(View anchor, String text) {
        hideTooltip(); // clear existing
        
        boolean light = isLight();
        int bgCol = light ? 0xEEFFFFFF : 0xCC000000;
        int textCol = light ? Color.BLACK : Color.WHITE;
        int borderCol = light ? 0xFF999999 : Color.WHITE;

        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextColor(textCol);
        tv.setTextSize(14);
        tv.setPadding(dp(16), dp(8), dp(16), dp(8));
        tv.setGravity(Gravity.CENTER);
        
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(bgCol);
        gd.setStroke(dp(1), borderCol);
        gd.setCornerRadius(dp(20));
        tv.setBackground(gd);
        
        tooltipWindow = new PopupWindow(tv, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tooltipWindow.setTouchable(false);
        
        int[] loc = new int[2];
        anchor.getLocationInWindow(loc);
        tv.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int x = loc[0] + anchor.getWidth() / 2 - tv.getMeasuredWidth() / 2;
        int y = loc[1] - tv.getMeasuredHeight() - dp(12);
        
        if (y < dp(24)) y = loc[1] + anchor.getHeight() + dp(12);
        if (x < dp(8)) x = dp(8);
        int screenW = getResources().getDisplayMetrics().widthPixels;
        if (x + tv.getMeasuredWidth() > screenW - dp(8)) x = screenW - dp(8) - tv.getMeasuredWidth();

        tooltipWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, x, y);
        
        // Auto-dismiss after 3 seconds
        tooltipHandler.postDelayed(tooltipDismissRunnable, 3000);
    }

    private void hideTooltip() {
        if (tooltipShowRunnable != null) {
            tooltipHandler.removeCallbacks(tooltipShowRunnable);
        }
        tooltipHandler.removeCallbacks(tooltipDismissRunnable);
        if (tooltipWindow != null) {
            tooltipWindow.dismiss();
            tooltipWindow = null;
        }
    }



    private Button togBtn(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(12);
        b.setTextColor(C_W);
        b.setAllCaps(false);
        b.setBackgroundColor(C_BTN);
        b.setMinWidth(0);
        b.setMinHeight(0);
        b.setMinimumWidth(0);
        b.setMinimumHeight(0);
        b.setPadding(dp(10), dp(6), dp(10), dp(6));
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_BTN));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, dp(10), dp(10));
        b.setLayoutParams(lp);
        return b;
    }

    private void tog(Button b, boolean on) {
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(on ? C_ACT : C_BTN));
    }

    private CheckBox chkBox(String key) {
        CheckBox c = new CheckBox(this);
        c.setText(LanguageManager.get(key));
        c.setTag(key);
        c.setTextColor(C_TEXT);
        c.setTextSize(15);
        c.setButtonTintList(android.content.res.ColorStateList.valueOf(C_TEXT));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dp(16), 0, 0, dp(4));
        c.setLayoutParams(lp);
        return c;
    }

    private RadioButton radBtn(String key) {
        RadioButton r = new RadioButton(this);
        r.setText(LanguageManager.get(key));
        r.setTag(key);
        r.setTextColor(C_TEXT);
        r.setTextSize(15);
        r.setButtonTintList(android.content.res.ColorStateList.valueOf(C_TEXT));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, dp(10), 0);
        r.setLayoutParams(lp);
        return r;
    }

    private TextView label(String key) {
        TextView t = new TextView(this);
        t.setText(LanguageManager.get(key));
        t.setTag(key);
        t.setTextColor(C_TEXT);
        t.setTextSize(15);
        t.setTypeface(null, Typeface.BOLD);
        t.setPadding(0, dp(18), 0, dp(4));
        return t;
    }

    private TextView subLabel(String key) {
        TextView t = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        t.setLayoutParams(lp);
        t.setText(LanguageManager.get(key));
        t.setTag(key);
        t.setTextColor(C_TEXT);
        t.setTextSize(15);
        t.setPadding(dp(16), 0, 0, dp(8));
        
        if (LANGUAGE.equals(key)) {
            android.graphics.drawable.Drawable globe = androidx.core.content.ContextCompat.getDrawable(this, R.drawable.ic_globe);
            if (globe != null) {
                globe = androidx.core.graphics.drawable.DrawableCompat.wrap(globe).mutate();
                androidx.core.graphics.drawable.DrawableCompat.setTint(globe, C_ACT);
                globe.setBounds(0, 0, dp(16), dp(16));
                t.setCompoundDrawables(null, null, globe, null);
                t.setCompoundDrawablePadding(dp(6));
            }
        }
        return t;
    }

    private TextView infoText(String key) {
        TextView t = new TextView(this);
        t.setText(LanguageManager.get(key));
        t.setTag(key);
        t.setTextColor(C_TEXT);
        t.setTextSize(13);
        t.setPadding(dp(16), 0, dp(16), dp(8));
        t.setAlpha(0.7f);
        return t;
    }

    private void updateDialogStrings(ViewGroup root) {
        if (root == null) return;
        for (int i = 0; i < root.getChildCount(); i++) {
            View v = root.getChildAt(i);
            if (v instanceof TextView) {
                Object tag = v.getTag();
                if (tag instanceof String && !((String) tag).isEmpty() && !((String) tag).contains("_SPINNER")) {
                    ((TextView) v).setText(LanguageManager.get((String) tag));
                }
            }
            if (v instanceof Spinner) {
                updateSpinnerStrings((Spinner) v);
            }
            if (v instanceof ViewGroup) {
                updateDialogStrings((ViewGroup) v);
            }
        }

        // Update dialog title and buttons
        if (settingsDialog != null) {
            settingsDialog.setTitle(LanguageManager.get(SETTINGS_TITLE));
            Button btnSave = settingsDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            if (btnSave != null) btnSave.setText(LanguageManager.get(SAVE));
            Button btnReset = settingsDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            if (btnReset != null) btnReset.setText(LanguageManager.get(RESET_DEFAULTS));
        }
    }

    private void updateSpinnerStrings(Spinner s) {
        Object tag = s.getTag();
        if (!(tag instanceof String)) return;
        String t = (String) tag;
        int pos = s.getSelectedItemPosition();
        Context ctx = s.getContext();
        
        if ("MODE_SPINNER".equals(t)) {
            String[] modes = {
                LanguageManager.get(MODE_STRAIGHT),
                LanguageManager.get(MODE_IAMBIC_A),
                LanguageManager.get(MODE_IAMBIC_B),
                LanguageManager.get(MODE_ULTIMATIC),
                LanguageManager.get(MODE_BUG),
                LanguageManager.get(MODE_COOTIE)
            };
            s.setAdapter(themedAdapter(ctx, modes));
            s.setSelection(pos);
        } else if ("THEME_SPINNER".equals(t)) {
            String[] themesDisp = {
                LanguageManager.get(SYSTEM_SETTING),
                LanguageManager.get(DARK_THEME),
                LanguageManager.get(LIGHT_THEME)
            };
            s.setAdapter(themedAdapter(ctx, themesDisp));
            s.setSelection(pos);
        } else if ("LANG_SPINNER".equals(t)) {
            if (settingsLangKeys != null) {
                String[] langNames = new String[settingsLangKeys.length];
                langNames[0] = LanguageManager.get(SYSTEM_SETTING);
                langNames[1] = LanguageManager.getAvailableLanguages().get("en");
                for (int i = 2; i < settingsLangKeys.length; i++) {
                    langNames[i] = LanguageManager.getAvailableLanguages().get(settingsLangKeys[i]);
                }
                s.setAdapter(themedAdapter(ctx, langNames));
                s.setSelection(pos);
            }
        } else if ("COLOR_SPINNER".equals(t)) {
            String[] currentColors = getAvailableColors();
            ArrayList<String> currentColorsDisp = new ArrayList<>();
            for (String color : currentColors) currentColorsDisp.add(getLocalizedColorName(color));
            s.setAdapter(themedAdapterStr(ctx, currentColorsDisp));
            s.setSelection(pos);
        }
    }

    private interface ValueSetter {
        void set(float value);
    }

    private void setupClickableLabel(TextView tv, float min, float max, boolean isFloat, ValueSetter setter) {
        tv.setOnClickListener(v -> {
            if (v.getAlpha() < 1.0f) return;
            AlertDialog.Builder builder = new AlertDialog.Builder(this, getDialogTheme());
            String title = "Enter value";
            if (isFloat) title += String.format(" (%.1f - %.1f)", min, max);
            else title += String.format(" (%d - %d)", (int)min, (int)max);
            builder.setTitle(title);

            final android.widget.EditText input = new android.widget.EditText(this);
            input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER | (isFloat ? android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL : 0) | (min < 0 ? android.text.InputType.TYPE_NUMBER_FLAG_SIGNED : 0));
            input.setTextColor(C_TEXT);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                input.setBackgroundTintList(android.content.res.ColorStateList.valueOf(C_ACT));
            }
            
            LinearLayout container = new LinearLayout(this);
            container.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            lp.setMargins(dp(20), dp(10), dp(20), dp(10));
            container.addView(input, lp);
            builder.setView(container);

            builder.setPositiveButton("OK", (dialog, which) -> {
                try {
                    float val = Float.parseFloat(input.getText().toString());
                    if (val >= min && val <= max) {
                        setter.set(val);
                        settings.save(this);
                        syncSettingsDialog();
                    } else {
                        Toast.makeText(this, "Value out of range", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {}
            });
            builder.setNegativeButton("Cancel", null);
            AlertDialog d = builder.create();
            d.show();
            if (d.getWindow() != null) {
                d.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(C_BG));
            }
        });
    }

    private LinearLayout hRow() {
        LinearLayout r = new LinearLayout(this);
        r.setOrientation(LinearLayout.HORIZONTAL);
        r.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, dp(8));
        r.setLayoutParams(lp);
        return r;
    }

    private int dp(int v) {
        return (int) (v * getResources().getDisplayMetrics().density);
    }

    // ============================================================
    // Lifecycle
    // ============================================================

    // ============================================================
    // Orientation
    // ============================================================

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        applyOrientation();
        if ("system".equals(settings.appTheme))
            applyTheme();
    }

    private void setTwoLineButtonText(Button btn, String line1, String line2) {
        if (btn == null) return;
        String fullText = line1 + "\n" + line2;
        android.text.SpannableString ss = new android.text.SpannableString(fullText);
        ss.setSpan(new android.text.style.RelativeSizeSpan(0.65f), line1.length(), fullText.length(), android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        btn.setText(ss);
    }

    private void applyOrientation() {
        if (middleLayout == null)
            return;

        middleLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lpOutput = (LinearLayout.LayoutParams) scrollOutput.getLayoutParams();
        LinearLayout.LayoutParams lpTable = (LinearLayout.LayoutParams) scrollTable.getLayoutParams();

        lpOutput.width = LinearLayout.LayoutParams.MATCH_PARENT;
        lpOutput.height = 0;
        lpTable.width = LinearLayout.LayoutParams.MATCH_PARENT;
        lpTable.height = 0;

        float ratio = settings.tableRatio / 100.0f;
        lpOutput.weight = settings.showTable ? (1.0f - ratio) : 1.0f;
        lpTable.weight = settings.showTable ? ratio : 0.0f;

        scrollOutput.setLayoutParams(lpOutput);
        scrollTable.setLayoutParams(lpTable);

        LinearLayout gameTxLayout = findViewById(R.id.game_tx_layout);
        if (gameTxLayout != null) {
            gameTxLayout.setOrientation(LinearLayout.VERTICAL);
            View mainDivider = findViewById(R.id.game_divider_main);
            if (mainDivider != null) {
                LinearLayout.LayoutParams divLp = (LinearLayout.LayoutParams) mainDivider.getLayoutParams();
                divLp.width = LinearLayout.LayoutParams.MATCH_PARENT;
                divLp.height = dp(2);
                mainDivider.setLayoutParams(divLp);
            }
            View box1 = findViewById(R.id.game_box_1);
            View box2 = findViewById(R.id.game_box_2);
            if (box1 != null && box2 != null) {
                LinearLayout.LayoutParams b1lp = (LinearLayout.LayoutParams) box1.getLayoutParams();
                LinearLayout.LayoutParams b2lp = (LinearLayout.LayoutParams) box2.getLayoutParams();
                b1lp.width = LinearLayout.LayoutParams.MATCH_PARENT; b1lp.height = 0;
                b2lp.width = LinearLayout.LayoutParams.MATCH_PARENT; b2lp.height = 0;
                box1.setLayoutParams(b1lp);
                box2.setLayoutParams(b2lp);
            }
        }
        
        LinearLayout gameMenuBtnsContainer = findViewById(R.id.game_menu_buttons_container);
        if (gameMenuBtnsContainer != null) {
            int pad = dp(32);
            gameMenuBtnsContainer.setPadding(pad, pad, pad, pad);
        }
        
        View rxTextDisplay = findViewById(R.id.game_rx_text_container);
        if (rxTextDisplay != null) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) rxTextDisplay.getLayoutParams();
            lp.bottomMargin = dp(32);
            rxTextDisplay.setLayoutParams(lp);
        }

        View rxBtnAction = findViewById(R.id.game_rx_btn_action);
        if (rxBtnAction != null) {
            int vPad = dp(24);
            rxBtnAction.setPadding(rxBtnAction.getPaddingLeft(), vPad, rxBtnAction.getPaddingRight(), vPad);
        }
        int paddleHeight = dp(124);
        float paddleTextSize = 72f;

        View[] paddleContainers = new View[] {
            findViewById(R.id.paddle_container),
            findViewById(R.id.game_paddle_container),
            findViewById(R.id.game_menu_paddle_container)
        };
        for (View pc : paddleContainers) {
            if (pc != null) {
                android.view.ViewGroup.LayoutParams lp = pc.getLayoutParams();
                if (lp.height != paddleHeight) {
                    lp.height = paddleHeight;
                    pc.setLayoutParams(lp);
                }
            }
        }
        
        TextView[] paddleTexts = new TextView[] {
            findViewById(R.id.paddle_left), findViewById(R.id.paddle_right),
            findViewById(R.id.game_paddle_left), findViewById(R.id.game_paddle_right),
            findViewById(R.id.game_menu_paddle_left), findViewById(R.id.game_menu_paddle_right)
        };
        for (TextView pt : paddleTexts) {
            if (pt != null) {
                pt.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, paddleTextSize);
            }
        }

        paddleContainer.setVisibility(settings.showPaddles ? View.VISIBLE : View.GONE);
        if (gameController != null) {
            gameController.applySettings(settings.fontSize, C_TEXT, settings.showPaddles);
        }
        if (settings.showTable)
            buildMorseTable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAudioEngine();
        applyKeepScreenOn();
        if (gameController != null) {
            gameController.onResume();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            initAudioEngine();
        }
    }

    private void initAudioEngine() {
        if (toneEngine != null) {
            toneEngine.setToneType(settings.toneType);
            toneEngine.setFrequency(settings.tone);
            toneEngine.setVolume(settings.vol);
            toneEngine.setBufferMs(settings.bufferMs);
            toneEngine.setEnvelopeMs(settings.envelopeMs);
            toneEngine.setChunkMs(settings.chunkMs);
            toneEngine.setKeepAlive(settings.keepAlive);
            toneEngine.setWhiteNoise(settings.whiteNoise);
            toneEngine.init();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (gameController != null) {
            gameController.onPause();
        }
        if (keyer != null)
            keyer.cancelAll();
        keyer.handlePaddlePress("left", false);
        keyer.handlePaddlePress("right", false);
        updatePaddleVisual("left", false);
        updatePaddleVisual("right", false);
        touchMap.clear();
        if (toneEngine != null)
            toneEngine.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toneEngine != null)
            toneEngine.release();
    }

    @Override
    public void onBackPressed() {
        if (gameController != null && gameController.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
