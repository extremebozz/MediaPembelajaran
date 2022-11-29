package com.extremebozz.skripsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.extremebozz.skripsi.adapter.JamurAdapter;
import com.extremebozz.skripsi.adapter.JamurPenyakitAdapter;
import com.extremebozz.skripsi.dataaccess.JamurAccess;
import com.extremebozz.skripsi.dataaccess.JamurPenyakitAccess;
import com.extremebozz.skripsi.models.Jamur;
import com.extremebozz.skripsi.models.JamurPenyakit;

import java.util.ArrayList;

public class ListPenyakit extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private ArrayList<JamurPenyakit> mPenyakit;
    private JamurPenyakitAdapter mAdapter;

    Integer idTanaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penyakit);

        setStatusBar();

        mRecyclerview = findViewById(R.id.rvListPenyakit);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mPenyakit = new ArrayList<>();

        mAdapter = new JamurPenyakitAdapter(this, mPenyakit);
        mRecyclerview.setAdapter(mAdapter);

        TextView nama = findViewById(R.id.tNama);

        String sNama = getIntent().getStringExtra("Nama");
        idTanaman = getIntent().getIntExtra("IdTanaman", 0);

        nama.setText("Penyakit " + sNama);

        initializeData();
    }

    private void initializeData(){
        JamurPenyakitAccess accessPenyakit = new JamurPenyakitAccess(getApplicationContext());
        ArrayList<JamurPenyakit> lPenyakit = accessPenyakit.readPenyakitById(idTanaman);

        if(lPenyakit.size() > 0){
            mPenyakit.clear();

            for(int i=0;i<lPenyakit.size();i++){
                JamurPenyakit penyakit = lPenyakit.get(i);
                mPenyakit.add(new JamurPenyakit(penyakit.getID(),
                        penyakit.getIdTanaman(),
                        penyakit.getNama(),
                        penyakit.getDeskripsi(),
                        penyakit.getPenanganan()));
            }

            mAdapter.notifyDataSetChanged();
        }
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(true);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
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