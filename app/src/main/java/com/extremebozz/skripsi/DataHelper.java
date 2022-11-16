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
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    //LoginActivity
    public boolean readUser (String username, String password, SharedPreferences.Editor editor){
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            Cursor cursor;

            cursor = db.rawQuery("SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'", null);
            cursor.moveToFirst();

            if (cursor.getCount() > 0){
                editor.putInt(LoginActivity.USER_ID, Integer.parseInt(cursor.getString(0)));
                editor.putString(LoginActivity.USERNAME, cursor.getString(1));
                editor.apply();

                return true;
            }else {
                return false;
            }
        }catch (Exception msg){
            return false;
        }
    }
}
