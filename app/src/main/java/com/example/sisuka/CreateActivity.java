package com.example.sisuka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {
    private TextView tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal;
    private Button btnSimpan, btnKembali;
    private EditText etNoSurat, etPenerima, etPengirim, etTglTerima, etTglKirim, etPerihal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        tvNoSurat = findViewById(R.id.tv_no_surat);
        tvPenerima = findViewById(R.id.tv_penerima);
        tvPengirim = findViewById(R.id.tv_pengirim);
        tvTglTerima = findViewById(R.id.tv_tgl_terima);
        tvTglKirim = findViewById(R.id.tv_tgl_kirim);
        tvPerihal = findViewById(R.id.tv_perihal);

        etNoSurat = findViewById(R.id.et_no_surat);
        etPenerima = findViewById(R.id.et_penerima);
        etPengirim = findViewById(R.id.et_pengirim);
        etTglTerima = findViewById(R.id.et_tgl_terima);
        etTglKirim = findViewById(R.id.et_tgl_kirim);
        etPerihal = findViewById(R.id.et_perihal);

        btnSimpan = findViewById(R.id.btnSimpan);
        btnKembali = findViewById(R.id.btnKembali);

    }
}
