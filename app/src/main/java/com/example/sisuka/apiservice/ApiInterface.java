package com.example.sisuka.apiservice;


import com.example.sisuka.modeldata.GetSurat;
import com.example.sisuka.modeldata.GetSuratKeluar;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getsurat")
    Call<GetSurat> getSuratMasuk();

    @GET("getsuratkeluar")
    Call<GetSuratKeluar> getSuratKeluar();
}
