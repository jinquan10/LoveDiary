package org.jz.lovediary.presenter;

import org.jz.lovediary.application.LoveDiaryApplication;
import org.jz.lovediary.layout.LDLayout;

/**
 * Created by JZ on 4/17/2016.
 */
public abstract class AbsPresenter<L extends LDLayout> implements Presenter {
    private final L layout;

    public AbsPresenter(L layout) {
        this.layout = layout;
    }

    protected L getLayout() {
        return layout;
    }

    @Override
    public void onCreate() {
        LoveDiaryApplication.instance().applicationBus.register(this);
    }

    @Override
    public void onDestroy() {
        LoveDiaryApplication.instance().applicationBus.unregister(this);
    }
}
