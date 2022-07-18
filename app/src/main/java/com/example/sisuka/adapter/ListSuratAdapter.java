package com.example.sisuka.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.ClickListener;
import com.example.sisuka.Config;
import com.example.sisuka.R;
import com.example.sisuka.modeldata.Surat;
import com.example.sisuka.modeldata.SuratKeluar;

import java.lang.ref.WeakReference;
import java.util.List;

public class ListSuratAdapter extends RecyclerView.Adapter<ListSuratAdapter.ViewHolder> {
    private List<Surat> mListSurat;
    private Context context;
    private final ClickListener clickListener;

    public ListSuratAdapter(Context mContext, List<Surat> ListSurat, ClickListener clickListener){
        context = mContext;
        mListSurat = ListSurat;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ViewHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surat_masuk, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //menempelkan data list surat ke recyclerview

        Surat surat = mListSurat.get(position);
        holder.tvIdSurat.setText("ID Surat: " +surat.getId_surat());
        holder.tvNoSurat.setText("Nomor Surat: " +surat.getNomor_surat());
        holder.tvPenerima.setText("Penerima: " +surat.getPenerima());
        holder.tvPengirim.setText("Pengirim: " +surat.getPengirim());
        holder.tvTglTerima.setText("Tanggal Terima: " +surat.getTgl_terima());
        holder.tvTglKirim.setText("Tanggal Kirim: " +surat.getTgl_kirim());
        holder.tvPerihal.setText("Perihal: " +surat.getPerihal());
        holder.tvStatus.setText("Status: " +surat.getStatus());
        holder.tvFileSurat.setText("File Surat: " +surat.getFile_surat());
        holder.tvDownFile.setText("Download file surat");

    }

    @Override
    public int getItemCount() {
        return mListSurat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvIdSurat, tvNoSurat, tvPenerima, tvPengirim, tvTglTerima, tvTglKirim, tvPerihal, tvStatus, tvFileSurat, tvDownFile;
        public Button btnDownload;
        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(View itemView, ClickListener clickListener) {
            super(itemView);

            listenerRef = new WeakReference<>(clickListener);
            tvIdSurat = itemView.findViewById(R.id.tv_id_surat1);
            tvNoSurat = itemView.findViewById(R.id.tv_no_surat1);
            tvPenerima = itemView.findViewById(R.id.tv_penerima1);
            tvPengirim = itemView.findViewById(R.id.tv_pengirim1);
            tvTglTerima = itemView.findViewById(R.id.tv_tgl_terima1);
            tvTglKirim = itemView.findViewById(R.id.tv_tgl_kirim1);
            tvPerihal = itemView.findViewById(R.id.tv_perihal1);
            tvStatus = itemView.findViewById(R.id.tv_status1);
            tvFileSurat = itemView.findViewById(R.id.tv_file_surat1);
            tvDownFile = itemView.findViewById(R.id.tv_downfile1);

            btnDownload = itemView.findViewById(R.id.btnDownload1);
            btnDownload.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnDownload.getId()){
            }
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}
