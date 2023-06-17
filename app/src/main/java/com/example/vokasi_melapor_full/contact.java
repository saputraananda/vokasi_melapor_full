package com.example.vokasi_melapor_full;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan saat ImageButton ditekan
                Intent intent = new Intent(contact.this, MainActivity.class);
                startActivity(intent);
                finish(); // Opsional: Menutup Activity saat ini setelah berpindah ke MainActivity
            }
        });

        ImageView logoWhatsapp1 = findViewById(R.id.logowhatsapp1);
        logoWhatsapp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan saat logoWhatsapp1 ditekan
                String url = "https://wa.me/6281231141569";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageView logoWhatsapp2 = findViewById(R.id.logowhatsapp2);
        logoWhatsapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan saat logoWhatsapp2 ditekan
                String url = "https://wa.me/6281510903663";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        ImageView logoInstagram1 = findViewById(R.id.logoinstagram1);
        logoInstagram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan saat logoInstagram1 ditekan
                String url = "https://www.instagram.com/sekolahvokasiipb/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageView logoInstagram2 = findViewById(R.id.logoinstagram2);
        logoInstagram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kode yang akan dijalankan saat logoInstagram2 ditekan
                String url = "https://www.instagram.com/bemsvipb/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}