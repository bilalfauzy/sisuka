package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

public class SuratKeluar {
    @SerializedName("id_surat")
    private int id_suratkeluar;
    @SerializedName("nomor_surat")
    private int nomor_suratkeluar;
    @SerializedName("tgl_kirim")
    private String tgl_kirimsk;
    @SerializedName("pengirim")
    private String pengirimsk;
    @SerializedName("penerima")
    private String penerimask;
    @SerializedName("perihal")
    private String perihalsk;
    @SerializedName("file_surat")
    private String file_suratkeluar;

    SuratKeluar(){}

    public SuratKeluar(int id_suratkeluar, int nomor_suratkeluar, String tgl_kirimsk, String pengirimsk, String penerimask, String perihalsk, String file_suratkeluar) {
        this.id_suratkeluar = id_suratkeluar;
        this.nomor_suratkeluar = nomor_suratkeluar;
        this.tgl_kirimsk = tgl_kirimsk;
        this.pengirimsk = pengirimsk;
        this.penerimask = penerimask;
        this.perihalsk = perihalsk;
        this.file_suratkeluar = file_suratkeluar;
    }

    public int getId_suratkeluar() {
        return id_suratkeluar;
    }

    public void setId_suratkeluar(int id_suratkeluar) {
        this.id_suratkeluar = id_suratkeluar;
    }

    public int getNomor_suratkeluar() {
        return nomor_suratkeluar;
    }

    public void setNomor_suratkeluar(int nomor_suratkeluar) {
        this.nomor_suratkeluar = nomor_suratkeluar;
    }

    public String getTgl_kirimsk() {
        return tgl_kirimsk;
    }

    public void setTgl_kirimsk(String tgl_kirimsk) {
        this.tgl_kirimsk = tgl_kirimsk;
    }

    public String getPengirimsk() {
        return pengirimsk;
    }

    public void setPengirimsk(String pengirimsk) {
        this.pengirimsk = pengirimsk;
    }

    public String getPenerimask() {
        return penerimask;
    }

    public void setPenerimask(String penerimask) {
        this.penerimask = penerimask;
    }

    public String getPerihalsk() {
        return perihalsk;
    }

    public void setPerihalsk(String perihalsk) {
        this.perihalsk = perihalsk;
    }

    public String getFile_suratkeluar() {
        return file_suratkeluar;
    }

    public void setFile_suratkeluar(String file_suratkeluar) {
        this.file_suratkeluar = file_suratkeluar;
    }
}
