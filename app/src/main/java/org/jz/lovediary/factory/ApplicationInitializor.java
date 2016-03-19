package org.jz.lovediary.factory;

import org.jz.lovediary.application.Globals;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by john.zhuang on 3/18/16.
 */
public class ApplicationInitializor implements Initializor
{
    private Runnable onBeforeRunnable;
    private Runnable onFinishedRunnable;
    private static List<Factory> factories;

    @Override
    public void initialize()
    {
        factories = new ArrayList<>();
        factories.add(new ThreadSleepFactory());

        onBefore();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (Factory factory : factories)
                {
                    factory.create();
                }

                Globals.handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        onAfter();
                    }
                });
            }
        }).start();
    }

    @Override
    public void setOnBeforeListener(Runnable runnable)
    {
        this.onBeforeRunnable = runnable;
    }

    @Override
    public void setOnAfterListener(Runnable runnable)
    {
        this.onFinishedRunnable = runnable;
    }

    protected void onBefore()
    {
        this.onBeforeRunnable.run();
    }

    protected void onAfter()
    {
        this.onFinishedRunnable.run();
    }

    private static class ThreadSleepFactory implements Factory
    {

        @Override
        public void create()
        {
            try
            {
                Thread.sleep(2000l);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
