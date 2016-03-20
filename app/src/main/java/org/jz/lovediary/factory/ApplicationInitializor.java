package org.jz.lovediary.factory;

import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.util.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by john.zhuang on 3/18/16.
 */
public class ApplicationInitializor implements Initializor {
    private Runnable onBeforeRunnable;
    private Runnable onFinishedRunnable;
    private static List<Factory> factories;
    private Thread initializeThread;

    static {
        factories = new ArrayList<>();
        factories.add(new SQLStorageFactory());
    }

    @Override
    public void initialize() {
        onBefore();

        initializeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Factory factory : factories) {
                    factory.create();
                }

                Globals.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onAfter();
                    }
                });
            }
        });

        initializeThread.start();
    }

    @Override
    public void destory() {
        for (Factory factory : factories) {
            factory.destory();
        }

        try {
            initializeThread.interrupt();
            initializeThread.join();
        } catch (InterruptedException e) {
            Log.d(Utils.APP_TAG, "Shutting down initialization thread...", null);
        }
    }

    @Override
    public void setOnBeforeListener(Runnable runnable) {
        this.onBeforeRunnable = runnable;
    }

    @Override
    public void setOnAfterListener(Runnable runnable) {
        this.onFinishedRunnable = runnable;
    }

    protected void onBefore() {
        this.onBeforeRunnable.run();
    }

    protected void onAfter() {
        this.onFinishedRunnable.run();
    }

    private static class SQLStorageFactory implements Factory {
        @Override
        public void create() {
            Globals.sqlStorage = OpenHelperManager.getHelper(Globals.context, org.jz.lovediary.storage.SQLStorage.class);
        }

        @Override
        public void destory() {
            OpenHelperManager.releaseHelper();
            Log.d(Utils.APP_TAG, "SQLStorageFactory destroyed", null);
        }
    }
}
