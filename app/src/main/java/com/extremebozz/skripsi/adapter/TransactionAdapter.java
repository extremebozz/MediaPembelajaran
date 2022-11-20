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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private ArrayList<Jamur> mJamursData;
    private Context mContext;

    public TransactionAdapter(Context context, ArrayList<Jamur> transactionData){
        this.mJamursData = transactionData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_jamur, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
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
            detailIntent.putExtra("ID", currentJamur.getID());
            detailIntent.putExtra("Nama", currentJamur.getNama());
            detailIntent.putExtra("Deskripsi", currentJamur.getDeskripsi());
            mContext.startActivity(detailIntent);
        }

        //private ImageView iIcon;
        private TextView lId;
        private TextView lNama;
        private TextView lDeskripsi;

        ViewHolder(View itemView){
            super(itemView);

            // Initialize the views.
            lId = itemView.findViewById(R.id.tId);
            lNama = itemView.findViewById(R.id.tNama);
            lDeskripsi = itemView.findViewById(R.id.tDeskripsi);
            //iIcon = itemView.findViewById(R.id.iIcon);

            itemView.setOnClickListener(this);
        }

        void bindTo(Jamur currenJamur){
            // Populate the textviews with data.
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            DecimalFormat dFormatter = new DecimalFormat("#,##0");
        }
    }
}
