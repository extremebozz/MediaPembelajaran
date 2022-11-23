package com.extremebozz.skripsi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.extremebozz.skripsi.DetailJamur;
import com.extremebozz.skripsi.R;
import com.extremebozz.skripsi.models.Jamur;

import java.util.ArrayList;

public class JamurAdapter extends RecyclerView.Adapter<JamurAdapter.ViewHolder> {
    private ArrayList<Jamur> mJamursData;
    private Context mContext;

    public JamurAdapter(Context context, ArrayList<Jamur> transactionData){
        this.mJamursData = transactionData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public JamurAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_jamur, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JamurAdapter.ViewHolder holder, int position) {
        Jamur currentJamur = mJamursData.get(position);
        holder.bindTo(currentJamur);
    }

    @Override
    public int getItemCount() {
        return mJamursData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Jamur currentJamur = mJamursData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailJamur.class);
            detailIntent.putExtra("Id", currentJamur.getID());
            detailIntent.putExtra("Nama", currentJamur.getNama());
            detailIntent.putExtra("Deskripsi", currentJamur.getDeskripsi());
            mContext.startActivity(detailIntent);
        }

        private TextView lNama;
        private TextView lDeskripsi;
        private ImageView ivJamur;

        ViewHolder(View itemView){
            super(itemView);

            // Mencari views
            lNama = itemView.findViewById(R.id.tvNama);
            lDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            ivJamur = itemView.findViewById(R.id.ivJamur);

            itemView.setOnClickListener(this);
        }

        void bindTo(Jamur currentJamur){
            // Isi textview dengan data
            lNama.setText(currentJamur.getNama());
            lDeskripsi.setText(currentJamur.getDeskripsiSingkat());
            Jamur.getGambar(ivJamur, currentJamur.getNama());
        }
    }
}
