package com.qft8.morsekeyer.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShareReceiver extends BroadcastReceiver {
    public static Runnable onShareAppSelected;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (onShareAppSelected != null) {
            onShareAppSelected.run();
            onShareAppSelected = null;
        }
    }
}
