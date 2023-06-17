package com.example.vokasi_melapor_full;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvBuatLaporan, cvRiwayatLaporan, cvLaporanTerkini, cvVokasi911, cvTentangAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Find CardViews by their IDs
        cvBuatLaporan = findViewById(R.id.cvbuatlaporan);
        cvLaporanTerkini = findViewById(R.id.cvlaporanterkinisv);
        cvVokasi911 = findViewById(R.id.cvvokasi911);
        cvTentangAplikasi = findViewById(R.id.cvtentangaplikasi);

        // Set click listeners for CardViews
        cvBuatLaporan.setOnClickListener(this);
        cvLaporanTerkini.setOnClickListener(this);
        cvVokasi911.setOnClickListener(this);
        cvTentangAplikasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Handle click events for CardViews
        Intent intent;
        switch (v.getId()) {
            case R.id.cvbuatlaporan:
//                // Handle click for 'Buat Laporan' CardView
                intent = new Intent(MainActivity.this, formulir.class);
                startActivity(intent);
                break;
            case R.id.cvlaporanterkinisv:
                // Handle click for 'Laporan Terkini SV' CardView
                intent = new Intent(MainActivity.this, laporan_terkini.class);
                startActivity(intent);
                break;
            case R.id.cvvokasi911:
//                // Handle click for 'Vokasi 911' CardView
                intent = new Intent(MainActivity.this, contact.class);
                startActivity(intent);
                break;
            case R.id.cvtentangaplikasi:
//                // Handle click for 'Tentang Aplikasi' CardView
                intent = new Intent(MainActivity.this, about_app.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
