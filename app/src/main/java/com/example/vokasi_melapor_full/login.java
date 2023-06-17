package com.example.vokasi_melapor_full;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi elemen UI
        editTextUsername = findViewById(R.id.et_username);
        editTextPassword = findViewById(R.id.et_password);
        buttonLogin = findViewById(R.id.b_login);

        // Menambahkan onClickListener untuk tombol Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Lakukan validasi atau proses login pengguna di sini

        // Contoh validasi sederhana
        if (username.equals("admin") && password.equals("password")) {
            // Login berhasil
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();

            // Lakukan navigasi ke halaman utama setelah login berhasil
            // ...
        } else {
            // Login gagal
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }
}
