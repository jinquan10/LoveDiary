package org.jz.lovediary.presenter;

import org.jz.lovediary.layout.MenuLayout;

/**
 * Created by JZ on 4/17/2016.
 */
public class MenuPresenter extends AbsPresenter<MenuPresenter, MenuPresenter.View> {
    public interface View {
        void setDiaryEntryLayout();
    }

    public enum Links {
        FACEBOOK, STATS, TAG
    }

    public MenuPresenter(View layout) {
        super(layout);
    }

    @Override
    protected MenuPresenter getPresenter() {
        return this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getLayout().setDiaryEntryLayout();
    }

    public void onMenuItemDown(MenuLayout.MenuItem menuItem) {

    }
}
