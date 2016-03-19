package org.jz.lovediary.storage.rules;

import android.text.Editable;
import android.text.TextWatcher;

import com.j256.ormlite.dao.Dao;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.storage.entity.EditTextEntry;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by JZ on 3/8/2016.
 */
public abstract class SimpleEditTextPersistenceRule implements TextWatcher, EditTextEntry {
    private int currCount = 0;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (count - currCount > 10) {
            currCount = count;
            setLastUpdated(new Date().getTime());
            setEntry(s.toString());

            try {
                Dao.CreateOrUpdateStatus createOrUpdateStatus = Globals.getDao(this.getClass()).createOrUpdate(this);
                if (!createOrUpdateStatus.isUpdated() && !createOrUpdateStatus.isCreated()) {
                    throw new RuntimeException("Could not create or update");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Could not create or update", e);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
