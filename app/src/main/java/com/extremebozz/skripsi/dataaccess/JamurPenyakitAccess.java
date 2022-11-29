package com.extremebozz.skripsi.dataaccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.extremebozz.skripsi.DataHelper;
import com.extremebozz.skripsi.models.Jamur;
import com.extremebozz.skripsi.models.JamurPenyakit;

import java.util.ArrayList;

public class JamurPenyakitAccess extends DataHelper {

    public JamurPenyakitAccess(Context context) {
        super(context);
    }

    public ArrayList<JamurPenyakit> readPenyakit(){
        ArrayList<JamurPenyakit> lPenyakit = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cPenyakit;
        cPenyakit = db.rawQuery("SELECT * FROM data_penyakit WHERE aktif = 'Y';", null);

        if(cPenyakit.getCount() > 0){
            cPenyakit.moveToFirst();

            do {
                lPenyakit.add(new JamurPenyakit(cPenyakit.getInt(0),
                        cPenyakit.getInt(1),
                        cPenyakit.getString(2),
                        cPenyakit.getString(3),
                        cPenyakit.getString(4)));
            }while (cPenyakit.moveToNext());
        }

        cPenyakit.close();
        return lPenyakit;
    }

    public ArrayList<JamurPenyakit> readPenyakitById(int IdTanaman){
        ArrayList<JamurPenyakit> lPenyakit = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        int idTanaman = IdTanaman;

        Cursor cPenyakit;
        cPenyakit = db.rawQuery("SELECT * FROM data_penyakit WHERE id_jamur = '" + idTanaman + "' AND aktif = 'Y';", null);

        if(cPenyakit.getCount() > 0){
            cPenyakit.moveToFirst();

            do {
                lPenyakit.add(new JamurPenyakit(cPenyakit.getInt(0),
                        cPenyakit.getInt(1),
                        cPenyakit.getString(2),
                        cPenyakit.getString(3),
                        cPenyakit.getString(4)));
            }while (cPenyakit.moveToNext());
        }

        cPenyakit.close();
        return lPenyakit;
    }
}
