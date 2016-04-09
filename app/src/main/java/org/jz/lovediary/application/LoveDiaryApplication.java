package org.jz.lovediary.application;

import android.app.Application;
import android.os.Handler;


/**
 * Created by JZ on 3/6/2016.
 */
public class LoveDiaryApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Globals.context = getApplicationContext();
        Globals.handler = new Handler(getMainLooper());

        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
            }
        });
    }


}
