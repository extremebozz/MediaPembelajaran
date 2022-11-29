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
import com.extremebozz.skripsi.DetailPenyakit;
import com.extremebozz.skripsi.R;
import com.extremebozz.skripsi.models.Jamur;
import com.extremebozz.skripsi.models.JamurPenyakit;

import java.util.ArrayList;

public class JamurPenyakitAdapter extends RecyclerView.Adapter<JamurPenyakitAdapter.ViewHolder> {

    private ArrayList<JamurPenyakit> mData;
    private Context mContext;

    public JamurPenyakitAdapter(Context context, ArrayList<JamurPenyakit> ListPenyakit){
        this.mData = ListPenyakit;
        mContext = context;
    }

    @NonNull
    @Override
    public JamurPenyakitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_penyakit_jamur, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JamurPenyakitAdapter.ViewHolder holder, int position) {
        JamurPenyakit currentPenyakit = mData.get(position);
        holder.bindTo(currentPenyakit);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            JamurPenyakit currentPenyakit = mData.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailPenyakit.class);
            detailIntent.putExtra("Id", currentPenyakit.getID());
            detailIntent.putExtra("Nama", currentPenyakit.getNama());
            detailIntent.putExtra("Deskripsi", currentPenyakit.getDeskripsi());
            detailIntent.putExtra("Penanganan", currentPenyakit.getPenanganan());
            mContext.startActivity(detailIntent);
        }

        private TextView tvNama;

        ViewHolder(View itemView){
            super(itemView);

            // Mencari views
            tvNama = itemView.findViewById(R.id.tvNama);
            itemView.setOnClickListener(this);
        }

        void bindTo(JamurPenyakit currentPenyakit){
            // Isi textview dengan data
            tvNama.setText(currentPenyakit.getNama());
        }
    }
}
