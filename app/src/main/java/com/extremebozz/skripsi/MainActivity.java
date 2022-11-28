package com.extremebozz.skripsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.extremebozz.skripsi.adapter.JamurAdapter;
import com.extremebozz.skripsi.dataaccess.JamurAccess;
import com.extremebozz.skripsi.models.Jamur;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataHelper dHelper;

    private RecyclerView mRecyclerview;
    private ArrayList<Jamur> mJamurData;
    private JamurAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusBar();

        //Buat referensi Recycler View
        mRecyclerview = findViewById(R.id.rvListJamur);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mJamurData = new ArrayList<>();

        mAdapter = new JamurAdapter(this, mJamurData);
        mRecyclerview.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData(){
        JamurAccess jamurAccess = new JamurAccess(getApplicationContext());
        ArrayList<Jamur> lJamur = jamurAccess.readJamur();

        if(lJamur.size() > 0){
            mJamurData.clear();

            for(int i=0;i<lJamur.size();i++){
                Jamur jamur = lJamur.get(i);
                mJamurData.add(new Jamur(jamur.getID(), jamur.getNama(), jamur.getDeskripsi(), jamur.getDeskripsiSingkat()));
            }

            mAdapter.notifyDataSetChanged();
        }
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(true);
        }
    }
}