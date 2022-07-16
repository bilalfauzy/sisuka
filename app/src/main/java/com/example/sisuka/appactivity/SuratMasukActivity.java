package com.example.sisuka.appactivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.ClickListener;
import com.example.sisuka.Config;
import com.example.sisuka.R;
import com.example.sisuka.adapter.ListSuratAdapter;
import com.example.sisuka.apiservice.ApiClient;
import com.example.sisuka.apiservice.ApiInterface;
import com.example.sisuka.modeldata.GetSurat;
import com.example.sisuka.modeldata.Surat;
import com.example.sisuka.modeldata.SuratKeluar;

import java.util.List;

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

                listAdapter = new ListSuratAdapter(getApplicationContext(), listSurat, new ClickListener() {
                    @Override
                    public void onPositionClicked(int position) {
                        Toast.makeText(getApplicationContext(), "Downloading..", Toast.LENGTH_SHORT).show();

                        Surat suratMasuk = listSurat.get(position);

                        String namaFile = suratMasuk.getFile_surat();
                        String urlFile = Config.FILE_URL;
                        String urlDownload = urlFile+namaFile;

                        Log.d("link", "link" +urlDownload);
                        if (urlDownload != null){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDownload));
                            startActivity(intent);
                        }
                    }
                });
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
