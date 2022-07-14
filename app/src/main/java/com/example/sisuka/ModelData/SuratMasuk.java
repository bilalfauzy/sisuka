package com.example.sisuka.ModelData;

import com.google.gson.annotations.SerializedName;

public class SuratMasuk {
    private int id_surat;

    public int getId_surat() {
        return id_surat;
    }

    public void setId_surat(int id_surat) {
        this.id_surat = id_surat;
    }

    public String getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(String nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public int getTgl_kirim() {
        return tgl_kirim;
    }

    public void setTgl_kirim(int tgl_kirim) {
        this.tgl_kirim = tgl_kirim;
    }

    public int getTgl_terima() {
        return tgl_terima;
    }

    public void setTgl_terima(int tgl_terima) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String nomor_surat;
    private int tgl_kirim;
    private int tgl_terima;
    private String pengirim;
    private String penerima;
    private String perihal;
    private String status;
}
