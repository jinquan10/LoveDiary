package org.jz.lovediary.storage.entity;

/**
 * Created by JZ on 3/6/2016.
 */
public abstract class EditTextEntry {
    protected long created;
    protected long lastUpdated;

    public String getEntry()
    {
        return entry;
    }

    public void setEntry(String entry)
    {
        this.entry = entry;
    }

    public long getCreated()
    {
        return created;
    }

    public void setCreated(long created)
    {
        this.created = created;
    }

    public long getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    protected String entry;
}
