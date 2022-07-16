package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

public class Surat {
    @SerializedName("id_surat")
    private int id_surat;
    @SerializedName("nomor_surat")
    private int nomor_surat;
    @SerializedName("tgl_kirim")
    private String tgl_kirim;
    @SerializedName("tgl_terima")
    private String tgl_terima;
    @SerializedName("pengirim")
    private String pengirim;
    @SerializedName("penerima")
    private String penerima;
    @SerializedName("perihal")
    private String perihal;
    @SerializedName("file_surat")
    private String file_surat;
    @SerializedName("status")
    private String status;

    public Surat(){}

    public Surat(int id_surat, int nomor_surat, String tgl_kirim, String tgl_terima, String pengirim, String penerima, String perihal, String file_surat, String status) {
        this.id_surat = id_surat;
        this.nomor_surat = nomor_surat;
        this.tgl_kirim = tgl_kirim;
        this.tgl_terima = tgl_terima;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.perihal = perihal;
        this.file_surat = file_surat;
        this.status = status;
    }

    public int getId_surat() {
        return id_surat;
    }

    public void setId_surat(int id_surat) {
        this.id_surat = id_surat;
    }

    public int getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(int nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public String getTgl_kirim() {
        return tgl_kirim;
    }

    public void setTgl_kirim(String tgl_kirim) {
        this.tgl_kirim = tgl_kirim;
    }

    public String getTgl_terima() {
        return tgl_terima;
    }

    public void setTgl_terima(String tgl_terima) {
        this.tgl_terima = tgl_terima;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getPerihal() {
        return perihal;
    }

    public void setPerihal(String perihal) {
        this.perihal = perihal;
    }

    public String getFile_surat() {
        return file_surat;
    }

    public void setFile_surat(String file_surat) {
        this.file_surat = file_surat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
