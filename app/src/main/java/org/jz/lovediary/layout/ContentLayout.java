package org.jz.lovediary.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import org.jz.lovediary.presenter.ContentPresenter;
import org.jz.lovediary.presenter.MenuPresenter;

import butterknife.ButterKnife;

/**
 * Created by JZ on 4/17/2016.
 */
public class ContentLayout extends RelativeLayout implements ContentPresenter.View{
    private ContentPresenter presenter;

    public ContentLayout(Context context) {
        super(context);
    }

    public ContentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ContentLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ButterKnife.bind(this);
        this.presenter = new ContentPresenter(this);
        this.presenter.onCreate();
    }

    @Override
    public void setDiaryEntryView() {

    }
}
