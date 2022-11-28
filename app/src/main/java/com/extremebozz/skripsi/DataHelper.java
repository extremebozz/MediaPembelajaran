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

        sql = "INSERT INTO data_jamur (id, nama, deskripsi, deskripsi_singkat, aktif) VALUES" +
                " ('1', 'Jamur Tiram', 'Test Tiram', " +
                "'Jamur tiram (Pleurotus ostreatus) adalah jamur pangan dari kelompok Basidiomycota dan termasuk kelas Homobasidiomycetes dengan ciri-ciri umum tubuh buah berwarna putih hingga krem dan tudungnya berbentuk setengah lingkaran mirip cangkang tiram dengan bagian tengah agak cekung.[1] Jamur tiram masih satu kerabat dengan Pleurotus eryngii dan sering dikenal dengan sebutan King Oyster Mushroom.', 'Y')," +
                " ('2', 'Jamur Kuping', '<p><b>Jamur kuping</b> (<i>Auricularia auricula</i>) merupakan salah satu kelompok jelly fungi yang masuk ke dalam kelas Basidiomycota dan mempunyai tekstur jelly yang unik. Fungi yang masuk ke dalam kelas ini umumnya makroskopis atau mudah dilihat dengan mata telanjang. Miseliumnya bersekat dan dapat dibedakan menjadi dua macam yaitu: miselium primer (miselium yang sel-selnya berinti satu, umumnya berasal dari perkembangan basidiospora) dan miselium sekunder (miselium yang sel penyusunnya berinti dua, miselium ini merupakan hasil konjugasi dua miselium primer atau persatuan dua basidiospora). <i>Auricularia auricula</i> umumnya kita kenal sebagai jamur kuping. Jamur ini disebut jamur kuping karena bentuk tubuh buahnya melebar seperti daun telinga manusia (kuping).</p><h2>Karakteristik</h2><hr/><p>Karakteristik dari jamur kuping ini adalah memiliki tubuh buah yang kenyal (mirip gelatin) jika dalam keadaan segar.Namun, pada keadaan kering, tubuh buah dari jamur kuping ini akan menjadi keras seperti tulang. Bagian tubuh buah dari jamur kuping berbentuk seperti mangkuk atau kadang dengan cuping seperti kuping, memiliki diameter 2-15 cm, tipis berdaging, dan kenyal.</p><p>Warna tubuh buah jamur ini pada umumnya hitam atau coklat kehitaman akan tetapi adapula yang memiliki warna coklat tua. Jenis jamur kuping yang paling memiliki nilai bisnis yang tinggi adalah yang memiliki warna coklat pada bagian atas tubuh buah dan warna hitam pada bagian bawah tubuh buah, serta ukuran tubuh buah kecil. Jamur kuping merupakan salah satu jamur konsumsi yang umum dikeringkan terlebih dahulu, kemudian direndam dengan air dalam waktu relatif singkat sehingga jamur ini akan kembali seperti bentuk dan ukuran segarnya.</p><br><h2>Manfaat</h2><br/><ul><li>Mengurangi panas dalam</li><li>Lendir yang dihasilkan dengan dipanaskan dapat berkhasiat sebagai penangkal zat racun yang terbawa dalam makanan.</li><li>Mengatasi penyakit darah tinggi</li><li>Kekurangan darah</li><li>Mengobati penyakit wasir</li></ul>', " +
                "'Jamur kuping (Auricularia auricula) merupakan salah satu kelompok jelly fungi yang masuk ke dalam kelas Basidiomycota dan mempunyai tekstur jelly yang unik.', 'Y')," +
                " ('3', 'Jamur Hitem', 'Test Hitem', " +
                "'Test Tiram', 'Y')," +
                " ('4', 'Jamur Test HTML Tag', '<p><b>Jamur kuping</b> (<i>Auricularia auricula</i>) merupakan salah satu kelompok jelly fungi yang masuk ke dalam kelas Basidiomycota dan mempunyai tekstur jelly yang unik. Fungi yang masuk ke dalam kelas ini umumnya makroskopis atau mudah dilihat dengan mata telanjang. Miseliumnya bersekat dan dapat dibedakan menjadi dua macam yaitu: miselium primer (miselium yang sel-selnya berinti satu, umumnya berasal dari perkembangan basidiospora) dan miselium sekunder (miselium yang sel penyusunnya berinti dua, miselium ini merupakan hasil konjugasi dua miselium primer atau persatuan dua basidiospora). <i>Auricularia auricula</i> umumnya kita kenal sebagai jamur kuping. Jamur ini disebut jamur kuping karena bentuk tubuh buahnya melebar seperti daun telinga manusia (kuping).</p><br/><h2>Karakteristik</h2><hr/><br/><p>Karakteristik dari jamur kuping ini adalah memiliki tubuh buah yang kenyal (mirip gelatin) jika dalam keadaan segar.Namun, pada keadaan kering, tubuh buah dari jamur kuping ini akan menjadi keras seperti tulang. Bagian tubuh buah dari jamur kuping berbentuk seperti mangkuk atau kadang dengan cuping seperti kuping, memiliki diameter 2-15 cm, tipis berdaging, dan kenyal.</p><p>Warna tubuh buah jamur ini pada umumnya hitam atau coklat kehitaman akan tetapi adapula yang memiliki warna coklat tua. Jenis jamur kuping yang paling memiliki nilai bisnis yang tinggi adalah yang memiliki warna coklat pada bagian atas tubuh buah dan warna hitam pada bagian bawah tubuh buah, serta ukuran tubuh buah kecil. Jamur kuping merupakan salah satu jamur konsumsi yang umum dikeringkan terlebih dahulu, kemudian direndam dengan air dalam waktu relatif singkat sehingga jamur ini akan kembali seperti bentuk dan ukuran segarnya.</p><h1>H1</h1><h2>H2</h2><h3>H3</h3>', " +
                "'Test HTML Tag', 'Y');";
        db.execSQL(sql);

        sql = "CREATE TABLE data_penyakit (id INTEGER, id_jamur INTEGER NOT NULL, nama TEXT NOT NULL, deskripsi TEXT NOT NULL, penanganan TEXT NOT NULL, " +
                "aktif INTEGER NOT NULL DEFAULT 'Y', FOREIGN KEY(id_jamur) REFERENCES data_jamur(id), PRIMARY KEY(id));";
        db.execSQL(sql);

        sql = "INSERT INTO data_penyakit (id_jamur, nama, deskripsi, penanganan) VALUES ('1', 'Ulat', 'Ulat merupakan hama yang paling banyak ditemui dalam budidaya jamur tiram. Ada tiga faktor penyebab kemunculan hama ini yaitu faktor kelembaban, kotoran dari sisa pangkal atau bonggol atau tangkai jamur dan jamur yang tidak terpanen, serta lingkungan yang tidak bersih." +
                "Hama ulat muncul ketika kelembaban udara berlebihan. Oleh sebab itu, hama ulat sering dijumpai ketika musim hujan. Pencegahan hama ini adalah dengan mengatur sirkulasi udara. Caranya dengan membuka lubang sirkulasi serta menghentikan sementara proses penyiraman. Jamur yang tidak terpanen akan busuk dan menyebabkan munculnya ulat." +
                "Sebaiknya, ketika melakukan pemanenan, baglog telah dipastikan kebersihannya sehingga tidak ada pangkal atau batang dan jamur yang tidak terpanen. Ulat bisa saja muncul karena rumah kumbung ataupun sekitar kumbung tidak berseih. Misalnya adanya kandang ternak atau tanaman di sekitar rumah kumbung. Untuk mencegah dan mengatasi serangan hama ulat," +
                "lakukan pembersihan rumah kumbung dan sekitar rumah kumbung dengan melakukan penyemprotan formalin.', 'Test Pengobatan')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){}
}
