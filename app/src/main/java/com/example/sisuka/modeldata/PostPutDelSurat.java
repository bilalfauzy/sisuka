package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

public class PostPutDelSurat {
    @SerializedName("Response")
    Surat surat;

    public Surat getSurat() {
        return surat;
    }

    public void setSurat(Surat surat) {
        this.surat = surat;
    }

}
