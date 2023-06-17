package com.example.vokasi_melapor_full;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class laporan_terkini extends AppCompatActivity implements ListenerLaporan {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_terkini);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);

        DataLaporan dataLaporan = new DataLaporan(this);
        dataLaporan.execute();

        ImageButton backButton = findViewById(R.id.imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(laporan_terkini.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void listenerDataLaporan(ArrayList<LaporanModels> laporanModels, String message) {
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecycleViewLaporan(laporanModels, this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
