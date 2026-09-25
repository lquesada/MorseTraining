package com.qft8.morsekeyer.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShareReceiver extends BroadcastReceiver {
    public static Runnable onShareAppSelected;

    public static void clear() {
        onShareAppSelected = null;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (onShareAppSelected != null) {
            Runnable r = onShareAppSelected;
            onShareAppSelected = null;
            r.run();
        }
    }
}
