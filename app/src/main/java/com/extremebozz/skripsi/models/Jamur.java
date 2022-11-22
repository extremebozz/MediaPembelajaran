package com.extremebozz.skripsi.models;

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
}
