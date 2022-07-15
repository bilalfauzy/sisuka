package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSurat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Surat> listSuratMasuk;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Surat> getListSuratMasuk() {
        return listSuratMasuk;
    }

    public void setListSuratMasuk(List<Surat> listSuratMasuk) {
        this.listSuratMasuk = listSuratMasuk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
