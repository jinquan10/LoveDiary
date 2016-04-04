package org.jz.lovediary.entity;

import com.j256.ormlite.dao.Dao;

/**
 * Created by JZ on 3/19/2016.
 */
public interface PersistableEntry {
    void createOrUpdate();
}
