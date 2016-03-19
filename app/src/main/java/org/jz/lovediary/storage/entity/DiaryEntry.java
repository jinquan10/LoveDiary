package org.jz.lovediary.storage.entity;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;

import java.sql.SQLException;


/**
 * Created by JZ on 3/8/2016.
 */

@DatabaseTable(tableName = "diaryentry")
public class DiaryEntry extends SimpleEditTextPersistenceRule {
    @DatabaseField(id = true)
    private long created;
    @DatabaseField
    private long lastUpdated;
    @DatabaseField
    private String entry;

    public DiaryEntry() {
        created = System.currentTimeMillis();
    }

    @Override
    public long getCreated() {
        return created;
    }

    @Override
    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String getEntry() {
        return entry;
    }

    @Override
    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public void setEntry(String entry) {
        this.entry = entry;
    }
}
