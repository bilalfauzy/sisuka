package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSurat {
    @SerializedName("result")
    List<Surat> listSuratMasuk;

    public List<Surat> getListSuratMasuk() {
        return listSuratMasuk;
    }

    public void setListSuratMasuk(List<Surat> listSuratMasuk) {
        this.listSuratMasuk = listSuratMasuk;
    }
}
