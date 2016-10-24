package com.example.leonzhang.androiddatastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by LeonZhang on 9/27/16.
 */
public class PreferenceWriter {
    private DBHelper_2 dbHelper_2;

    public PreferenceWriter(Context context) {
        dbHelper_2 = new DBHelper_2(context);
    }

    public int insert(SQLite_2 sq) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper_2.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLite_2.KEY_name, sq.name);
        values.put(SQLite_2.KEY_author, sq.author);
        values.put(SQLite_2.KEY_description, sq.description);

        // Inserting Row
        long id = db.insert(SQLite_2.TABLE, null, values);
        db.close();
        return (int) id;
    }
}
