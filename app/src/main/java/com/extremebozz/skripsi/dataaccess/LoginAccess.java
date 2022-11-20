package com.extremebozz.skripsi.dataaccess;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.extremebozz.skripsi.DataHelper;
import com.extremebozz.skripsi.LoginActivity;

public class LoginAccess extends DataHelper{

    public LoginAccess(Context context) {
        super(context);
    }

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
