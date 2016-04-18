package org.jz.lovediary.presenter;

import com.squareup.otto.Subscribe;

/**
 * Created by JZ on 4/17/2016.
 */
public class ContentPresenter extends AbsPresenter<ContentPresenter, ContentPresenter.View> {
    public interface View {
        void setDiaryEntryView();
    }

    public ContentPresenter(View layout) {
        super(layout);
    }

    @Override
    protected ContentPresenter getPresenter() {
        return this;
    }

    @Subscribe
    public void subscribeToLinks(MenuPresenter.Links links) {

    }
}
