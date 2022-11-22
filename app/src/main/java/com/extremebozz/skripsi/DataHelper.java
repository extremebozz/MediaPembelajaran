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

        sql = "CREATE TABLE data_jamur (id INTEGER, nama TEXT NOT NULL, deskripsi TEXT NOT NULL, deskripsi_singkat TEXT NOT NULL," +
                "aktif TEXT NOT NULL DEFAULT 'Y', PRIMARY KEY(id));";
        db.execSQL(sql);

        sql = "INSERT INTO data_jamur (id, nama, deskripsi, deskripsi_singkat, aktif) VALUES ('1', 'Jamur Tiram', 'Test Tiram', 'Jamur tiram (Pleurotus ostreatus) adalah jamur pangan dari kelompok Basidiomycota dan termasuk kelas Homobasidiomycetes dengan ciri-ciri umum tubuh buah berwarna putih hingga krem dan tudungnya berbentuk setengah lingkaran mirip cangkang tiram dengan bagian tengah agak cekung.[1] Jamur tiram masih satu kerabat dengan Pleurotus eryngii dan sering dikenal dengan sebutan King Oyster Mushroom.', 'Y')," +
                " ('2', 'Jamur Telinga', 'Test Telinga', 'Test Tiram', 'Y'), ('3', 'Jamur Hitem', 'Test Hitem', 'Test Tiram', 'Y');";
        db.execSQL(sql);

        sql = "CREATE TABLE data_penyakit (id INTEGER, id_jamur INTEGER NOT NULL, nama TEXT NOT NULL, deskripsi TEXT NOT NULL," +
                "aktif INTEGER NOT NULL DEFAULT 'Y', FOREIGN KEY(id_jamur) REFERENCES data_jamur(id), PRIMARY KEY(id));";
        db.execSQL(sql);

        sql = "INSERT INTO data_penyakit (id_jamur, nama, deskripsi) VALUES ('1', 'Ulat', 'Ulat merupakan hama yang paling banyak ditemui dalam budidaya jamur tiram. Ada tiga faktor penyebab kemunculan hama ini yaitu faktor kelembaban, kotoran dari sisa pangkal atau bonggol atau tangkai jamur dan jamur yang tidak terpanen, serta lingkungan yang tidak bersih." +
                "Hama ulat muncul ketika kelembaban udara berlebihan. Oleh sebab itu, hama ulat sering dijumpai ketika musim hujan. Pencegahan hama ini adalah dengan mengatur sirkulasi udara. Caranya dengan membuka lubang sirkulasi serta menghentikan sementara proses penyiraman. Jamur yang tidak terpanen akan busuk dan menyebabkan munculnya ulat." +
                "Sebaiknya, ketika melakukan pemanenan, baglog telah dipastikan kebersihannya sehingga tidak ada pangkal atau batang dan jamur yang tidak terpanen. Ulat bisa saja muncul karena rumah kumbung ataupun sekitar kumbung tidak berseih. Misalnya adanya kandang ternak atau tanaman di sekitar rumah kumbung. Untuk mencegah dan mengatasi serangan hama ulat," +
                "lakukan pembersihan rumah kumbung dan sekitar rumah kumbung dengan melakukan penyemprotan formalin.')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){}
}
