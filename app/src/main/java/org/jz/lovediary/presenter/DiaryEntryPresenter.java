package org.jz.lovediary.presenter;

import org.jz.lovediary.layout.LDLayout;

import java.util.Date;

/**
 * Created by JZ on 4/20/2016.
 */
public class DiaryEntryPresenter extends AbsPresenter<DiaryEntryPresenter.Layout> {
    public DiaryEntryPresenter(Layout layout) {
        super(layout);
    }

    public interface Layout extends LDLayout {
        void setEntry(String entry);

        void setDate(String date);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getLayout().setEntry("Test test");
        getLayout().setDate(new Date().toString());
    }

    public void onTextChanged() {

    }
}
