package org.jz.lovediary.entry;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import org.jz.lovediary.Mood;

/**
 * Created by JZ on 4/23/2016.
 */
public class DiaryEntryView extends RelativeLayout implements DiaryEntryApi.View {
    private DiaryEntryApi.Presenter presenter;

    public DiaryEntryView(Context context) {
        super(context);
    }

    public DiaryEntryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiaryEntryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DiaryEntryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.presenter = new DiaryEntryPresenter();
    }

    @Override
    public void displayDate(String dateString) {

    }

    @Override
    public void displayMood(Mood mood) {

    }

    @Override
    public void displayMoodSelection(Mood[] moods) {

    }

    @Override
    public void displayText(String entry) {

    }
}
