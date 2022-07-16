package com.example.sisuka.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.EditActivity;
import com.example.sisuka.R;
import com.example.sisuka.modeldata.Surat;

import java.util.List;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.ViewHolder> {
    List<Surat> mListSurat;

    public ListSuratAdapter(List<Surat> ListSurat){
        mListSurat = ListSurat;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surat_masuk, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Surat surat = mListSurat.get(position);
        holder.tvIdSurat.setText("Id Surat :" +surat.getId_surat());
        holder.tvNoSurat.setText("Nomor Surat :" +surat.getNomor_surat());
        holder.tvPenerima.setText("Penerima :" +surat.getPenerima());
        holder.tvPengirim.setText("Pengirim :" +surat.getPengirim());
        holder.tvTglTerima.setText("Tanggal Terima :" +surat.getTgl_terima());
        holder.tvTglKirim.setText("Tanggal Kirim :" +surat.getTgl_kirim());
        holder.tvPerihal.setText("Perihal :" +surat.getPerihal());
        holder.tvStatus.setText("Status :" +surat.getStatus());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                view.getContext().startActivity(mIntent
                        .putExtra("Id_Surat", surat.getId_surat())
                        .putExtra("Nomor_Surat", surat.getNomor_surat())
                        .putExtra("Penerima", surat.getPenerima())
                        .putExtra("Pengirim", surat.getPengirim())
                        .putExtra("Tanggal_Terima", surat.getTgl_terima())
                        .putExtra("Tanggal_Kirim", surat.getTgl_kirim())
                        .putExtra("Perihal", surat.getPerihal()));
            }
        });
        holder.btnHapus.setOnClickListener(
                view -> Toast.makeText(view.getContext(), "Surat Terhapus", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return mListSurat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIdSurat, tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal, tvStatus;
        public Button btnEdit, btnHapus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvIdSurat = itemView.findViewById(R.id.tv_id_surat1);
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
