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
import com.example.sisuka.modeldata.Surat;
import com.example.sisuka.modeldata.SuratKeluar;

import java.util.List;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.ViewHolder> {
    private List<Surat> mListSurat;
    private Context context;

    public ListSuratAdapter(Context mContext, List<Surat> ListSurat){
        context = mContext;
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
        holder.tvIdSurat.setText("Id Surat\t\t: " +surat.getId_surat());
        holder.tvNoSurat.setText("Nomor Surat\t: " +surat.getNomor_surat());
        holder.tvPenerima.setText("Penerima\t\t: " +surat.getPenerima());
        holder.tvPengirim.setText("Pengirim\t\t: " +surat.getPengirim());
        holder.tvTglTerima.setText("Tanggal Terima\t: " +surat.getTgl_terima());
        holder.tvTglKirim.setText("Tanggal Kirim\t: " +surat.getTgl_kirim());
        holder.tvPerihal.setText("Perihal\t\t: " +surat.getPerihal());
        holder.tvStatus.setText("Status\t\t: " +surat.getStatus());
        holder.tvFileSurat.setText("File Surat\t\t: " +surat.getFile_surat());

        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Downloading", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListSurat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvIdSurat, tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal, tvStatus, tvFileSurat;
        public Button btnDownload;

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
            tvFileSurat = itemView.findViewById(R.id.tv_file_surat1);

            btnDownload = itemView.findViewById(R.id.btnDownload1);
        }
    }
}
