package org.jz.lovediary.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by JZ on 3/8/2016.
 */

@DatabaseTable(tableName = "diaryentry")
public class DiaryEntry extends AbsPersistableEntry implements EditTextEntry, MoodEntry {
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
    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String getEntry() {
        return entry;
    }

    @Override
    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public void invalidate() {
        createOrUpdate();
    }

    @Override
    public Mood getMood() {
        return mood;
    }

    @Override
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return entry;
    }
}
