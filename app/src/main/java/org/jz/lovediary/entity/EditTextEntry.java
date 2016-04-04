package org.jz.lovediary.entity;

/**
 * Created by JZ on 3/6/2016.
 */
public interface EditTextEntry {
    public long getLastUpdated();

    void setLastUpdated(long lastUpdated);

    public long getCreated();

    public void setCreated(long created);

    public String getEntry();

    void setEntry(String entry);

    public void invalidate();
}
