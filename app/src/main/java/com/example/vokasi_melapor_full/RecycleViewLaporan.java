package com.example.vokasi_melapor_full;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecycleViewLaporan extends RecyclerView.Adapter<RecycleViewLaporan.ViewHolder> {


    private ArrayList<LaporanModels> dataLaporan;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, date, name, nim, message;
        LinearLayout parretLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parretLayout = itemView.findViewById(R.id.list_laporan);
            title = itemView.findViewById(R.id.titleLaporan);
            date = itemView.findViewById(R.id.tvDate1);
            name = itemView.findViewById(R.id.nama_pelapor);
            message = itemView.findViewById(R.id.message_laporan);
            nim = itemView.findViewById(R.id.nim_pelapor);

        }
    }

    public RecycleViewLaporan(ArrayList<LaporanModels> dataLaporan, Context context) {
        this.dataLaporan = dataLaporan;
        this.context = context;
    }

    @NonNull
    @Override
    public RecycleViewLaporan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_laporan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewLaporan.ViewHolder holder, int position) {

        TextView title = holder.title;
        TextView name = holder.name;
        TextView nim = holder.nim;
        TextView message = holder.message;
        TextView tanggal = holder.date;

        title.setText(dataLaporan.get(position).getTitle());
        name.setText("Pelapor : "+dataLaporan.get(position).getName());
        nim.setText("NIM : "+ dataLaporan.get(position).getNim());
        message.setText(dataLaporan.get(position).getMessage());

        String inputDate = dataLaporan.get(position).getDateAt();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = inputFormat.parse(inputDate);
            String outputData = outputFormat.format(date);
            tanggal.setText(outputData);
        } catch (ParseException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        if (dataLaporan == null){
            return 0;
        }
        return dataLaporan.size();
    }


}
