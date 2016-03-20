package org.jz.lovediary.factory;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.storage.SQLStorage;
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
        factories.add(new DAOFactory());
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
            Utils.logD("Shutting down initialization thread...");
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

    private static class DAOFactory implements Factory {
        @Override
        public void create() {
            Globals.sqlStorage = OpenHelperManager.getHelper(Globals.context, SQLStorage.class);
        }

        @Override
        public void destory() {
            Globals.sqlStorage.close();
            Utils.logD("DAOFactory destroyed");
        }
    }
}
