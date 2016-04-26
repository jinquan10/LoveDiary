package org.jz.lovediary;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by JZ on 4/25/2016.
 */
public class SvgView extends ImageView {
    public SvgView(Context context) {
        super(context);
    }

    public SvgView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SvgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SvgView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {


        super.setImageDrawable(drawable);
    }
}
