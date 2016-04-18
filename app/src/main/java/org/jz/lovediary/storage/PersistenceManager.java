package org.jz.lovediary.storage;

/**
 * Created by JZ on 4/3/2016.
 */
public class PersistenceManager {
//    private static Dao getDao(Class<?> clazz) {
//        try {
//            return DaoManager.createDao(Globals.sqlStorage.getConnectionSource(), clazz);
//        } catch (SQLException e) {
//            throw new RuntimeException("Could not get the dao", e);
//        }
//    }
//
//    public <T> T getLatest(Class<T> clazz) {
//        try {
//            Dao<T, Long> diaryEntryDao = getDao(clazz);
//            List<T> entries = diaryEntryDao.query(diaryEntryDao.queryBuilder().orderBy("created", false).limit(1l).prepare());
//
//            if (entries.size() == 1) {
//                return entries.get(0);
//            } else if (entries.size() != 0) {
//                throw new RuntimeException("Expected one entry");
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Could not prepare query", e);
//        }
//    }
//
//    public Dao.CreateOrUpdateStatus createOrUpdate(PersistableEntry persistableEntry) {
//        try {
//            return getDao(persistableEntry.getClass()).createOrUpdate(persistableEntry);
//        } catch (SQLException e) {
//            throw new RuntimeException("Could not create or update", e);
//        }
//    }
//
//    public <T> List<T> getAllEntities(Class<T> clazz) {
//        try {
//            Dao<T, Long> diaryEntryDao = getDao(clazz);
//            return diaryEntryDao.query(diaryEntryDao.queryBuilder().orderBy("created", false).prepare());
//        } catch (SQLException e) {
//            throw new RuntimeException("Could not prepare query", e);
//        }
//    }
}
