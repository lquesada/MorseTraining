package com.qft8.morsekeyer;

import android.content.Context;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private final Context context;
    private final Thread.UncaughtExceptionHandler defaultHandler;

    public CrashHandler(Context context) {
        this.context = context;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        try {
            File file = new File(context.getExternalFilesDir(null), "crash_log.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            throwable.printStackTrace(pw);
            pw.flush();
            pw.close();
            fw.close();
        } catch (Exception e) {
            // Ignore
        }
        defaultHandler.uncaughtException(thread, throwable);
    }
}
