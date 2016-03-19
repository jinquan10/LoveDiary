package org.jz.lovediary.factory;

/**
 * Created by john.zhuang on 3/18/16.
 */
public interface Initializor
{
    void initialize();

    void setOnBeforeListener(Runnable runnable);

    void setOnAfterListener(Runnable runnable);

    void destory();
}
