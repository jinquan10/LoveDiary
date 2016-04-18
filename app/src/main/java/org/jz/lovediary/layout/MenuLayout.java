package org.jz.lovediary.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jz.lovediary.R;
import org.jz.lovediary.presenter.MenuPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by JZ on 4/17/2016.
 */
public class MenuLayout extends LinearLayout implements MenuPresenter.View {
    public enum MenuItem {
        SHARE, STATS, TAG, WRITE
    }

    private MenuPresenter presenter;

    @Bind(R.id.share)
    private TextView shareTextView;

    @Bind(R.id.stats)
    private TextView statsTextView;

    @Bind(R.id.tag)
    private TextView tagTextView;

    @Bind(R.id.write)
    private TextView writeTextView;

    public MenuLayout(Context context) {
        super(context);
    }

    public MenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MenuLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ButterKnife.bind(this);
        this.presenter = new MenuPresenter(this);
        this.presenter.onCreate();
    }

    @Override
    public void setDiaryEntryLayout() {
        setAllChildrenVisibility(VISIBLE);
    }

    private void setAllChildrenVisibility(int visibility) {
        int c = getChildCount();
        for (int i = 0; i < c; i++) {
            getChildAt(i).setVisibility(GONE);
        }
    }
}
