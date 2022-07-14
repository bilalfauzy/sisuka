package com.example.sisuka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sisuka.R;

public class EditActivity extends AppCompatActivity {
    private TextView tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal;
    private Button btnSimpan, btnKembali;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

    }
}

