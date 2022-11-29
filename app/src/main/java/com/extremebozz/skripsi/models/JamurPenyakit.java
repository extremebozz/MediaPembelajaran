package com.extremebozz.skripsi.models;

public class JamurPenyakit {
    private Integer id;
    private Integer idTanaman;
    private String nama;
    private String deskripsi;
    private String penanganan;

    public JamurPenyakit(Integer Id, Integer IdTanaman, String Nama, String Deskripsi, String Penanganan){
        this.id = Id;
        this.idTanaman = IdTanaman;
        this.nama = Nama;
        this.deskripsi = Deskripsi;
        this.penanganan = Penanganan;
    }

    public Integer getID() { return id; }
    public Integer getIdTanaman() { return idTanaman; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getPenanganan() { return penanganan; }
}
