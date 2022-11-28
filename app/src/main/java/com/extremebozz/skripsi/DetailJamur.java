package com.extremebozz.skripsi;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.extremebozz.skripsi.models.Jamur;

public class DetailJamur extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jamur);

        setStatusBar();

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        TextView nama = findViewById(R.id.tNama);
        TextView deskripsi = findViewById(R.id.tDeskripsi);
        ImageView gambar = findViewById(R.id.ivJamur);

        String sNama = getIntent().getStringExtra("Nama");
        String sDeskripsi = getIntent().getStringExtra("Deskripsi");

        nama.setText(sNama);
        deskripsi.setText(Html.fromHtml(sDeskripsi, Html.FROM_HTML_MODE_COMPACT));

        Jamur.getGambar(gambar, sNama);

        setTitle(sNama);

        Button bListPenyakit = findViewById(R.id.bListPenyakit);

        bListPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailJamur.this, ListPenyakit.class);
                startActivity(intent);
            }
        });
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}