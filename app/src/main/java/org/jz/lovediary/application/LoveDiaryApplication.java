package org.jz.lovediary.application;

import android.app.Application;
import android.app.Service;
import android.content.Context;

/**
 * Created by JZ on 3/6/2016.
 */
public final class LoveDiaryApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
