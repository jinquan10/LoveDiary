package org.jz.lovediary.application;

import com.orm.SugarApp;

/**
 * Created by JZ on 3/6/2016.
 */
public class LoveDiaryApplication extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Globals.context = getApplicationContext();
    }
}
