package org.jz.lovediary.storage.entity;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by JZ on 3/6/2016.
 */
public interface EditTextEntry
{
    void setLastUpdated(long lastUpdated);

    void setEntry(String entry);

    public long getCreated();

    public void setCreated(long created);

    public long getLastUpdated();

    public String getEntry();
}
