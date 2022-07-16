package com.example.sisuka;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.adapter.ListSuratAdapter;
import com.example.sisuka.apiservice.ApiClient;
import com.example.sisuka.apiservice.ApiInterface;
import com.example.sisuka.modeldata.GetSurat;
import com.example.sisuka.modeldata.Surat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuratMasukActivity extends AppCompatActivity {
    public static SuratMasukActivity sm;
    private RecyclerView rvListSurat;
    private ApiInterface mApiInterface;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_masuk);

        rvListSurat = findViewById(R.id.rv_suratmasuk);
        rvListSurat.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListSurat.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        sm = this;
        refresh();
    }


    public void refresh(){
        Call<GetSurat> getSuratCall = mApiInterface.getSuratMasuk();

        getSuratCall.enqueue(new Callback<GetSurat>() {
            @Override
            public void onResponse(Call<GetSurat> call, Response<GetSurat> response) {
                List<Surat> listSurat =  response.body().getListSuratMasuk();
                listAdapter = new ListSuratAdapter(getApplicationContext(), listSurat);
                rvListSurat.setAdapter(listAdapter);
                Log.d("Retrofit Get", "Jumlah data surat :" +String.valueOf(listSurat.size()));
            }

            @Override
            public void onFailure(Call<GetSurat> call, Throwable t) {
                Log.d("Retrofit Get", t.toString());
            }
        });
    }

}
