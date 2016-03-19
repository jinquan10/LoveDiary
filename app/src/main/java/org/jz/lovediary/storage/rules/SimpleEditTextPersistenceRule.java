package org.jz.lovediary.storage.rules;

import android.text.Editable;
import android.text.TextWatcher;

import org.jz.lovediary.storage.entity.DiaryEntry;
import org.jz.lovediary.storage.entity.EditTextEntry;

import java.util.Date;

/**
 * Created by JZ on 3/8/2016.
 */
public class SimpleEditTextPersistenceRule implements TextWatcher {
    protected int currCount = 0;
    protected EditTextEntry editTextEntry;

    public SimpleEditTextPersistenceRule(EditTextEntry editTextEntry) {
        this.editTextEntry = editTextEntry;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (count - currCount > 10) {
            currCount = count;
            editTextEntry.setLastUpdated(new Date().getTime());
            editTextEntry.setEntry(s.toString());

            DiaryEntry.
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
