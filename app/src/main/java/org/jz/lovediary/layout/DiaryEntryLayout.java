package org.jz.lovediary.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jz.lovediary.R;
import org.jz.lovediary.presenter.DiaryEntryPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by JZ on 4/20/2016.
 */
public class DiaryEntryLayout extends LinearLayout implements DiaryEntryPresenter.Layout {
    private DiaryEntryPresenter diaryEntryPresenter;

    @Bind(R.id.dateText)
    TextView dateText;

    @Bind(R.id.entry)
    EditText entry;

    public DiaryEntryLayout(Context context) {
        super(context);
    }

    public DiaryEntryLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiaryEntryLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DiaryEntryLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ButterKnife.bind(this);
        this.diaryEntryPresenter = new DiaryEntryPresenter(this);
        this.diaryEntryPresenter.onCreate();
    }

    @Override
    public void setEntry(String entry) {
        this.entry.setText(entry);
    }

    @Override
    public void setDate(String dateStr) {
        this.dateText.setText(dateStr);
    }
}
