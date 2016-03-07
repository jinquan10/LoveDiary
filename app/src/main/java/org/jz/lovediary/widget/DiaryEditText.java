package org.jz.lovediary.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.jz.lovediary.Util.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by JZ on 3/5/2016.
 */
public final class DiaryEditText extends EditText {
    protected SimpleDateFormat sdf = new SimpleDateFormat("MMM d, y");

    public DiaryEditText(Context context) {
        super(context);
        init();
    }

    public DiaryEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiaryEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        setHint(sdf.format(new Date()).toString());

        addTextChangedListener(new TextWatcher() {
            protected int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Math.abs(charCount - count) >= 10) {
                    // store the text into db
                }

                charCount = count;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Utils.logD("keyCode: " + keyCode);
                Utils.logD("event: " + event);

                return false;
            }
        });
    }
}
