package com.example.leonzhang.androiddatastorage;

/**
 * Created by LeonZhang on 9/27/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteWriter {
    private DBHelper dbHelper;

    public SQLiteWriter(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(SQLite sq) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLite.KEY_message, sq.message);

        // Inserting Row
        long id = db.insert(SQLite.TABLE, null, values);
        db.close();
        return (int) id;
    }

}
