package org.jz.lovediary.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jz.lovediary.application.LoveDiaryApplication;

/**
 * Created by JZ on 3/5/2016.
 */
public final class SQLStorage {

    public static final String DB_NAME = "lovediary.db";
    public static final int DATABASE_VERSION = 1;

    protected final SQLHelper sqlHelper;

    public SQLStorage() {
        sqlHelper = new SQLHelper(LoveDiaryApplication.context, DB_NAME, null, DATABASE_VERSION);
    }

    protected class SQLHelper extends SQLiteOpenHelper {
        public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
