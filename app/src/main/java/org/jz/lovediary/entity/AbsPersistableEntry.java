package org.jz.lovediary.entity;

import com.j256.ormlite.dao.Dao;

import org.jz.lovediary.application.Globals;

/**
 * Created by JZ on 4/3/2016.
 */
public class AbsPersistableEntry implements PersistableEntry {
    @Override
    public void createOrUpdate() {
        Dao.CreateOrUpdateStatus createOrUpdateStatus = Globals.persistenceManager.createOrUpdate(this);
        if (!createOrUpdateStatus.isUpdated() && !createOrUpdateStatus.isCreated()) {
            throw new RuntimeException("Could not create or update");
        }
    }
}
