package com.example.sisuka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.R;
import com.example.sisuka.modeldata.SuratKeluar;

import java.util.List;

public class ListSuratKeluarAdapter extends RecyclerView.Adapter<ListSuratKeluarAdapter.ViewHolder> {
    private List<SuratKeluar> mListSuratKeluar;
    private Context context;

    public ListSuratKeluarAdapter(Context mContext, List<SuratKeluar> ListSuratKeluar){
        context = mContext;
        mListSuratKeluar = ListSuratKeluar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surat_keluar, parent, false);
        return new ListSuratKeluarAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SuratKeluar suratKeluar = mListSuratKeluar.get(position);
        holder.tvIdSuratK.setText("ID Surat\t\t: " +suratKeluar.getId_suratkeluar());
        holder.tvNoSuratK.setText("Nomor Surat\t: " +suratKeluar.getNomor_suratkeluar());
        holder.tvPenerimaK.setText("Penerima\t\t: " +suratKeluar.getPenerimask());
        holder.tvPengirimK.setText("Pengirim\t\t: " +suratKeluar.getPengirimsk());
        holder.tvTglKirimK.setText("Tanggal Kirim\t: " +suratKeluar.getTgl_kirimsk());
        holder.tvPerihalK.setText("Perihal\t\t: " +suratKeluar.getPerihalsk());
        holder.tvFileSuratK.setText("File Surat\t\t: " +suratKeluar.getFile_suratkeluar());
        holder.btnDownloadK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Downloading", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListSuratKeluar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIdSuratK, tvNoSuratK, tvPenerimaK, tvPengirimK, tvTglKirimK, tvPerihalK, tvFileSuratK;
        public Button btnDownloadK;

        public ViewHolder(View itemView) {
            super(itemView);
            tvIdSuratK = itemView.findViewById(R.id.tv_id_surat2);
            tvNoSuratK = itemView.findViewById(R.id.tv_no_surat2);
            tvPenerimaK = itemView.findViewById(R.id.tv_penerima2);
            tvPengirimK = itemView.findViewById(R.id.tv_pengirim2);
            tvTglKirimK = itemView.findViewById(R.id.tv_tgl_kirim2);
            tvPerihalK = itemView.findViewById(R.id.tv_perihal2);
            tvFileSuratK = itemView.findViewById(R.id.tv_file_surat2);

            btnDownloadK = itemView.findViewById(R.id.btnDownload2);
        }
    }
}
