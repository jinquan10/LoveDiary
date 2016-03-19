package org.jz.lovediary.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.jz.lovediary.application.Globals;
import org.jz.lovediary.storage.entity.DiaryEntry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by john.zhuang on 3/18/16.
 */
public class SqlStorage
{
    private static DBHelper dBHelper = new DBHelper(Globals.context, "lovediary.db", null, 1);
    private static List<Class<?>> tables = new ArrayList<>();
    public static ConnectionSource connectionSource = dBHelper.androidConnectionSource;

    static
    {
        tables.add(DiaryEntry.class);
    }

    public static void close(){
        dBHelper.close();
    }

    private static class DBHelper extends SQLiteOpenHelper
    {
        private AndroidConnectionSource androidConnectionSource;

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
            androidConnectionSource = new AndroidConnectionSource(this);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                for (Class<?> clazz : tables)
                {
                    TableUtils.createTable(androidConnectionSource, clazz);
                }
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Trouble creating tables", e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            // - don't delete user data yet
            //            try
            //            {
            //                for (Class<?> clazz : tables)
            //                {
            //                    TableUtils.createTable(Globals.connectionSource, clazz);
            //                }
            //
            //                onCreate(db);
            //            }
            //            catch (SQLException e)
            //            {
            //                throw new RuntimeException("Trouble upgrading tables", e);
            //            }
        }
    }
}
