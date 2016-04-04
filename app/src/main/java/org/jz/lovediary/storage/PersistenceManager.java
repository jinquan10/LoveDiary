package org.jz.lovediary.storage;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.entity.PersistableEntry;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JZ on 4/3/2016.
 */
public class PersistenceManager {
    private static Dao getDao(Class<?> clazz) {
        try {
            return DaoManager.createDao(Globals.sqlStorage.getConnectionSource(), clazz);
        } catch (SQLException e) {
            throw new RuntimeException("Could not get the dao", e);
        }
    }

    public <T> T getLatest(Class<T> clazz) {
        try {
            Dao<T, Long> diaryEntryDao = getDao(clazz);
            List<T> entries = diaryEntryDao.query(diaryEntryDao.queryBuilder().orderBy("created", false).limit(1l).prepare());

            if (entries.size() == 1) {
                return entries.get(0);
            } else if (entries.size() != 0) {
                throw new RuntimeException("Expected one entry");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not prepare query", e);
        }
    }

    public Dao.CreateOrUpdateStatus createOrUpdate(PersistableEntry persistableEntry) {
        try {
            return getDao(persistableEntry.getClass()).createOrUpdate(persistableEntry);
        } catch (SQLException e) {
            throw new RuntimeException("Could not create or update", e);
        }
    }
}
