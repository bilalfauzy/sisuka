package com.example.sisuka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sisuka.ClickListener;
import com.example.sisuka.R;
import com.example.sisuka.modeldata.SuratKeluar;

import java.lang.ref.WeakReference;
import java.util.List;

public class ListSuratKeluarAdapter extends RecyclerView.Adapter<ListSuratKeluarAdapter.ViewHolder> {
    private List<SuratKeluar> mListSuratKeluar;
    private Context context;
    private final ClickListener clickListener;

    public ListSuratKeluarAdapter(Context mContext, List<SuratKeluar> ListSuratKeluar, ClickListener clickListener){
        context = mContext;
        mListSuratKeluar = ListSuratKeluar;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surat_keluar, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SuratKeluar suratKeluar = mListSuratKeluar.get(position);
        holder.tvIdSuratK.setText("ID Surat: " +suratKeluar.getId_suratkeluar());
        holder.tvNoSuratK.setText("Nomor Surat: " +suratKeluar.getNomor_suratkeluar());
        holder.tvPenerimaK.setText("Penerima: " +suratKeluar.getPenerimask());
        holder.tvPengirimK.setText("Pengirim: " +suratKeluar.getPengirimsk());
        holder.tvTglKirimK.setText("Tanggal Kirim: " +suratKeluar.getTgl_kirimsk());
        holder.tvPerihalK.setText("Perihal: " +suratKeluar.getPerihalsk());
        holder.tvFileSuratK.setText("File Surat: " +suratKeluar.getFile_suratkeluar());
        holder.tvDownFileK.setText("Download file surat");
    }

    @Override
    public int getItemCount() {
        return mListSuratKeluar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvIdSuratK, tvNoSuratK, tvPenerimaK, tvPengirimK, tvTglKirimK, tvPerihalK, tvFileSuratK, tvDownFileK;
        public Button btnDownloadK;
        private WeakReference<ClickListener> listenerRef;


        public ViewHolder(View itemView, ClickListener clickListener) {
            super(itemView);

            listenerRef = new WeakReference<>(clickListener);
            tvIdSuratK = itemView.findViewById(R.id.tv_id_surat2);
            tvNoSuratK = itemView.findViewById(R.id.tv_no_surat2);
            tvPenerimaK = itemView.findViewById(R.id.tv_penerima2);
            tvPengirimK = itemView.findViewById(R.id.tv_pengirim2);
            tvTglKirimK = itemView.findViewById(R.id.tv_tgl_kirim2);
            tvPerihalK = itemView.findViewById(R.id.tv_perihal2);
            tvFileSuratK = itemView.findViewById(R.id.tv_file_surat2);
            tvDownFileK = itemView.findViewById(R.id.tv_downfile2);

            btnDownloadK = itemView.findViewById(R.id.btnDownload2);
            btnDownloadK.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnDownloadK.getId()){}
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}
