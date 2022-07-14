package com.example.sisuka.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.R;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.SuratViewHolder> {
    @NonNull
    @Override
    public SuratViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SuratViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SuratViewHolder extends RecyclerView.ViewHolder {

        public SuratViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal, tvStatus;
            Button btnEdit, btnHapus;

            tvNoSurat = itemView.findViewById(R.id.tv_no_surat);
            tvPenerima = itemView.findViewById(R.id.tv_penerima);
            tvPengirim = itemView.findViewById(R.id.tv_pengirim);
            tvTglTerima = itemView.findViewById(R.id.tv_tgl_terima);
            tvTglKirim = itemView.findViewById(R.id.tv_tgl_kirim);
            tvPerihal = itemView.findViewById(R.id.tv_perihal);
            tvStatus = itemView.findViewById(R.id.)
        }
    }
}
