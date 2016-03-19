package org.jz.lovediary.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.jz.lovediary.storage.entity.DiaryEntry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by john.zhuang on 3/18/16.
 */
public class SQLStorage extends OrmLiteSqliteOpenHelper
{
    private static List<Class<?>> tables = new ArrayList<>();

    static
    {
        tables.add(DiaryEntry.class);
    }

    public SQLStorage(Context context)
    {
        super(context, "lovediary.db", null, 4);
    }

    @Override
    public void close()
    {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
    {
        try
        {
            for (Class<?> clazz : tables)
            {
                TableUtils.createTableIfNotExists(connectionSource, clazz);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Trouble creating tables", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
        try
        {
            for (Class<?> clazz : tables)
            {
                TableUtils.dropTable(connectionSource, clazz, true);
            }

            onCreate(database, connectionSource);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Trouble upgrading tables", e);
        }
    }
}
