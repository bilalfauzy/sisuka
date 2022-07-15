package com.example.sisuka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.apiservice.ApiClient;
import com.example.sisuka.apiservice.ApiInterface;
import com.example.sisuka.modeldata.PostPutDelSurat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal;
    private Button btnSimpan, btnKembali;
    private EditText etNoSurat, etPenerima, etPengirim, etTglTerima, etTglKirim, etPerihal;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        getView();

        btnSimpan.setOnClickListener(this);
        btnKembali.setOnClickListener(this);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    private void getView() {
        tvNoSurat = findViewById(R.id.tv_no_surat2);
        tvPenerima = findViewById(R.id.tv_penerima2);
        tvPengirim = findViewById(R.id.tv_pengirim2);
        tvTglTerima = findViewById(R.id.tv_tgl_terima2);
        tvTglKirim = findViewById(R.id.tv_tgl_kirim2);
        tvPerihal = findViewById(R.id.tv_perihal2);

        etNoSurat = findViewById(R.id.et_no_surat2);
        etPenerima = findViewById(R.id.et_penerima2);
        etPengirim = findViewById(R.id.et_pengirim2);
        etTglTerima = findViewById(R.id.et_tgl_terima2);
        etTglKirim = findViewById(R.id.et_tgl_kirim2);
        etPerihal = findViewById(R.id.et_perihal2);

        btnSimpan = findViewById(R.id.btnSimpan2);
        btnKembali = findViewById(R.id.btnKembali2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSimpan2:
                Call<PostPutDelSurat> postSuratCall = mApiInterface.postSurat(
                        Integer.parseInt(etNoSurat.getText().toString()),
                        Integer.parseInt(etTglKirim.getText().toString()),
                        Integer.parseInt(etTglTerima.getText().toString()),
                        etPenerima.getText().toString(),
                        etPengirim.getText().toString(),
                        etPerihal.getText().toString()
                        );
                postSuratCall.enqueue(new Callback<PostPutDelSurat>() {
                    @Override
                    public void onResponse(Call<PostPutDelSurat> call, Response<PostPutDelSurat> response) {
                        SuratMasukActivity.sm.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelSurat> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnKembali2:
                onBackPressed();
                break;
        }
    }
}
