package com.example.leonzhang.androiddatastorage;

/**
 * Created by LeonZhang on 9/27/16.
 */
public class SQLite_2 {
    //Name of table
    public static final String TABLE = "Preference";

    //Table Columns names
    public static final String KEY_id = "id";
    public static final String KEY_name = "name";
    public static final String KEY_author = "author";
    public static final String KEY_description = "description";
    //Data keeper
    public int id;
    public String name;
    public String author;
    public String description;
}
