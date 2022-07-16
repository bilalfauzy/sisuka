package com.example.sisuka;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.adapter.ListSuratAdapter;
import com.example.sisuka.adapter.ListSuratKeluarAdapter;
import com.example.sisuka.apiservice.ApiClient;
import com.example.sisuka.apiservice.ApiInterface;
import com.example.sisuka.modeldata.GetSuratKeluar;
import com.example.sisuka.modeldata.SuratKeluar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SuratKeluarActivity extends AppCompatActivity {
    public static SuratKeluarActivity sk;
    private RecyclerView rvListSuratKeluar;
    private ApiInterface mApiInterface;
    private RecyclerView.Adapter listAdapterK;
    private RecyclerView.LayoutManager mLayoutManagerK;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_keluar);

        rvListSuratKeluar = findViewById(R.id.rv_suratkeluar);
        rvListSuratKeluar.setHasFixedSize(true);

        mLayoutManagerK = new LinearLayoutManager(this);
        rvListSuratKeluar.setLayoutManager(mLayoutManagerK);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        sk = this;
        refresh();
    }

    private void refresh() {
        Call<GetSuratKeluar> getSuratKeluarCall = mApiInterface.getSuratKeluar();
        getSuratKeluarCall.enqueue(new Callback<GetSuratKeluar>() {
            @Override
            public void onResponse(Call<GetSuratKeluar> call, Response<GetSuratKeluar> response) {
                List<SuratKeluar> listSuratKeluar =  response.body().getListSuratKeluar();
                listAdapterK = new ListSuratKeluarAdapter(getApplicationContext(), listSuratKeluar);
                rvListSuratKeluar.setAdapter(listAdapterK);
                Log.d("Retrofit Get", "Jumlah data surat :" +String.valueOf(listSuratKeluar.size()));
            }

            @Override
            public void onFailure(Call<GetSuratKeluar> call, Throwable t) {
                Log.d("Retrofit Get", t.toString());
            }
        });
    }
}
