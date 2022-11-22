package com.extremebozz.skripsi.dataaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.extremebozz.skripsi.DataHelper;
import com.extremebozz.skripsi.models.JamurPenyakit;

import java.util.ArrayList;

public class JamurPenyakitAccess extends DataHelper {

    public JamurPenyakitAccess(Context context) {
        super(context);
    }

    public ArrayList<JamurPenyakit> readPenyakit(){
        ArrayList<JamurPenyakit> listPenyakit = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cPenyakit;
        cPenyakit = db.rawQuery("SELECT * FROM data_penyakit WHERE aktif = 'Y';", null);

        cPenyakit.close();
        return listPenyakit;
    }
}
