package com.example.vokasi_melapor_full;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread() {
            @Override
            public void run() {
//                super.run();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    Intent intent = new Intent(splash_screen.this, MainActivity.class);

                    startActivity(intent);

                    finish();
                }
            }
        };

        timer.start();
    }
}