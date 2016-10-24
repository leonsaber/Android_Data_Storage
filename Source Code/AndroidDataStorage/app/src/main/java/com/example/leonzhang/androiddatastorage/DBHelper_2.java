package com.example.leonzhang.androiddatastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LeonZhang on 9/27/16.
 */
public class DBHelper_2 extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 4;

    //Name of Database
    private static final String DATABASE_NAME = "SQLite_2.db";

    public DBHelper_2 (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db){
        //Table format
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + SQLite_2.TABLE + "("
                + SQLite_2.KEY_id  + " INTEGER PRIMARY KEY AUTOINCREMENT," + SQLite_2.KEY_name + " TEXT NOT NULL,"
                + SQLite_2.KEY_author +" TEXT NOT NULL,"+ SQLite_2.KEY_description + " TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE);
    }

    //Update Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ SQLite_2.TABLE);
        onCreate(db);
    }
}
