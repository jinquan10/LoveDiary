package org.jz.lovediary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import org.jz.lovediary.entity.DiaryEntry;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;

import java.util.Date;

/**
 * Created by JZ on 4/3/2016.
 */
public class DiaryEntryView extends EditText {
    public DiaryEntryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(DiaryEntry diaryEntry) {
        setHint(org.jz.lovediary.util.Utils.DEFAULT_DATE_FORMATTER.format(new Date()).toString());
        setText(diaryEntry.getEntry());
        addTextChangedListener(new SimpleEditTextPersistenceRule(diaryEntry));
    }
}
