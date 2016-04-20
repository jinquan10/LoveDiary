package org.jz.lovediary.presenter;

import org.jz.lovediary.layout.LDLayout;
import org.jz.lovediary.layout.MenuLayout;

/**
 * Created by JZ on 4/17/2016.
 */
public class MenuPresenter extends AbsPresenter<MenuPresenter.Layout> {
    public interface Layout extends LDLayout{
        void setDiaryEntryLayout();
    }

    public enum Links {
        FACEBOOK, STATS, TAG
    }

    public MenuPresenter(Layout layout) {
        super(layout);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getLayout().setDiaryEntryLayout();
    }

    public void onMenuItemDown(MenuLayout.MenuItem menuItem) {

    }
}
