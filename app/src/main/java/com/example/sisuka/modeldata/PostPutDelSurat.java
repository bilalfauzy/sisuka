package com.example.sisuka.modeldata;

import com.google.gson.annotations.SerializedName;

public class PostPutDelSurat {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Surat surat;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Surat getSurat() {
        return surat;
    }

    public void setSurat(Surat surat) {
        this.surat = surat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
