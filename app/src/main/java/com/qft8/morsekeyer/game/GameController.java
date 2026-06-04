package com.qft8.morsekeyer.game;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qft8.morsekeyer.R;
import com.qft8.morsekeyer.MainActivity;
import com.qft8.morsekeyer.MorseKeyer;
import com.qft8.morsekeyer.lang.LanguageManager;
import com.qft8.morsekeyer.lang.MorseLanguage;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Activity activity;
    private View contentLayout;

    private FrameLayout gameLayout;
    private Button btnGame;
    private TextView gameTextInput;
    private FrameLayout gameCanvas;
    private View gameInputBorderTop, gameInputBorderBottom;
    private View gameDivider1, gameDividerMain, gameDivider3;
    private LinearLayout gamePaddleContainer;
    private TextView gamePaddleLeft, gamePaddleRight;
    private View gamePaddleDivider;

    private LinearLayout gameTxLayout;
    private LinearLayout gameRxLayout;
    private Button gameRxBtnAction;
    private TextView gameRxTextDisplay;
    private TextView gameRxTextDummy;
    private TextView gameRxTextCheat;
    private LinearLayout gameRxKeyboard;
    private List<View> gameKbButtons = new ArrayList<>();

    private LinearLayout gameMenuLayout;
    private Button btnTxPractice, btnTxContest, btnRxPractice, btnRxContest;
    private LinearLayout gameMenuPaddleContainer;
    private TextView gameMenuPaddleLeft, gameMenuPaddleRight;
    private View gameMenuPaddleDivider;

    private FrameLayout gameQuitDialogOverlay;
    private LinearLayout gameQuitDialogBox;
    private TextView gameQuitDialogText;
    private Button gameQuitBtnCancel, gameQuitBtnQuit;

    private boolean gameActive = false;
    private int gameTimeLimit = 0;
    private boolean rxGreenDelayActive = false;
    private boolean rxErrorState = false;
    private boolean[] rxFixedMap = new boolean[50];
    private Runnable rxGreenDelayRunnable = null;
    private Runnable delRepeatRunnable = null;
    private int gameTimeElapsed = 0;
    private int gameScore = 0;
    private int gameWordsSolved = 0;
    private int gameRecord = 0;
    private SummaryView currentSummaryView;
    private android.view.View currentShareView;
    private boolean isDarkTheme = true;
    private boolean gameStarted = false;

    private boolean isRxMode = false;
    private String currentRxWord = "";
    private String currentCustomInput = "";
    private MorseKeyer morseKeyer;

    private Handler gameHandler = new Handler(Looper.getMainLooper());
    private Runnable gameRunnable;
    private TextView[] gameCallsigns = new TextView[4];
    private String[] gameCallsignTexts = new String[4];
    private TextView gameTimeLabel, gameTimeVal, gameScoreLabel, gameScoreVal;

    private View.OnTouchListener leftPaddleListener;
    private View.OnTouchListener rightPaddleListener;

    public GameController(Activity activity, View contentLayout) {
        this.activity = activity;
        this.contentLayout = contentLayout;

        gameLayout = activity.findViewById(R.id.game_layout);
        btnGame = activity.findViewById(R.id.btn_game);
        gameTextInput = activity.findViewById(R.id.game_text_input);
        gamePaddleContainer = activity.findViewById(R.id.game_paddle_container);
        gamePaddleLeft = activity.findViewById(R.id.game_paddle_left);
        gamePaddleRight = activity.findViewById(R.id.game_paddle_right);
        gamePaddleDivider = activity.findViewById(R.id.game_paddle_divider);
        gameCanvas = activity.findViewById(R.id.game_canvas);
        gameInputBorderTop = activity.findViewById(R.id.game_input_border_top);
        gameInputBorderBottom = activity.findViewById(R.id.game_input_border_bottom);
        gameDivider1 = activity.findViewById(R.id.game_divider_1);
        gameDividerMain = activity.findViewById(R.id.game_divider_main);
        gameDivider3 = activity.findViewById(R.id.game_divider_3);

        gameTxLayout = activity.findViewById(R.id.game_tx_layout);
        gameRxLayout = activity.findViewById(R.id.game_rx_layout);
        gameRxBtnAction = activity.findViewById(R.id.game_rx_btn_action);
        gameRxTextDisplay = activity.findViewById(R.id.game_rx_text_display);
        gameRxTextDummy = activity.findViewById(R.id.game_rx_text_dummy);
        gameRxTextCheat = activity.findViewById(R.id.game_rx_text_cheat);
        gameRxKeyboard = activity.findViewById(R.id.game_rx_keyboard);

        gameMenuLayout = activity.findViewById(R.id.game_menu_layout);
        btnTxPractice = activity.findViewById(R.id.btn_tx_practice);
        btnTxContest = activity.findViewById(R.id.btn_tx_contest);
        btnRxPractice = activity.findViewById(R.id.btn_rx_practice);
        btnRxContest = activity.findViewById(R.id.btn_rx_contest);
        gameMenuPaddleContainer = activity.findViewById(R.id.game_menu_paddle_container);
        gameMenuPaddleLeft = activity.findViewById(R.id.game_menu_paddle_left);
        gameMenuPaddleRight = activity.findViewById(R.id.game_menu_paddle_right);
        gameMenuPaddleDivider = activity.findViewById(R.id.game_menu_paddle_divider);

        gameQuitDialogOverlay = activity.findViewById(R.id.game_quit_dialog_overlay);
        gameQuitDialogBox = activity.findViewById(R.id.game_quit_dialog_box);
        gameQuitDialogText = activity.findViewById(R.id.game_quit_dialog_text);
        gameQuitBtnCancel = activity.findViewById(R.id.game_quit_btn_cancel);
        gameQuitBtnQuit = activity.findViewById(R.id.game_quit_btn_quit);

        gameTimeLabel = activity.findViewById(R.id.game_time_label);
        gameTimeVal = activity.findViewById(R.id.game_time_val);
        gameScoreLabel = activity.findViewById(R.id.game_score_label);
        gameScoreVal = activity.findViewById(R.id.game_score_val);

        gameCallsigns[0] = activity.findViewById(R.id.game_callsign_1);
        gameCallsigns[1] = activity.findViewById(R.id.game_callsign_2);
        gameCallsigns[2] = activity.findViewById(R.id.game_callsign_3);
        gameCallsigns[3] = activity.findViewById(R.id.game_callsign_4);

        if (com.qft8.morsekeyer.BuildConfig.CHEAT_MODE) {
            for (int i = 0; i < 4; i++) {
                final int idx = i;
                gameCallsigns[i].setOnClickListener(v -> {
                    if (gameActive && gameCallsignTexts[idx] != null) {
                        String current = gameTextInput.getText().toString();
                        gameTextInput.setText(current + " " + gameCallsignTexts[idx] + " ");
                        checkGameMatches();
                    }
                });
            }

            gameRxTextDisplay.setBackgroundColor(0x55FF0000);
            View.OnClickListener rxCheatListener = v -> {
                if (gameActive && isRxMode && gameStarted) {
                    currentCustomInput = currentRxWord;
                    updateRxTextDisplay(false, false);
                    checkRxMatchCustom();
                }
            };
            gameRxTextDisplay.setOnClickListener(rxCheatListener);
            if (gameRxTextCheat != null) {
                gameRxTextCheat.setOnClickListener(rxCheatListener);
            }
        }

        gameRunnable = new Runnable() {
            private int ticks = 0;

            @Override
            public void run() {
                if (!gameActive)
                    return;
                ticks++;
                if (!gameStarted) {
                    updateGameStats(ticks % 2 == 0);
                } else {
                    if (ticks % 2 == 0) {
                        gameTimeElapsed++;
                        updateGameStats();
                        if (gameTimeLimit > 0 && gameTimeElapsed >= gameTimeLimit) {
                            if (isRxMode) {
                                stopGame();
                                android.text.SpannableStringBuilder builder = new android.text.SpannableStringBuilder(
                                        currentRxWord);
                                builder.setSpan(new android.text.style.ForegroundColorSpan(0xFFFF0000), 0,
                                        builder.length(), android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                gameRxTextDisplay.setText(builder);
                                gameRxBtnAction.setText(LanguageManager.get(MorseLanguage.CONTINUE));
                                setRxActionBtnEnabled(true);
                            } else {
                                endGame();
                            }
                            return;
                        }
                    }
                }
                gameHandler.postDelayed(this, 500);
            }
        };

        btnGame.setOnClickListener(v -> {
            contentLayout.setVisibility(View.GONE);
            gameMenuLayout.setVisibility(View.VISIBLE);
            updateLanguage();
        });

        activity.findViewById(R.id.game_menu_btn_back).setOnClickListener(v -> {
            gameMenuLayout.setVisibility(View.GONE);
            contentLayout.setVisibility(View.VISIBLE);
        });

        TextView gameMenuTitle = activity.findViewById(R.id.game_menu_title);
        gameMenuTitle.setText(LanguageManager.get(MorseLanguage.GAMES));

        btnTxPractice.setOnClickListener(v -> {
            gameTimeLimit = 0;
            isRxMode = false;
            gameMenuLayout.setVisibility(View.GONE);
            gameLayout.setVisibility(View.VISIBLE);
            startGame();
        });
        btnTxContest.setOnClickListener(v -> {
            gameTimeLimit = 180;
            isRxMode = false;
            gameMenuLayout.setVisibility(View.GONE);
            gameLayout.setVisibility(View.VISIBLE);
            startGame();
        });
        btnRxPractice.setOnClickListener(v -> {
            gameTimeLimit = 0;
            isRxMode = true;
            gameMenuLayout.setVisibility(View.GONE);
            gameLayout.setVisibility(View.VISIBLE);
            startGame();
        });
        btnRxContest.setOnClickListener(v -> {
            gameTimeLimit = 180;
            isRxMode = true;
            gameMenuLayout.setVisibility(View.GONE);
            gameLayout.setVisibility(View.VISIBLE);
            startGame();
        });

        setupRxListeners();

        activity.findViewById(R.id.game_btn_back).setOnClickListener(v -> {
            showQuitDialog();
        });

        setupCustomKeyboard();
    }

    public void setupCustomKeyboard() {
        gameKbButtons.clear();
        if (gameRxKeyboard != null) {
            gameRxKeyboard.removeAllViews();

            android.content.SharedPreferences prefs = activity.getSharedPreferences("morseKeyerSettings",
                    android.content.Context.MODE_PRIVATE);
            String kbType = prefs.getString("keyboardType", "QWERTY");
            String[][] layoutRows;
            float[][] weightRows;

            if ("AZERTY".equals(kbType)) {
                layoutRows = new String[][] {
                        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" },
                        { "A", "Z", "E", "R", "T", "Y", "U", "I", "O", "P" },
                        { "Q", "S", "D", "F", "G", "H", "J", "K", "L", "M" },
                        { "?", "W", "X", "C", "V", "B", "N", "<1.0>", "DEL" },
                        { "CLEAR", "SLASH", "SPACE", "ENTER" }
                };
                weightRows = new float[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1.5f, 1, 1, 1, 1, 1, 1, 1.0f, 1.5f },
                        { 1.5f, 1, 5, 2.5f }
                };
            } else if ("QWERTZ".equals(kbType)) {
                layoutRows = new String[][] {
                        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" },
                        { "Q", "W", "E", "R", "T", "Z", "U", "I", "O", "P" },
                        { "<0.5>", "A", "S", "D", "F", "G", "H", "J", "K", "L", "<0.5>" },
                        { "?", "Y", "X", "C", "V", "B", "N", "M", "DEL" },
                        { "CLEAR", "SLASH", "SPACE", "ENTER" }
                };
                weightRows = new float[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 0.5f, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5f },
                        { 1.5f, 1, 1, 1, 1, 1, 1, 1, 1.5f },
                        { 1.5f, 1, 5, 2.5f }
                };
            } else { // QWERTY
                layoutRows = new String[][] {
                        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" },
                        { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" },
                        { "<0.5>", "A", "S", "D", "F", "G", "H", "J", "K", "L", "<0.5>" },
                        { "?", "Z", "X", "C", "V", "B", "N", "M", "DEL" },
                        { "CLEAR", "SLASH", "SPACE", "ENTER" }
                };
                weightRows = new float[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 0.5f, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5f },
                        { 1.5f, 1, 1, 1, 1, 1, 1, 1, 1.5f },
                        { 1.5f, 1, 5, 2.5f }
                };
            }

            float scale = activity.getResources().getDisplayMetrics().density;
            int margin = (int) (1.5f * scale + 0.5f);

            for (int r = 0; r < layoutRows.length; r++) {
                LinearLayout row = new LinearLayout(activity);
                row.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams rowLp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.0f);
                row.setLayoutParams(rowLp);

                for (int c = 0; c < layoutRows[r].length; c++) {
                    String key = layoutRows[r][c];
                    float weight = weightRows[r][c];

                    if (key.startsWith("<") && key.endsWith(">")) {
                        android.widget.Space space = new android.widget.Space(activity);
                        LinearLayout.LayoutParams spaceLp = new LinearLayout.LayoutParams(0,
                                LinearLayout.LayoutParams.MATCH_PARENT, weight);
                        space.setLayoutParams(spaceLp);
                        row.addView(space);
                    } else {
                        View btn;
                        int initBg = isDarkTheme ? 0xFF555555 : 0xFFFFFFFF;
                        int initFg = isDarkTheme ? 0xFFFFFFFF : 0xFF000000;
                        if ("ENTER".equals(key)) {
                            initBg = 0xFF4CAF50;
                            initFg = 0xFFFFFFFF;
                        } else if ("CLEAR".equals(key)) {
                            initBg = 0xFFF44336;
                            initFg = 0xFFFFFFFF;
                        }
                        if ("DEL".equals(key) || "ENTER".equals(key) || "CLEAR".equals(key)) {
                            ImageButton ib = new ImageButton(activity);
                            ib.setImageResource("DEL".equals(key) ? R.drawable.ic_backspace : ("CLEAR".equals(key) ? R.drawable.ic_clear : R.drawable.ic_check));
                            ib.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                            ib.setPadding((int) (12 * scale), (int) (12 * scale), (int) (12 * scale),
                                    (int) (12 * scale));
                            ib.setBackgroundTintList(android.content.res.ColorStateList.valueOf(initBg));
                            ib.setColorFilter(initFg);
                            btn = ib;

                        } else {
                            Button b = new Button(activity);
                            b.setText("SLASH".equals(key) ? "/" : ("SPACE".equals(key) ? "" : key));
                            b.setTextColor(initFg);
                            b.setPadding(0, 0, 0, 0);
                            b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(initBg));
                            b.setAllCaps(false); // keep it looking consistent
                            androidx.core.widget.TextViewCompat.setAutoSizeTextTypeWithDefaults(
                                    b, androidx.core.widget.TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
                            btn = b;

                        }

                        LinearLayout.LayoutParams btnLp = new LinearLayout.LayoutParams(0,
                                LinearLayout.LayoutParams.MATCH_PARENT, weight);
                        btnLp.setMargins(margin, margin, margin, margin);
                        btn.setLayoutParams(btnLp);

                        btn.setTag(key);
                        gameKbButtons.add(btn);
                        row.addView(btn);

                        btn.setOnTouchListener((v, event) -> {
                            int action = event.getAction();
                            int activeColor = isDarkTheme ? 0xFF007ACC : 0xFFFF0000;
                            if (action == android.view.MotionEvent.ACTION_DOWN) {
                                btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(activeColor));
                                if (btn instanceof Button) {
                                    ((Button) btn).setTextColor(0xFFFFFFFF);
                                } else if (btn instanceof ImageButton) {
                                    ((ImageButton) btn).setColorFilter(0xFFFFFFFF);
                                }
                                if ("DEL".equals(key)) {
                                    v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                                    onCustomKey(key);
                                    if (delRepeatRunnable != null) {
                                        gameHandler.removeCallbacks(delRepeatRunnable);
                                    }
                                    delRepeatRunnable = new Runnable() {
                                        long nextTime = 0;

                                        @Override
                                        public void run() {
                                            v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                                            onCustomKey(key);
                                            long now = android.os.SystemClock.uptimeMillis();
                                            if (nextTime == 0 || nextTime < now) {
                                                nextTime = now + 100;
                                            } else {
                                                nextTime += 100;
                                            }
                                            gameHandler.postAtTime(this, nextTime);
                                        }
                                    };
                                    gameHandler.postDelayed(delRepeatRunnable, 300);
                                }
                            } else if (action == android.view.MotionEvent.ACTION_UP
                                    || action == android.view.MotionEvent.ACTION_CANCEL) {
                                if ("DEL".equals(key) && delRepeatRunnable != null) {
                                    gameHandler.removeCallbacks(delRepeatRunnable);
                                    delRepeatRunnable = null;
                                }
                                if (action == android.view.MotionEvent.ACTION_UP) {
                                    if (!"DEL".equals(key)) {
                                        v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                                        onCustomKey(key);
                                    }
                                }
                                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                                    int kbBtnBg = isDarkTheme ? 0xFF555555 : 0xFFFFFFFF;
                                    int kbBtnText = isDarkTheme ? 0xFFFFFFFF : 0xFF000000;
                                    if ("ENTER".equals(key)) {
                                        kbBtnBg = 0xFF4CAF50;
                                        kbBtnText = 0xFFFFFFFF;
                                    } else if ("CLEAR".equals(key)) {
                                        kbBtnBg = 0xFFF44336;
                                        kbBtnText = 0xFFFFFFFF;
                                    }
                                    btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(kbBtnBg));
                                    if (btn instanceof Button) {
                                        ((Button) btn).setTextColor(kbBtnText);
                                    } else if (btn instanceof ImageButton) {
                                        ((ImageButton) btn).setColorFilter(kbBtnText);
                                    }
                                }, 80);
                            }
                            return true;
                        });
                    }
                }
                gameRxKeyboard.addView(row);
            }
        }

        if (gameRxKeyboard != null) {
            gameRxKeyboard.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                        int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    View parent = (View) v.getParent();
                    if (parent == null || parent.getWidth() == 0 || parent.getHeight() == 0)
                        return;
                    int parentWidth = parent.getWidth();
                    int parentHeight = parent.getHeight();
                    int maxTotalHeight = (int) (parentHeight * 0.5);
                    int maxRowHeight = maxTotalHeight / 5;

                    int availableWidth = parentWidth - gameRxKeyboard.getPaddingLeft()
                            - gameRxKeyboard.getPaddingRight();
                    int btnWidth = availableWidth / 10;
                    int rowHeight = (int) (btnWidth * 1.45);

                    int targetKbWidth = android.view.ViewGroup.LayoutParams.MATCH_PARENT;

                    if (rowHeight > maxRowHeight) {
                        rowHeight = maxRowHeight;
                    }

                    int padW = btnWidth / 4;
                    int padH = rowHeight / 4;
                    boolean changed = false;

                    int pad4dp = (int) (4 * v.getResources().getDisplayMetrics().density);
                    int kbPadBottom = pad4dp;
                    int kbPadSides = pad4dp;
                    if (gameRxKeyboard.getPaddingBottom() != kbPadBottom
                            || gameRxKeyboard.getPaddingLeft() != kbPadSides) {
                        gameRxKeyboard.setPadding(kbPadSides, pad4dp, kbPadSides, kbPadBottom);
                    }

                    for (int i = 0; i < gameRxKeyboard.getChildCount(); i++) {
                        View row = gameRxKeyboard.getChildAt(i);
                        if (row instanceof LinearLayout) {
                            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) row.getLayoutParams();
                            if (params.height != rowHeight) {
                                params.height = rowHeight;
                                params.weight = 0;
                                row.setLayoutParams(params);
                                changed = true;
                            }
                        }
                    }

                    float density = v.getResources().getDisplayMetrics().density;
                    int vMargin = 1;
                    int hMargin = 1;
                    for (View btn : gameKbButtons) {
                        if (btn.getPaddingLeft() != padW || btn.getPaddingTop() != padH) {
                            btn.setPadding(padW, padH, padW, padH);
                        }

                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) btn.getLayoutParams();
                        if (lp.topMargin != vMargin || lp.bottomMargin != vMargin || lp.leftMargin != hMargin) {
                            lp.setMargins(hMargin, vMargin, hMargin, vMargin);
                            btn.setLayoutParams(lp);
                        }
                    }

                    LinearLayout.LayoutParams kbParams = (LinearLayout.LayoutParams) gameRxKeyboard.getLayoutParams();
                    if (kbParams.height != android.view.ViewGroup.LayoutParams.WRAP_CONTENT || kbParams.weight != 0
                            || kbParams.width != targetKbWidth) {
                        kbParams.height = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
                        kbParams.width = targetKbWidth;
                        kbParams.weight = 0;
                        kbParams.gravity = android.view.Gravity.CENTER_HORIZONTAL;
                        gameRxKeyboard.setLayoutParams(kbParams);
                    }
                }
            });
        }
    }

    private void cancelRxGreenDelay() {
        if (rxGreenDelayActive) {
            rxGreenDelayActive = false;
            if (rxGreenDelayRunnable != null) {
                gameHandler.removeCallbacks(rxGreenDelayRunnable);
                rxGreenDelayRunnable = null;
            }
        }
    }

    private void updateRxTextDisplay(boolean showErrors, boolean showCorrectGreen) {
        if (com.qft8.morsekeyer.BuildConfig.CHEAT_MODE && gameRxTextCheat != null) {
            gameRxTextCheat.setVisibility(View.VISIBLE);
            gameRxTextCheat.setText(currentRxWord);
        }

        if (currentRxWord == null || currentRxWord.isEmpty()) {
            gameRxTextDisplay.setText("");
            if (gameRxTextCheat != null) gameRxTextCheat.setText("");
            return;
        }

        android.text.SpannableStringBuilder builder = new android.text.SpannableStringBuilder();
        int inputLen = currentCustomInput.length();
        int targetLen = currentRxWord.length();

        for (int i = 0; i < Math.max(inputLen, targetLen); i++) {
            if (i > 0) {
                int spaceStart = builder.length();
                builder.append(" ");
                builder.setSpan(new android.text.style.ScaleXSpan(0.7f), spaceStart, builder.length(), 33);
            }
            char c = i < inputLen ? currentCustomInput.charAt(i) : '_';
            int start = builder.length();
            builder.append(c);
            
            int color = isDarkTheme ? 0xFFFFFFFF : 0xFF000000;
            
            if (showCorrectGreen) {
                color = 0xFF00FF00;
            } else if (showErrors) {
                if (i < targetLen && i < 50 && rxFixedMap[i]) {
                    // It is fixed! Keep it white!
                } else {
                    color = 0xFFFF0000;
                }
            }
            
            builder.setSpan(new android.text.style.ForegroundColorSpan(color), start, builder.length(), 33);
        }
        gameRxTextDisplay.setText(builder);
    }

    private void clearRedOnes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentRxWord.length(); i++) {
            if (i < currentCustomInput.length() && i < 50 && rxFixedMap[i] && currentCustomInput.charAt(i) == currentRxWord.charAt(i)) {
                sb.append(currentCustomInput.charAt(i));
            } else {
                sb.append('_');
            }
        }
        currentCustomInput = sb.toString();
        rxErrorState = false;
    }

    private void onCustomKey(String key) {
        if (!gameActive || !isRxMode || !gameStarted)
            return;

        if (key.equals("SLASH")) {
            key = "/";
        }

        if (rxGreenDelayActive) {
            cancelRxGreenDelay();
            currentCustomInput = "";
            rxErrorState = false;
            java.util.Arrays.fill(rxFixedMap, false);
            updateRxTextDisplay(false, false);
        }

        if (key.equals("CLEAR")) {
            clearRedOnes();
            while (currentCustomInput.length() > 0 && currentCustomInput.endsWith("_")) {
                currentCustomInput = currentCustomInput.substring(0, currentCustomInput.length() - 1);
            }
            updateRxTextDisplay(false, false);
            return;
        }

        if (key.equals("ENTER") || key.equals("SPACE")) {
            checkRxMatchCustom();
            return;
        }

        if (rxErrorState) {
            clearRedOnes();
        }

        if (key.equals("DEL")) {
            boolean deleted = false;
            for (int i = currentCustomInput.length() - 1; i >= 0; i--) {
                if (currentCustomInput.charAt(i) != '_' && !(i < 50 && rxFixedMap[i])) {
                    currentCustomInput = currentCustomInput.substring(0, i) + "_" + currentCustomInput.substring(i + 1);
                    deleted = true;
                    break;
                }
            }
            if (!deleted) {
                 while (currentCustomInput.length() > 0 && currentCustomInput.endsWith("_")) {
                     currentCustomInput = currentCustomInput.substring(0, currentCustomInput.length() - 1);
                 }
            }
            updateRxTextDisplay(false, false);
            return;
        }

        int firstGap = currentCustomInput.indexOf('_');
        if (firstGap != -1) {
            currentCustomInput = currentCustomInput.substring(0, firstGap) + key + currentCustomInput.substring(firstGap + 1);
        } else {
            if (currentCustomInput.length() < currentRxWord.length() + 5) {
                currentCustomInput += key;
            }
        }

        if (!currentCustomInput.contains("_") && currentCustomInput.length() >= currentRxWord.length()) {
            checkRxMatchCustom();
        } else {
            updateRxTextDisplay(false, false);
        }
    }

    private void setRxActionBtnEnabled(boolean enabled) {
        if (gameRxBtnAction != null) {
            gameRxBtnAction.setEnabled(enabled);
            gameRxBtnAction.setAlpha(enabled ? 1.0f : 0.5f);
        }
    }

    private void setupRxListeners() {
        if (gameRxBtnAction != null) {
            gameRxBtnAction.setOnClickListener(v -> {
                String text = gameRxBtnAction.getText().toString();
                if (text.equals(LanguageManager.get(MorseLanguage.START)) ||
                        text.equals(LanguageManager.get(MorseLanguage.REPEAT))) {

                    cancelRxGreenDelay();
                    gameRxBtnAction.setText(LanguageManager.get(MorseLanguage.REPEAT));
                    setRxActionBtnEnabled(false);

                    if (text.equals(LanguageManager.get(MorseLanguage.START))) {
                        currentCustomInput = "";
                        rxErrorState = false;
                        java.util.Arrays.fill(rxFixedMap, false);
                        updateRxTextDisplay(false, false);

                        gameHandler.postDelayed(() -> {
                            if (gameActive && isRxMode && morseKeyer != null) {
                                gameStarted = true;
                                morseKeyer.playText(currentRxWord, () -> {
                                    gameHandler.post(() -> setRxActionBtnEnabled(true));
                                });
                            }
                        }, 500);
                    } else {
                        if (gameActive && isRxMode && morseKeyer != null) {
                            morseKeyer.playText(currentRxWord, () -> {
                                gameHandler.post(() -> setRxActionBtnEnabled(true));
                            });
                        }
                    }
                } else if (text.equals(LanguageManager.get(MorseLanguage.CONTINUE))) {
                    endGame();
                }
            });
        }
    }

    private void checkRxMatchCustom() {
        if (rxGreenDelayActive)
            return;
        String input = currentCustomInput.trim().toUpperCase();
        
        int limit = currentRxWord.length();
        boolean allCorrect = true;
        for (int i = 0; i < limit; i++) {
            if (i < input.length() && input.charAt(i) == currentRxWord.charAt(i)) {
                if (i < 50) rxFixedMap[i] = true;
            } else {
                allCorrect = false;
            }
        }
        
        if (input.length() > currentRxWord.length()) {
            allCorrect = false;
        }

        if (input.isEmpty()) {
            rxErrorState = true;
            updateRxTextDisplay(true, false);
            return;
        }

        if (allCorrect && !currentCustomInput.contains("_")) {
            updateRxTextDisplay(false, true); // show green
            gameScore += currentRxWord.length();
            gameWordsSolved++;
            updateGameStats();

            currentRxWord = WordGenerator.generateGameWord(gameWordsSolved, null);
            gameRxBtnAction.setText(LanguageManager.get(MorseLanguage.REPEAT));
            if (morseKeyer != null) {
                setRxActionBtnEnabled(false);
                morseKeyer.cancelAll();
                gameHandler.postDelayed(() -> {
                    if (gameActive && isRxMode && morseKeyer != null) {
                        morseKeyer.playText(currentRxWord, () -> {
                            gameHandler.post(() -> setRxActionBtnEnabled(true));
                        });
                    }
                }, 500);
            }

            rxGreenDelayActive = true;
            rxGreenDelayRunnable = () -> {
                if (gameActive && isRxMode && rxGreenDelayActive) {
                    rxGreenDelayActive = false;
                    currentCustomInput = "";
                    rxErrorState = false;
                    java.util.Arrays.fill(rxFixedMap, false);
                    updateRxTextDisplay(false, false);
                }
            };
            gameHandler.postDelayed(rxGreenDelayRunnable, 500);
        } else {
            rxErrorState = true;
            updateRxTextDisplay(true, false);

            gameRxBtnAction.setText(LanguageManager.get(MorseLanguage.REPEAT));
            setRxActionBtnEnabled(true);
        }
    }

    public boolean canHandleBack() {
        if (currentShareView != null)
            return true;
        if (currentSummaryView != null)
            return true;
        if (gameLayout != null && gameLayout.getVisibility() == android.view.View.VISIBLE)
            return true;
        if (gameMenuLayout != null && gameMenuLayout.getVisibility() == android.view.View.VISIBLE)
            return true;
        return false;
    }

    public boolean isRxGameActive() {
        return gameActive && isRxMode;
    }

    public void setMorseKeyer(MorseKeyer keyer) {
        this.morseKeyer = keyer;
    }

    public boolean onBackPressed() {
        if (currentShareView != null) {
            closeShare();
            showSummary();
            return true;
        }
        if (currentSummaryView != null) {
            closeSummary();
            gameLayout.setVisibility(android.view.View.GONE);
            gameMenuLayout.setVisibility(android.view.View.VISIBLE);
            return true;
        }
        if (gameLayout != null && gameLayout.getVisibility() == android.view.View.VISIBLE) {
            if (gameQuitDialogOverlay != null && gameQuitDialogOverlay.getVisibility() == android.view.View.VISIBLE) {
                gameQuitDialogOverlay.setVisibility(android.view.View.GONE);
            } else {
                showQuitDialog();
            }
            return true;
        }
        if (gameMenuLayout != null && gameMenuLayout.getVisibility() == android.view.View.VISIBLE) {
            gameMenuLayout.setVisibility(View.GONE);
            contentLayout.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }

    public void applyTheme(int bgCol, int termCol, int prCol, int barCol, int utlCol, int textCol, boolean dark) {
        this.isDarkTheme = dark;
        if (gameLayout == null)
            return;
        gameLayout.setBackgroundColor(bgCol);
        gameCanvas.setBackgroundColor(termCol);
        if (gameDivider1 != null)
            gameDivider1.setBackgroundColor(prCol);
        if (gameDividerMain != null)
            gameDividerMain.setBackgroundColor(prCol);
        if (gameDivider3 != null)
            gameDivider3.setBackgroundColor(prCol);
        gameTextInput.setBackgroundColor(termCol);
        activity.findViewById(R.id.game_top_bar).setBackgroundColor(barCol);
        int gameBtnCol = isDarkTheme ? 0xFF5A483C : 0xFFE0D4C8;
        btnGame.setBackgroundTintList(android.content.res.ColorStateList.valueOf(gameBtnCol));
        btnGame.setTextColor(textCol);
        android.graphics.drawable.Drawable[] drawables = btnGame.getCompoundDrawablesRelative();
        if (drawables[0] != null) {
            drawables[0].setColorFilter(textCol, android.graphics.PorterDuff.Mode.SRC_IN);
        }

        gamePaddleContainer.setBackgroundColor(barCol);
        gamePaddleLeft.setTextColor(textCol);
        gamePaddleRight.setTextColor(textCol);
        gamePaddleDivider.setBackgroundColor(dark ? 0xFF666666 : 0xFFCCCCCC);

        gameQuitDialogBox.setBackgroundColor(barCol);
        gameQuitDialogText.setTextColor(textCol);
        gameQuitBtnCancel.setTextColor(textCol);
        gameQuitBtnQuit.setTextColor(0xFFFF0000);

        gameTimeLabel.setTextColor(textCol);
        gameTimeVal.setTextColor(textCol);
        gameScoreLabel.setTextColor(textCol);
        gameScoreVal.setTextColor(textCol);
        android.widget.ImageButton gameBtnBack = activity.findViewById(R.id.game_btn_back);
        if (gameBtnBack != null) {
            gameBtnBack.setColorFilter(textCol);
            gameBtnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
        }

        if (gameRxTextDisplay != null) {
            gameRxTextDisplay.setTextColor(textCol);
        }

        if (gameRxKeyboard != null) {
            gameRxKeyboard.setBackgroundColor(dark ? 0xFF333333 : 0xFFDDDDDD);
            int kbBtnBg = dark ? 0xFF555555 : 0xFFFFFFFF;
            int kbBtnText = dark ? 0xFFFFFFFF : 0xFF000000;
            for (View btn : gameKbButtons) {
                int bg = kbBtnBg;
                int text = kbBtnText;
                if ("ENTER".equals(btn.getTag())) {
                    bg = 0xFF4CAF50;
                    text = 0xFFFFFFFF;
                } else if ("CLEAR".equals(btn.getTag())) {
                    bg = 0xFFF44336;
                    text = 0xFFFFFFFF;
                }
                btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(bg));
                if (btn instanceof Button) {
                    ((Button) btn).setTextColor(text);
                } else if (btn instanceof ImageButton) {
                    ((ImageButton) btn).setColorFilter(text);
                }
            }
        }

        if (gameRxBtnAction != null) {
            int actionBtnBg = dark ? 0xFF444444 : 0xFFDDDDDD;
            int actionBtnText = dark ? 0xFFFFFFFF : 0xFF000000;
            gameRxBtnAction.setBackgroundTintList(android.content.res.ColorStateList.valueOf(actionBtnBg));
            gameRxBtnAction.setTextColor(actionBtnText);
        }

        if (gameMenuLayout != null) {
            gameMenuLayout.setBackgroundColor(bgCol);
            activity.findViewById(R.id.game_menu_top_bar).setBackgroundColor(barCol);
            android.widget.ImageButton menuBtnBack = activity.findViewById(R.id.game_menu_btn_back);
            if (menuBtnBack != null) {
                menuBtnBack.setColorFilter(textCol);
                menuBtnBack.setBackgroundTintList(android.content.res.ColorStateList.valueOf(utlCol));
            }
            TextView menuTitle = activity.findViewById(R.id.game_menu_title);
            if (menuTitle != null)
                menuTitle.setTextColor(textCol);

            int menuBtnCol = dark ? 0xFF444444 : 0xFFDDDDDD;
            int menuTextCol = dark ? 0xFFFFFFFF : 0xFF000000;
            if (btnTxPractice != null) {
                btnTxPractice.setBackgroundTintList(android.content.res.ColorStateList.valueOf(menuBtnCol));
                btnTxPractice.setTextColor(menuTextCol);
            }
            if (btnTxContest != null) {
                btnTxContest.setBackgroundTintList(android.content.res.ColorStateList.valueOf(menuBtnCol));
                btnTxContest.setTextColor(menuTextCol);
            }
            if (btnRxPractice != null) {
                btnRxPractice.setBackgroundTintList(android.content.res.ColorStateList.valueOf(menuBtnCol));
                btnRxPractice.setTextColor(menuTextCol);
            }
            if (btnRxContest != null) {
                btnRxContest.setBackgroundTintList(android.content.res.ColorStateList.valueOf(menuBtnCol));
                btnRxContest.setTextColor(menuTextCol);
            }

            if (gameMenuPaddleContainer != null) {
                gameMenuPaddleContainer.setBackgroundColor(barCol);
                if (gameMenuPaddleLeft != null)
                    gameMenuPaddleLeft.setTextColor(textCol);
                if (gameMenuPaddleRight != null)
                    gameMenuPaddleRight.setTextColor(textCol);
                if (gameMenuPaddleDivider != null)
                    gameMenuPaddleDivider.setBackgroundColor(dark ? 0xFF666666 : 0xFFCCCCCC);
            }
        }
    }

    public void applySettings(int fontSize, int color, boolean showPaddles) {
        if (gameLayout == null)
            return;
        androidx.core.widget.TextViewCompat.setAutoSizeTextTypeWithDefaults(gameTextInput,
                androidx.core.widget.TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE);
        gameTextInput.setTextSize(fontSize);
        gameTextInput.setTextColor(color);
        if (gameRxTextDummy != null) {
            gameRxTextDummy.setTextSize(fontSize);
        }
        if (gameRxTextDisplay != null) {
            androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    gameRxTextDisplay, 12, fontSize, 1, android.util.TypedValue.COMPLEX_UNIT_SP);
        }
        if (gameActive && isRxMode) {
            gamePaddleContainer.setVisibility(View.GONE);
        } else {
            gamePaddleContainer.setVisibility(showPaddles ? View.VISIBLE : View.GONE);
        }
    }

    public void updatePaddleText(String leftText, float leftSize, String rightText, float rightSize,
            int rightVisibility, int dividerVisibility) {
        if (gamePaddleLeft != null) {
            gamePaddleLeft.setText(leftText);
            gamePaddleLeft.setTextSize(leftSize);
        }
        if (gamePaddleRight != null) {
            gamePaddleRight.setText(rightText);
            gamePaddleRight.setTextSize(rightSize);
            gamePaddleRight.setVisibility(rightVisibility);
        }
        if (gamePaddleDivider != null) {
            gamePaddleDivider.setVisibility(dividerVisibility);
        }
        if (gameMenuPaddleLeft != null) {
            gameMenuPaddleLeft.setText(leftText);
            gameMenuPaddleLeft.setTextSize(leftSize);
        }
        if (gameMenuPaddleRight != null) {
            gameMenuPaddleRight.setText(rightText);
            gameMenuPaddleRight.setTextSize(rightSize);
            gameMenuPaddleRight.setVisibility(rightVisibility);
        }
        if (gameMenuPaddleDivider != null) {
            gameMenuPaddleDivider.setVisibility(dividerVisibility);
        }
        if (currentSummaryView != null) {
            TextView pL = currentSummaryView.findViewWithTag("summary_paddle_left");
            if (pL != null) {
                pL.setText(leftText);
                pL.setTextSize(leftSize);
            }
            TextView pR = currentSummaryView.findViewWithTag("summary_paddle_right");
            if (pR != null) {
                pR.setText(rightText);
                pR.setTextSize(rightSize);
                pR.setVisibility(rightVisibility);
            }
            View pD = currentSummaryView.findViewWithTag("summary_paddle_divider");
            if (pD != null)
                pD.setVisibility(dividerVisibility);
        }
        if (currentShareView != null) {
            TextView pL = currentShareView.findViewWithTag("share_paddle_left");
            if (pL != null) {
                pL.setText(leftText);
                pL.setTextSize(leftSize);
            }
            TextView pR = currentShareView.findViewWithTag("share_paddle_right");
            if (pR != null) {
                pR.setText(rightText);
                pR.setTextSize(rightSize);
                pR.setVisibility(rightVisibility);
            }
            View pD = currentShareView.findViewWithTag("share_paddle_divider");
            if (pD != null)
                pD.setVisibility(dividerVisibility);
        }
    }

    public void updateVisualSettings(float fontSize, int color, boolean cheatMode) {
        if (gameTextInput != null) {
            androidx.core.widget.TextViewCompat.setAutoSizeTextTypeWithDefaults(gameTextInput,
                    androidx.core.widget.TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE);
            gameTextInput.setTextSize(fontSize);
            gameTextInput.setTextColor(color);
            if (gameInputBorderTop != null)
                gameInputBorderTop.setBackgroundColor(color);
            if (gameInputBorderBottom != null)
                gameInputBorderBottom.setBackgroundColor(color);

            for (int i = 0; i < 4; i++) {
                if (gameCallsigns[i] != null) {
                    gameCallsigns[i].setTextColor(cheatMode ? 0xFFFF0000 : color);
                    androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                            gameCallsigns[i], 12, (int) fontSize, 1, android.util.TypedValue.COMPLEX_UNIT_SP);
                }
            }
        }
        if (gameRxTextDummy != null) {
            gameRxTextDummy.setTextSize(fontSize);
        }
        if (gameRxTextDisplay != null) {
            androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                    gameRxTextDisplay, 12, (int) fontSize, 1, android.util.TypedValue.COMPLEX_UNIT_SP);
        }
    }

    public void updateLanguage() {
        TextView gameMenuTitle = activity.findViewById(R.id.game_menu_title);
        if (gameMenuTitle != null) {
            gameMenuTitle.setText(LanguageManager.get(MorseLanguage.GAMES));
        }
        if (btnGame != null) {
            btnGame.setText(LanguageManager.get(MorseLanguage.GAMES));
        }
        if (btnTxPractice != null) {
            String title = LanguageManager.get(MorseLanguage.TX_PRACTICE);
            String sub = LanguageManager.get(MorseLanguage.INFINITE);
            android.text.SpannableString ss = new android.text.SpannableString(title + "\n" + sub);
            ss.setSpan(new android.text.style.RelativeSizeSpan(0.7f), title.length() + 1, ss.length(),
                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnTxPractice.setText(ss);
        }
        if (btnTxContest != null) {
            String title = LanguageManager.get(MorseLanguage.TX_CONTEST);
            String sub = LanguageManager.get(MorseLanguage.THREE_MINUTES);
            android.text.SpannableString ss = new android.text.SpannableString(title + "\n" + sub);
            ss.setSpan(new android.text.style.RelativeSizeSpan(0.7f), title.length() + 1, ss.length(),
                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnTxContest.setText(ss);
        }
        if (btnRxPractice != null) {
            String title = LanguageManager.get(MorseLanguage.RX_PRACTICE);
            String sub = LanguageManager.get(MorseLanguage.INFINITE);
            android.text.SpannableString ss = new android.text.SpannableString(title + "\n" + sub);
            ss.setSpan(new android.text.style.RelativeSizeSpan(0.7f), title.length() + 1, ss.length(),
                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnRxPractice.setText(ss);
        }
        if (btnRxContest != null) {
            String title = LanguageManager.get(MorseLanguage.RX_CONTEST);
            String sub = LanguageManager.get(MorseLanguage.THREE_MINUTES);
            android.text.SpannableString ss = new android.text.SpannableString(title + "\n" + sub);
            ss.setSpan(new android.text.style.RelativeSizeSpan(0.7f), title.length() + 1, ss.length(),
                    android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            btnRxContest.setText(ss);
        }

        if (gameRxBtnAction != null) {
            android.text.TextPaint paint = gameRxBtnAction.getPaint();
            String s1 = LanguageManager.get(MorseLanguage.START);
            String s2 = LanguageManager.get(MorseLanguage.REPEAT);
            String s3 = LanguageManager.get(MorseLanguage.CONTINUE);
            // Button is set to allCaps by default in Android Material Theme, measure the
            // capitalized strings
            float w1 = paint.measureText(s1.toUpperCase());
            float w2 = paint.measureText(s2.toUpperCase());
            float w3 = paint.measureText(s3.toUpperCase());
            float maxTextW = Math.max(w1, Math.max(w2, w3));

            // 48dp on each side = 96dp total padding
            float density = activity.getResources().getDisplayMetrics().density;
            int padding = (int) (96 * density);
            gameRxBtnAction.setMinimumWidth((int) Math.ceil(maxTextW) + padding);
        }
    }

    public void setPaddleListeners(View.OnTouchListener leftListener, View.OnTouchListener rightListener) {
        this.leftPaddleListener = leftListener;
        this.rightPaddleListener = rightListener;
        if (gamePaddleLeft != null) {
            gamePaddleLeft.setOnTouchListener(leftListener);
        }
        if (gamePaddleRight != null) {
            gamePaddleRight.setOnTouchListener(rightListener);
        }
        if (gameMenuPaddleLeft != null) {
            gameMenuPaddleLeft.setOnTouchListener(leftListener);
        }
        if (gameMenuPaddleRight != null) {
            gameMenuPaddleRight.setOnTouchListener(rightListener);
        }
    }

    public void updatePaddleVisual(String side, boolean pressed, int actCol, int bgCol) {
        if (pressed && gameActive && !gameStarted) {
            gameStarted = true;
            gameTextInput.setGravity(android.view.Gravity.END | android.view.Gravity.CENTER_VERTICAL);
            gameTextInput.setText("");
            updateGameStats();
        }
        if ("left".equals(side)) {
            if (gamePaddleLeft != null)
                gamePaddleLeft.setBackgroundColor(pressed ? actCol : bgCol);
            if (gameMenuPaddleLeft != null)
                gameMenuPaddleLeft.setBackgroundColor(pressed ? actCol : bgCol);
            if (currentSummaryView != null) {
                View p = currentSummaryView.findViewWithTag("summary_paddle_left");
                if (p != null)
                    p.setBackgroundColor(pressed ? actCol : bgCol);
            }
            if (currentShareView != null) {
                View p = currentShareView.findViewWithTag("share_paddle_left");
                if (p != null)
                    p.setBackgroundColor(pressed ? actCol : bgCol);
            }
        } else if ("right".equals(side)) {
            if (gamePaddleRight != null)
                gamePaddleRight.setBackgroundColor(pressed ? actCol : bgCol);
            if (gameMenuPaddleRight != null)
                gameMenuPaddleRight.setBackgroundColor(pressed ? actCol : bgCol);
            if (currentSummaryView != null) {
                View p = currentSummaryView.findViewWithTag("summary_paddle_right");
                if (p != null)
                    p.setBackgroundColor(pressed ? actCol : bgCol);
            }
            if (currentShareView != null) {
                View p = currentShareView.findViewWithTag("share_paddle_right");
                if (p != null)
                    p.setBackgroundColor(pressed ? actCol : bgCol);
            }
        }
    }

    public void onToneStart() {
    }

    public void onToneStop() {
    }

    public void onVisualFlash(boolean flash) {
        if (currentSummaryView != null) {
            android.view.View overlay = currentSummaryView.findViewWithTag("summary_flash_overlay");
            if (overlay != null)
                overlay.setVisibility(flash ? View.VISIBLE : View.GONE);
        }
        if (currentShareView != null) {
            android.view.View overlay = currentShareView.findViewWithTag("share_flash_overlay");
            if (overlay != null)
                overlay.setVisibility(flash ? View.VISIBLE : View.GONE);
        }
    }

    public void onDecode(String text) {
        if (!gameActive)
            return;
        String gCurrent = gameTextInput.getText().toString();
        if (gCurrent.endsWith("​_")) {
            gameTextInput.setText(gCurrent.substring(0, gCurrent.length() - 2) + " ");
        } else if (gCurrent.endsWith("_")) {
            gameTextInput.setText(gCurrent.substring(0, gCurrent.length() - 1) + " ");
        }
        gameTextInput.append(text);
        trimGameText();
        checkGameMatches();
    }

    public void onWordGapPending() {
        if (!gameActive)
            return;
        gameTextInput.append("​_");
        trimGameText();
        checkGameMatches();
    }

    public void onWordGapConfirmed() {
        if (!gameActive)
            return;
        String gCurrent = gameTextInput.getText().toString();
        if (gCurrent.endsWith("​_")) {
            gameTextInput.setText(gCurrent.substring(0, gCurrent.length() - 2) + " ");
        } else if (gCurrent.endsWith("_")) {
            gameTextInput.setText(gCurrent.substring(0, gCurrent.length() - 1) + " ");
        }
        trimGameText();
        checkGameMatches();
    }

    private void trimGameText() {
        if (gameTextInput != null) {
            String text = gameTextInput.getText().toString();
            if (text.length() > 500) {
                gameTextInput.setText(text.substring(text.length() - 200));
            }
        }
    }

    private void checkGameMatches() {
        if (!gameActive)
            return;
        String gCurrent = gameTextInput.getText().toString();
        if (gCurrent.endsWith(" ") || gCurrent.endsWith("_") || gCurrent.endsWith("​_")) {
            String[] words = gCurrent.replace("\u200B_", "").replace("_", "").trim().split("\\s+");
            if (words.length > 0) {
                String lastWord = words[words.length - 1];
                boolean found = false;
                int foundIdx = -1;
                for (int i = 0; i < 4; i++) {
                    if (gameCallsignTexts[i] != null && lastWord.equals(gameCallsignTexts[i])) {
                        gameScore += gameCallsignTexts[i].length();
                        gameWordsSolved++;
                        gameCallsignTexts[i] = null;
                        gameCallsigns[i].setText("");
                        found = true;
                        foundIdx = i;
                        break;
                    }
                }
                if (found) {
                    updateGameStats();
                    int nonNulls = 0;
                    for (int i = 0; i < 4; i++) {
                        if (gameCallsignTexts[i] != null)
                            nonNulls++;
                    }
                    if (nonNulls <= 2) {
                        int r = -1;
                        while (r == -1) {
                            int candidate = (int) (Math.random() * 4);
                            if (gameCallsignTexts[candidate] == null && candidate != foundIdx) {
                                r = candidate;
                                gameCallsignTexts[r] = WordGenerator.generateGameWord(gameWordsSolved,
                                        gameCallsignTexts);
                                gameCallsigns[r].setText(gameCallsignTexts[r]);
                            }
                        }
                    }
                }
            }
        }
    }

    private void startGame() {
        WordGenerator.reset();
        gameActive = true;
        gameTimeElapsed = 0;
        gameScore = 0;
        gameWordsSolved = 0;
        SharedPreferences prefs = activity.getSharedPreferences("morse_game", Context.MODE_PRIVATE);

        String recordKey = isRxMode ? "record_rx" : "record";
        gameRecord = prefs.getInt(recordKey, 0);

        if (isRxMode) {
            if (morseKeyer != null) {
                morseKeyer.setInputEnabled(false);
            }
            gameTxLayout.setVisibility(View.GONE);
            gameRxLayout.setVisibility(View.VISIBLE);
            gamePaddleContainer.setVisibility(View.GONE);
            gameTextInput.setVisibility(View.GONE);
            gameInputBorderTop.setVisibility(View.GONE);
            gameInputBorderBottom.setVisibility(View.GONE);

            gameRxBtnAction.setText(LanguageManager.get(MorseLanguage.START));
            setRxActionBtnEnabled(true);

            currentCustomInput = "";
            currentRxWord = WordGenerator.generateGameWord(gameWordsSolved, null);
            gameStarted = false;
            rxErrorState = false;
            java.util.Arrays.fill(rxFixedMap, false);
            updateRxTextDisplay(false, false);

            if (gameTimeLimit > 0) {
                String recordStr = "\u00A0" + LanguageManager.get(MorseLanguage.HIGH_SCORE) + ": " + gameRecord
                        + "\u00A0";
                gameRxTextDisplay.setText(recordStr);
                gameRxTextDisplay.setTextColor(isDarkTheme ? 0xFFAAAAAA : 0xFF666666);
            }

        } else {
            gameTxLayout.setVisibility(View.VISIBLE);
            gameRxLayout.setVisibility(View.GONE);
            gamePaddleContainer.setVisibility(View.VISIBLE);
            gameTextInput.setVisibility(View.VISIBLE);
            gameInputBorderTop.setVisibility(View.VISIBLE);
            gameInputBorderBottom.setVisibility(View.VISIBLE);

            if (gameTimeLimit > 0) {
                String recordStr = LanguageManager.get(MorseLanguage.HIGH_SCORE) + ": " + gameRecord;
                gameTextInput.setGravity(android.view.Gravity.CENTER);
                gameTextInput.setText(recordStr);
            } else {
                gameTextInput.setGravity(android.view.Gravity.END | android.view.Gravity.CENTER_VERTICAL);
                gameTextInput.setText("");
            }
            for (int i = 0; i < 4; i++) {
                gameCallsignTexts[i] = WordGenerator.generateGameWord(gameWordsSolved, gameCallsignTexts);
                gameCallsigns[i].setText(gameCallsignTexts[i]);
            }
            gameStarted = false;
        }

        updateGameStats();
        gameHandler.removeCallbacks(gameRunnable);
        gameHandler.postDelayed(gameRunnable, 500);
    }

    public void stopGame() {
        gameActive = false;
        gameHandler.removeCallbacks(gameRunnable);
        if (morseKeyer != null) {
            morseKeyer.setInputEnabled(true);
            morseKeyer.cancelAll();
        }
    }

    private void exitGame() {
        stopGame();
        gameTextInput.setGravity(android.view.Gravity.END | android.view.Gravity.CENTER_VERTICAL);
        gameTextInput.setText("");
        gameLayout.setVisibility(View.GONE);
        contentLayout.setVisibility(View.VISIBLE);
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).scrollOutputToBottom();
        }
    }

    private void exitGameToMenu() {
        stopGame();
        gameTextInput.setGravity(android.view.Gravity.END | android.view.Gravity.CENTER_VERTICAL);
        gameTextInput.setText("");
        gameLayout.setVisibility(View.GONE);
        gameMenuLayout.setVisibility(View.VISIBLE);
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).scrollOutputToBottom();
        }
    }

    private void showQuitDialog() {
        gameQuitDialogText.setText(LanguageManager.get(MorseLanguage.QUIT_GAME_PROMPT));
        gameQuitBtnCancel.setText(LanguageManager.get(MorseLanguage.CANCEL));
        gameQuitBtnCancel.setVisibility(View.VISIBLE);
        gameQuitBtnQuit.setText(LanguageManager.get(MorseLanguage.QUIT));

        gameQuitBtnCancel.setOnClickListener(v -> {
            gameQuitDialogOverlay.setVisibility(View.GONE);
        });

        gameQuitBtnQuit.setOnClickListener(v -> {
            gameQuitDialogOverlay.setVisibility(View.GONE);
            endGame();
        });

        gameQuitDialogOverlay.setVisibility(View.VISIBLE);
    }

    private void endGame() {
        stopGame();
        if (gameTimeLimit > 0 && gameScore > gameRecord) {
            gameRecord = gameScore;
            String recordKey = isRxMode ? "record_rx" : "record";
            SharedPreferences prefs = activity.getSharedPreferences("morse_game", Context.MODE_PRIVATE);
            prefs.edit().putInt(recordKey, gameRecord).apply();
        }
        updateGameStats();
        showSummary();
    }

    private void updateGameStats() {
        updateGameStats(true);
    }

    private void updateGameStats(boolean colonVisible) {
        int t = gameTimeLimit > 0 ? (gameTimeLimit - gameTimeElapsed) : gameTimeElapsed;
        int min = t / 60;
        String sec = String.valueOf(t % 60);
        if (sec.length() == 1)
            sec = "0" + sec;
        String timeStr = min + ":" + sec;

        gameTimeLabel.setText(LanguageManager.get(MorseLanguage.TIME).replace(":", "").trim() + ": ");
        if (colonVisible) {
            gameTimeVal.setText(timeStr);
        } else {
            SpannableString ss = new SpannableString(timeStr);
            ss.setSpan(new android.text.style.ForegroundColorSpan(0x00000000), 0, ss.length(), 33);
            gameTimeVal.setText(ss);
        }

        gameScoreLabel.setText(LanguageManager.get(MorseLanguage.SCORE).replace(":", "").trim() + ": ");
        gameScoreVal.setText(String.valueOf(gameScore));
    }

    private void showSummary() {
        if (currentSummaryView != null) {
            ((ViewGroup) activity.findViewById(android.R.id.content)).removeView(currentSummaryView);
        }

        SharedPreferences prefs = activity.getSharedPreferences("morseKeyerSettings", Context.MODE_PRIVATE);
        String rawMode = isRxMode ? null : prefs.getString("mode", "iambic-a");
        int wpm = prefs.getInt("wpm", 15);
        boolean strict = prefs.getBoolean("strict", true);
        int interletterSpacing = prefs.getInt("interletterSpacing", 100);
        int interwordSpacing = prefs.getInt("interwordSpacing", 75);

        List<SummaryView.SummaryRow> params = new ArrayList<>();
        params.add(new SummaryView.SummaryRow(MorseLanguage.INTERLETTER_SPACING,
                strict ? "100%" : interletterSpacing + "%"));
        params.add(
                new SummaryView.SummaryRow(MorseLanguage.INTERWORD_SPACING, strict ? "100%" : interwordSpacing + "%"));

        int t = gameTimeElapsed;
        int min = t / 60;
        String sec = String.valueOf(t % 60);
        if (sec.length() == 1)
            sec = "0" + sec;
        String timeStr = min + ":" + sec;

        currentSummaryView = new SummaryView(activity, rawMode, wpm, timeStr, gameWordsSolved, gameScore, gameRecord,
                params, gameTimeLimit == 0,
                () -> { // onRetry
                    closeSummary();
                    startGame();
                },
                () -> { // onQuit
                    closeSummary();
                    gameLayout.setVisibility(View.GONE);
                    gameMenuLayout.setVisibility(View.VISIBLE);
                },
                () -> { // onShare
                    boolean pickLang = prefs.getBoolean("pickLangThemeOnShare", false);
                    if (pickLang) {
                        closeSummary();
                        currentShareView = ShareManager.createShareView(activity, rawMode, wpm, timeStr,
                                gameWordsSolved, gameScore, gameRecord, params, gameTimeLimit == 0, isDarkTheme,
                                () -> { // onBack
                                    closeShare();
                                    showSummary();
                                },
                                () -> { // onClose
                                    closeShare();
                                    gameLayout.setVisibility(View.GONE);
                                    contentLayout.setVisibility(View.VISIBLE);
                                });
                        ((ViewGroup) activity.findViewById(R.id.root_layout)).addView(currentShareView);
                        applyPaddlesToOverlay(currentShareView, "share_");
                    } else {
                        ShareManager.shareDirectly(activity, rawMode, wpm, timeStr, gameWordsSolved, gameScore,
                                gameRecord, params, gameTimeLimit == 0, isDarkTheme, null);
                    }
                },
                isDarkTheme);
        ((ViewGroup) activity.findViewById(R.id.root_layout)).addView(currentSummaryView);
        applyPaddlesToOverlay(currentSummaryView, "summary_");
    }

    private void applyPaddlesToOverlay(View view, String tagPrefix) {
        if (view == null)
            return;
        View pL = view.findViewWithTag(tagPrefix + "paddle_left");
        if (pL != null) {
            if (leftPaddleListener != null)
                pL.setOnTouchListener(leftPaddleListener);
            if (gamePaddleLeft != null) {
                ((TextView) pL).setText(gamePaddleLeft.getText());
                ((TextView) pL).setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, gamePaddleLeft.getTextSize());
            }
        }
        View pR = view.findViewWithTag(tagPrefix + "paddle_right");
        if (pR != null) {
            if (rightPaddleListener != null)
                pR.setOnTouchListener(rightPaddleListener);
            if (gamePaddleRight != null) {
                ((TextView) pR).setText(gamePaddleRight.getText());
                ((TextView) pR).setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, gamePaddleRight.getTextSize());
                pR.setVisibility(gamePaddleRight.getVisibility());
            }
        }
        View pD = view.findViewWithTag(tagPrefix + "paddle_divider");
        if (pD != null && gamePaddleDivider != null) {
            pD.setVisibility(gamePaddleDivider.getVisibility());
        }
    }

    private void closeSummary() {
        if (currentSummaryView != null) {
            ((ViewGroup) activity.findViewById(R.id.root_layout)).removeView(currentSummaryView);
            currentSummaryView = null;
        }
    }

    private void closeShare() {
        if (currentShareView != null) {
            ((ViewGroup) activity.findViewById(R.id.root_layout)).removeView(currentShareView);
            currentShareView = null;
        }
    }
}
