package com.extremebozz.skripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailJamur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jamur);

        TextView nama = findViewById(R.id.tNama);
        TextView deskripsi = findViewById(R.id.tDeskripsi);

        String sNama = getIntent().getStringExtra("Nama");
        String sDeskripsi = getIntent().getStringExtra("Deskripsi");

        nama.setText(sNama);
        deskripsi.setText(sDeskripsi);
    }
}