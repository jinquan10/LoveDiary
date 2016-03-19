package org.jz.lovediary.storage.entity;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.DatabaseTable;

import org.jz.lovediary.application.Globals;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;


/**
 * Created by JZ on 3/8/2016.
 */

@DatabaseTable(tableName = "diaryentry")
public class DiaryEntry implements EditTextEntry
{
    @DatabaseField
    private long created;
    @DatabaseField
    private long lastUpdated;
    @DatabaseField
    private String entry;

    public DiaryEntry()
    {
        created = Calendar.getInstance().getTimeInMillis();
    }

    private static Dao<DiaryEntry, Void> getDao()
    {
        try
        {
            return DaoManager.createDao(Globals.sqlStorage.getConnectionSource(), DiaryEntry.class);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Couldn't create or get the Dao", e);
        }
    }

    public static List<DiaryEntry> query(QueryBuilder<DiaryEntry, ?> builtQuery)
    {
        try
        {
            

            return getDao().query(builtQuery.prepare());
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Couldn't query", e);
        }
    }

    public static QueryBuilder<DiaryEntry, ?> buildQuery()
    {
        return getDao().queryBuilder();
    }

    @Override
    public long getCreated()
    {
        return created;
    }

    @Override
    public void setCreated(long created)
    {
        this.created = created;
    }

    @Override
    public long getLastUpdated()
    {
        return lastUpdated;
    }

    @Override
    public String getEntry()
    {
        return entry;
    }

    @Override
    public void setLastUpdated(long lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public void setEntry(String entry)
    {
        this.entry = entry;
    }
}
