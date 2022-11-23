package com.extremebozz.skripsi;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.extremebozz.skripsi.models.Jamur;

public class DetailJamur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jamur);

        //Tampilkan back button di actionbar
        //getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView nama = findViewById(R.id.tNama);
        TextView deskripsi = findViewById(R.id.tDeskripsi);
        ImageView gambar = findViewById(R.id.ivJamur);

        String sNama = getIntent().getStringExtra("Nama");
        String sDeskripsi = getIntent().getStringExtra("Deskripsi");

        nama.setText(sNama);
        deskripsi.setText(Html.fromHtml(sDeskripsi, Html.FROM_HTML_MODE_COMPACT));

        Jamur.getGambar(gambar, sNama);

        setTitle(sNama);
    }
}