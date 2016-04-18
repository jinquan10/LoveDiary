package org.jz.lovediary.presenter;

import org.jz.lovediary.application.LoveDiaryApplication;

/**
 * Created by JZ on 4/17/2016.
 */
public abstract class AbsPresenter<P extends Presenter, L> implements Presenter {
    private final L layout;

    public AbsPresenter(L layout) {
        this.layout = layout;
    }

    protected abstract P getPresenter();

    protected L getLayout() {
        return layout;
    }

    @Override
    public void onCreate() {
        LoveDiaryApplication.instance().applicationBus.register(getPresenter());
    }

    @Override
    public void onDestroy() {
        LoveDiaryApplication.instance().applicationBus.unregister(getPresenter());
    }
}
