package com.extremebozz.skripsi.models;

public class Jamur {
    private Integer id;
    private String nama;
    private String deskripsi;

    public Jamur(Integer Id, String Nama, String Deskripsi){
        this.id = Id;
        this.nama = Nama;
        this.deskripsi = Deskripsi;
    }

    public Integer getID() { return id; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
}
