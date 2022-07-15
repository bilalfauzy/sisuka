package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSurat {
    @SerializedName("Response")
    List<Surat> listSurat;

    public List<Surat> getListSuratMasuk() {
        return listSurat;
    }

    public void setListSuratMasuk(List<Surat> listSurat) {
        this.listSurat = listSurat;
    }

}
