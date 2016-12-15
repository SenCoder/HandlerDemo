package com.tcl.demo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tcl.demo.consts.DownloadConst;

/**
 * Created by shengyuan on 16-12-15.
 */

public class DownloadDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Task";
    public static final String DATABASE_NAME = "download.db";

    public DownloadDBHelper(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table if not exists " + TABLE_NAME +
                "(Id integer primary key autoincrement, " +
                "AppName varchar(128), " +
                "Url varchar(256), " +
                "Size integer, " +
                "CompletedBytes integer, " +
                "PackageName varchar(128))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
