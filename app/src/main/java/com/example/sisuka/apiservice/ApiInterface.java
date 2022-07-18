package com.example.sisuka.apiservice;


import com.example.sisuka.modeldata.GetSurat;
import com.example.sisuka.modeldata.GetSuratKeluar;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //deklarasi method get untuk mengambil data dari getsurat.php dan getsuratkeluar.php yang ada di codeigniter

    @GET("getsurat")
    Call<GetSurat> getSuratMasuk();

    @GET("getsuratkeluar")
    Call<GetSuratKeluar> getSuratKeluar();

}
