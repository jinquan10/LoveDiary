package org.jz.lovediary.storage.entity;

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
