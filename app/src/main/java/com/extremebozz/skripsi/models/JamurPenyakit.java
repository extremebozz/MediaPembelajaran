package com.extremebozz.skripsi.models;

public class JamurPenyakit {
    private Integer id;
    private Integer idTanaman;
    private String nama;
    private String deskripsi;

    public JamurPenyakit(Integer Id, Integer IdTanaman, String Nama, String Deskripsi){
        this.id = Id;
        this.idTanaman = IdTanaman;
        this.nama = Nama;
        this.deskripsi = Deskripsi;
    }

    public Integer getID() { return id; }
    public Integer getIdTanama() { return idTanaman; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
}
