package org.jz.lovediary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import org.jz.lovediary.util.Utils;
import org.jz.lovediary.storage.entity.DiaryEntry;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        List<DiaryEntry> entries = DiaryEntry.find(DiaryEntry.class, "SELECT * FROM DiaryEntry ORDER BY created DESC LIMIT 1;");

        DiaryEntry entry = null;
        if (entries.size() == 1) {
            entry = entries.get(0);
            if (Utils.isFromToday(entry.lastUpdated)) {

            } else {
                entry = new DiaryEntry();
            }
        } else if (entries.size() == 0) { // no entries yet
            entry = new DiaryEntry();
        } else if (entries.size() != 1) {
            throw new RuntimeException("Expected one DiaryEntry");
        }

        addTextChangedListener(new SimpleEditTextPersistenceRule(entry));
    }
}
