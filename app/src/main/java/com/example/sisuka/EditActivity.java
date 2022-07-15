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

import com.example.sisuka.R;
import com.example.sisuka.apiservice.ApiClient;
import com.example.sisuka.apiservice.ApiInterface;
import com.example.sisuka.modeldata.PostPutDelSurat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
    private TextView tvIdSurat, tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal;
    private Button btnSimpan, btnKembali;
    private EditText etIdSurat, etNoSurat, etPenerima, etPengirim, etTglTerima, etTglKirim, etPerihal;
    private ApiInterface mApiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getView();

        Intent mIntent = getIntent();
        etIdSurat.setText(mIntent.getStringExtra("Id_Surat"));
        etIdSurat.setTag(etIdSurat.getKeyListener());
        etIdSurat.setKeyListener(null);

        etNoSurat.setText(mIntent.getIntExtra("Nomor_Surat", 0));
        etPenerima.setText(mIntent.getStringExtra("Penerima"));
        etPengirim.setText(mIntent.getStringExtra("Pengirim"));
        etTglTerima.setText(mIntent.getIntExtra("Tanggal_Terima", 0));
        etTglKirim.setText(mIntent.getIntExtra("Tanggal_Kirim", 0));
        etPerihal.setText(mIntent.getStringExtra("Perihal"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuratMasukActivity.sm.refresh();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelSurat> updateSuratCall = mApiInterface.putSurat(
                        Integer.parseInt(etIdSurat.getText().toString()),
                        Integer.parseInt(etNoSurat.getText().toString()),
                        Integer.parseInt(etTglKirim.getText().toString()),
                        Integer.parseInt(etTglTerima.getText().toString()),
                        etPenerima.getText().toString(),
                        etPengirim.getText().toString(),
                        etPerihal.getText().toString()
                        );

                updateSuratCall.enqueue(new Callback<PostPutDelSurat>() {
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
            }
        });

    }

    private void getView() {
        tvIdSurat = findViewById(R.id.tv_id_surat3);
        tvNoSurat = findViewById(R.id.tv_no_surat3);
        tvPenerima = findViewById(R.id.tv_penerima3);
        tvPengirim = findViewById(R.id.tv_pengirim3);
        tvTglTerima = findViewById(R.id.tv_tgl_terima3);
        tvTglKirim = findViewById(R.id.tv_tgl_kirim3);
        tvPerihal = findViewById(R.id.tv_perihal3);

        etIdSurat = findViewById(R.id.et_id_surat3);
        etNoSurat = findViewById(R.id.et_no_surat3);
        etPenerima = findViewById(R.id.et_penerima3);
        etPengirim = findViewById(R.id.et_pengirim3);
        etTglTerima = findViewById(R.id.et_tgl_terima3);
        etTglKirim = findViewById(R.id.et_tgl_kirim3);
        etPerihal = findViewById(R.id.et_perihal3);

        btnSimpan = findViewById(R.id.btnSimpan3);
        btnKembali = findViewById(R.id.btnKembali3);
    }
}

