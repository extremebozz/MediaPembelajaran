package com.extremebozz.skripsi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.SharedPreferences;

public class DataHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "mlearning.db";
    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase db = this.getWritableDatabase();

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE login ( id INTEGER, username TEXT NOT NULL UNIQUE, password TEXT NOT NULL, role TEXT NOT NULL, PRIMARY KEY(id));";
        db.execSQL(sql);

        sql = "INSERT INTO login(id, username, password, role) VALUES (null, 'admin', 'admin', 'admin');";
        db.execSQL(sql);

        sql = "CREATE TABLE data_jamur (id INTEGER, nama TEXT NOT NULL, deskripsi TEXT NOT NULL, " +
                "aktif TEXT NOT NULL DEFAULT 'Y', PRIMARY KEY(id));";
        db.execSQL(sql);

        sql = "INSERT INTO data_jamur (id, nama, deskripsi, aktif) VALUES ('1', 'Jamur Tiram', 'Test', 'Y');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){}
}
