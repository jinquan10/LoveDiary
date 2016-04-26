package org.jz.lovediary.api;

import java.lang.ref.WeakReference;

public abstract class AbsPresenter<TView extends AndroidMVPApi.View, TProvider extends AndroidMVPApi.Provider> implements AndroidMVPApi.Presenter<TView> {
    protected WeakReference<TView> view;
    protected TProvider provider;

    @Override
    public void onAttachView(TView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    protected boolean isViewAttached() {
        return view.get() != null;
    }
}

