package org.jz.lovediary.storage.entity;

import com.orm.SugarRecord;

/**
 * Created by JZ on 3/6/2016.
 */
public class EditTextEntry extends SugarRecord {
    public long created;
    public long lastUpdated;
    public String entry;

    public EditTextEntry() {}
}
