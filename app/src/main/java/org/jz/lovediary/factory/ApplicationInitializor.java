package org.jz.lovediary.factory;

/**
 * Created by john.zhuang on 3/18/16.
 */
public class ApplicationInitializor {
//    private static List<Factory> factories;
//
//    static {
//        factories = new ArrayList<>();
//        factories.add(new SQLStorageFactory());
//        factories.add(new SingletonFactory());
//    }
//
//    private Runnable onBeforeRunnable;
//    private Runnable onFinishedRunnable;
//    private Thread initializeThread;
//
//    public static class A {
//        public void print() {
//            Log.d("jzjz", "A");
//        }
//    }
//
//    public static class B extends A {
//        @Override
//        public void print() {
//            Log.d("jzjz", "B");
//        }
//    }
//
//    @Override
//    public void initialize() {
//
//        A a = new B();
//        a.print();
//
//        onBefore();
//
//        initializeThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (Factory factory : factories) {
//                    factory.create();
//                }
//
//                Globals.handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        onAfter();
//                    }
//                });
//            }
//        });
//
//        initializeThread.start();
//    }
//
//    @Override
//    public void destory() {
//        for (Factory factory : factories) {
//            factory.destory();
//        }
//
//        try {
//            initializeThread.interrupt();
//            initializeThread.join();
//        } catch (InterruptedException e) {
//            Log.d(Utils.APP_TAG, "Shutting down initialization thread...", null);
//        }
//    }
//
//    @Override
//    public void setOnBeforeListener(Runnable runnable) {
//        this.onBeforeRunnable = runnable;
//    }
//
//    @Override
//    public void setOnAfterListener(Runnable runnable) {
//        this.onFinishedRunnable = runnable;
//    }
//
//    protected void onBefore() {
//        this.onBeforeRunnable.run();
//    }
//
//    protected void onAfter() {
//        this.onFinishedRunnable.run();
//    }
//
//    private static class SQLStorageFactory implements Factory {
//        @Override
//        public void create() {
//            Globals.sqlStorage = OpenHelperManager.getHelper(Globals.context, org.jz.lovediary.storage.SQLStorage.class);
//        }
//
//        @Override
//        public void destory() {
//            OpenHelperManager.releaseHelper();
//            Log.d(Utils.APP_TAG, "SQLStorageFactory destroyed", null);
//        }
//    }
//
//    private static class SingletonFactory implements Factory {
//
//        @Override
//        public void create() {
//            Globals.persistenceManager = new PersistenceManager();
//        }
//
//        @Override
//        public void destory() {
//
//        }
//    }
}
