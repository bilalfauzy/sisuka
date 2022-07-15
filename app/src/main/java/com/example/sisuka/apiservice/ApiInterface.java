package com.example.sisuka.apiservice;


import com.example.sisuka.modeldata.GetSurat;
import com.example.sisuka.modeldata.PostPutDelSurat;
import com.example.sisuka.modeldata.Surat;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("kelompok5_a1")
    Call<GetSurat> getSuratMasuk();

    @FormUrlEncoded
    @POST("kelompok5_a1")
    Call<PostPutDelSurat> postSurat(@Field("nomor_surat") int nomor_surat,
                                    @Field("tgl_kirim") int tgl_kirim,
                                    @Field("tgl_terima") int tgl_terima,
                                    @Field("penerima") String penerima,
                                    @Field("pengirim") String pengirim,
                                    @Field("perihal") String perihal);
    @FormUrlEncoded
    @PUT("kelompok5_a1")
    Call<PostPutDelSurat> putSurat(@Field("id_surat") int id_surat,
                                   @Field("nomor_surat") int nomor_surat,
                                   @Field("tgl_kirim") int tgl_kirim,
                                   @Field("tgl_terima") int tgl_terima,
                                   @Field("penerima") String penerima,
                                   @Field("pengirim") String pengirim,
                                   @Field("perihal") String perihal);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kelompok5_a1", hasBody = true)
    Call<PostPutDelSurat> delSurat(@Field("id_surat") String id_surat);
}
