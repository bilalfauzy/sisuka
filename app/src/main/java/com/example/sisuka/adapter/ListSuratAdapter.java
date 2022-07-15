package com.example.sisuka.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.R;
import com.example.sisuka.modeldata.Surat;

import java.util.List;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.SuratViewHolder> {
    List<Surat> mListSurat;

    public ListSuratAdapter(List<Surat> ListSurat){
        mListSurat = ListSurat;
    }

    @NonNull
    @Override
    public SuratViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surat_masuk, parent, false);
        SuratViewHolder suratViewHolder = new SuratViewHolder(mView);
        return suratViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuratViewHolder holder, int position) {
        holder.itemView.g
    }

    @Override
    public int getItemCount() {
        return mListSurat.size();
    }

    public class SuratViewHolder extends RecyclerView.ViewHolder {

        public SuratViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal, tvStatus;
            Button btnEdit, btnHapus;

            tvNoSurat = itemView.findViewById(R.id.tv_no_surat1);
            tvPenerima = itemView.findViewById(R.id.tv_penerima1);
            tvPengirim = itemView.findViewById(R.id.tv_pengirim1);
            tvTglTerima = itemView.findViewById(R.id.tv_tgl_terima1);
            tvTglKirim = itemView.findViewById(R.id.tv_tgl_kirim1);
            tvPerihal = itemView.findViewById(R.id.tv_perihal1);
            tvStatus = itemView.findViewById(R.id.tv_status1);
        }
    }
}
