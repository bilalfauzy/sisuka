package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSuratKeluar {
    @SerializedName("result")
    List<SuratKeluar> listSuratKeluar;

    public List<SuratKeluar> getListSuratKeluar() {
        return listSuratKeluar;
    }

    public void setListSuratKeluar(List<SuratKeluar> listSuratKeluar) {
        this.listSuratKeluar = listSuratKeluar;
    }
}
