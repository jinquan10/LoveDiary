package org.jz.lovediary.storage.rules;

import android.text.Editable;
import android.text.TextWatcher;

import org.jz.lovediary.entity.EditTextEntry;

import java.util.Date;

/**
 * Created by JZ on 3/8/2016.
 */
public class SimpleEditTextPersistenceRule implements TextWatcher {
    private final EditTextEntry entry;

    public SimpleEditTextPersistenceRule(EditTextEntry entry) {
        this.entry = entry;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        entry.setLastUpdated(new Date().getTime());
        entry.setEntry(s.toString());
        entry.invalidate();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
