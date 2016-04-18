package org.jz.lovediary.application;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by JZ on 4/17/2016.
 */
public class ApplicationBus {
    private final Bus bus = new Bus();
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public void register(Object object) {
        bus.register(object);
    }
    public void unregister(Object object) {
        bus.unregister(object);
    }

    public void post(final Object object) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                    bus.post(object);
                }
            });
        }
    }
}
