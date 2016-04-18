package org.jz.lovediary.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by JZ on 4/17/2016.
 */
public class ScreenLayout extends RelativeLayout {
    public ScreenLayout(Context context) {
        super(context);
    }

    public ScreenLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScreenLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScreenLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
