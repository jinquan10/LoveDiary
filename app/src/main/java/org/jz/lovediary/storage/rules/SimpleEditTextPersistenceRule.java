package org.jz.lovediary.storage.rules;

import android.text.Editable;
import android.text.TextWatcher;

import com.j256.ormlite.dao.Dao;

import org.jz.lovediary.entity.PersistableEditTextMoodEntry;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by JZ on 3/8/2016.
 */
public class SimpleEditTextPersistenceRule implements TextWatcher {
    private final PersistableEditTextMoodEntry persistableEditTextMoodEntry;

    public SimpleEditTextPersistenceRule(PersistableEditTextMoodEntry persistableEditTextMoodEntry) {
        this.persistableEditTextMoodEntry = persistableEditTextMoodEntry;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        persistableEditTextMoodEntry.setLastUpdated(new Date().getTime());
        persistableEditTextMoodEntry.setEntry(s.toString());

        try {
            Dao.CreateOrUpdateStatus createOrUpdateStatus = persistableEditTextMoodEntry.getDao().createOrUpdate(persistableEditTextMoodEntry);
            if (!createOrUpdateStatus.isUpdated() && !createOrUpdateStatus.isCreated()) {
                throw new RuntimeException("Could not create or update");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not create or update", e);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
