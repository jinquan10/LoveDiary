package org.jz.lovediary.entity;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.jz.lovediary.application.Globals;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by JZ on 3/8/2016.
 */

@DatabaseTable(tableName = "diaryentry")
public class DiaryEntry implements PersistableEditTextMoodEntry {
    @DatabaseField(id = true)
    private long created;
    @DatabaseField
    private long lastUpdated;
    @DatabaseField
    private String entry;
    @DatabaseField
    private Mood mood;

    public DiaryEntry() {
        created = System.currentTimeMillis();
    }

    public static DiaryEntry getLatest() {
        try {
            Dao<DiaryEntry, Long> diaryEntryDao = Globals.getDao(DiaryEntry.class);
            List<DiaryEntry> entries = diaryEntryDao.query(diaryEntryDao.queryBuilder().orderBy("created", false).limit(1l).prepare());

            if (entries.size() == 1) {
                return entries.get(0);
            } else if (entries.size() != 0) {
                throw new RuntimeException("Expected one DiaryEntry");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not prepare query", e);
        }
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

    @Override
    public Dao getDao() {
        return Globals.getDao(this.getClass());
    }

    @Override
    public Mood getMood() {
        return mood;
    }

    @Override
    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
