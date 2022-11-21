package com.extremebozz.skripsi.dataaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.extremebozz.skripsi.DataHelper;
import com.extremebozz.skripsi.models.Jamur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JamurAccess extends DataHelper {

    public JamurAccess(Context context) {
        super(context);
    }

    public ArrayList<Jamur> readJamur(){
        ArrayList<Jamur> lJamur = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor jamurCursor;
        jamurCursor = db.rawQuery("SELECT * FROM data_jamur WHERE aktif = 'Y';", null);

        if(jamurCursor.getCount() > 0){
            jamurCursor.moveToFirst();

            do {
                lJamur.add(new Jamur(jamurCursor.getInt(0), jamurCursor.getString(1), jamurCursor.getString(2)));
            }while (jamurCursor.moveToNext());
        }

        jamurCursor.close();
        return lJamur;
    }
}
