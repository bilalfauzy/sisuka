package com.example.sisuka.modeldata;

public class Surat {
    private int id_surat;
    private int nomor_surat;
    private int tgl_kirim;
    private int tgl_terima;
    private String pengirim;
    private String penerima;
    private String perihal;
    private String status;
    private String file_surat;

    Surat(){}

    public Surat(int id_surat, int nomor_surat, int tgl_kirim, int tgl_terima, String pengirim, String penerima, String perihal, String status, String file_surat) {
        this.id_surat = id_surat;
        this.nomor_surat = nomor_surat;
        this.tgl_kirim = tgl_kirim;
        this.tgl_terima = tgl_terima;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.perihal = perihal;
        this.status = status;
        this.file_surat = file_surat;
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

    public String getFile_surat() {
        return file_surat;
    }

    public void setFile_surat(String file_surat) {
        this.file_surat = file_surat;
    }
}