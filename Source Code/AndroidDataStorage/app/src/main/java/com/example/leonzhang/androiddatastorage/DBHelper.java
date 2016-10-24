package com.example.leonzhang.androiddatastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LeonZhang on 9/27/16.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 4;

    //Name of Database
    private static final String DATABASE_NAME = "SQLite.db";

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Database
    @Override
    public void onCreate(SQLiteDatabase db){
        //Table format
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + SQLite.TABLE + "("
                + SQLite.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SQLite.KEY_message + " TEXT NOT NULL)";

        db.execSQL(CREATE_TABLE);
    }

    //Update Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ SQLite.TABLE);
        onCreate(db);
    }
}
