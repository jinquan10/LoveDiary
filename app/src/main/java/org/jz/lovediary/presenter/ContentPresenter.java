package org.jz.lovediary.presenter;

import org.jz.lovediary.layout.LDLayout;

/**
 * Created by JZ on 4/17/2016.
 */
public class ContentPresenter extends AbsPresenter<ContentPresenter.Layout> {
    public interface Layout extends LDLayout {
        void setDiaryEntryView();
    }

    public ContentPresenter(Layout layout) {
        super(layout);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getLayout().setDiaryEntryView();
    }
}
