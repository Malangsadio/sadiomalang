package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDatabaseHeloer extends SQLiteOpenHelper {

    private static String DATABASENAME = "student1.db";
    private static int DATABASEVERSION = 1;
    public StudentDatabaseHeloer(Context context){
        super(context, DATABASENAME ,null, DATABASEVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student1(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
