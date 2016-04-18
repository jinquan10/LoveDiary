package org.jz.lovediary.application;

import android.app.Application;


/**
 * Created by JZ on 3/6/2016.
 */
public class LoveDiaryApplication extends Application {
    private static LoveDiaryApplication loveDiaryApplication;

    public final ApplicationBus applicationBus = new ApplicationBus();

    public LoveDiaryApplication() {
        loveDiaryApplication = this;
    }

    public static LoveDiaryApplication instance() {
        return loveDiaryApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                defaultUncaughtExceptionHandler.uncaughtException(thread, ex);
            }
        });
    }
}
