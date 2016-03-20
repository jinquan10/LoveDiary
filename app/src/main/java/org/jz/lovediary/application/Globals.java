package org.jz.lovediary.application;

import android.content.Context;
import android.os.Handler;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import org.jz.lovediary.factory.ApplicationInitializor;
import org.jz.lovediary.storage.SQLStorage;

import java.sql.SQLException;


/**
 * Created by JZ on 3/6/2016.
 */
public class Globals {
    public static Context context;
    public static Handler handler;
    public static ApplicationInitializor appInitializor;
    public static SQLStorage sqlStorage;

    public static Dao getDao(Class<?> clazz) {
        try {
            return DaoManager.createDao(Globals.sqlStorage.getConnectionSource(), clazz);
        } catch (SQLException e) {
            throw new RuntimeException("Could not get the dao", e);
        }
    };
}
