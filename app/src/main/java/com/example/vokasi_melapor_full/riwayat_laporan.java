package com.example.vokasi_melapor_full;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class riwayat_laporan extends AppCompatActivity {

    private Toolbar backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_laporan);

        // Inisialisasi toolbar
        backButton = findViewById(R.id.backButton);

        // Set listener untuk tombol kembali
        backButton.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke activity_main
                Intent intent = new Intent(riwayat_laporan.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Menutup aktivitas saat ini dari tumpukan aktivitas
            }
        });
    }
}
