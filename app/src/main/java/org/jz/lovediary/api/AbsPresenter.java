package org.jz.lovediary.api;

import java.lang.ref.WeakReference;

/**
 * Created by JZ on 4/23/2016.
 */
public abstract class AbsPresenter<TView extends AndroidMVPApi.View, TProvider extends AndroidMVPApi.Provider> implements AndroidMVPApi.Presenter<TView> {
    protected WeakReference<TView> view;
    protected TProvider provider;

    @Override
    public void onViewReady(TView view) {
        this.view = new WeakReference<>(view);
    }

    protected boolean isViewAttached() {
        return view.get() != null;
    }
}

