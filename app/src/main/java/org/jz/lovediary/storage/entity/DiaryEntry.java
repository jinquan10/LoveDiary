package org.jz.lovediary.storage.entity;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import org.jz.lovediary.application.Globals;

import java.sql.SQLException;
import java.util.Calendar;


/**
 * Created by JZ on 3/8/2016.
 */

public class DiaryEntry implements EditTextEntry, DAO
{
    private long created;
    private long lastUpdated;
    private String entry;

    public DiaryEntry()
    {
        created = Calendar.getInstance().getTimeInMillis();
    }

    @Override
    public Dao getDao()
    {
        try
        {
            return DaoManager.createDao(Globals.sqlStorage.connectionSource, DiaryEntry.class);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Couldn't create or get the Dao", e);
        }
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
