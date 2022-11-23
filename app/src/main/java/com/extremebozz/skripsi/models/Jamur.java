package com.extremebozz.skripsi.models;

import android.widget.ImageView;

import com.extremebozz.skripsi.R;

public class Jamur {
    private Integer id;
    private String nama;
    private String dSingkat;
    private String deskripsi;

    public Jamur(Integer Id, String Nama, String Deskripsi, String DSingkat){
        this.id = Id;
        this.nama = Nama;
        this.deskripsi = Deskripsi;
        this.dSingkat = DSingkat;
    }

    public Integer getID() { return id; }
    public String getNama() { return nama; }
    public String getDeskripsiSingkat() { return dSingkat; }
    public String getDeskripsi() { return deskripsi; }
    public static ImageView getGambar(ImageView ivJamur, String Jamur) {
        //ImageView ivJamur = IJamur;

        switch (Jamur){
            case "Jamur Tiram":
                ivJamur.setImageResource(R.drawable.jamur_tiram);
                break;

            case "Jamur Kuping":
                ivJamur.setImageResource(R.drawable.jamur_kuping);
                break;

            default:
                ivJamur.setImageResource(R.drawable.jamur_placeholder);
                break;
        }

        return ivJamur;
        //return IJamur;
    }
}
