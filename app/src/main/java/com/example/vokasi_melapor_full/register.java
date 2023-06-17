package com.example.vokasi_melapor_full;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    private EditText editTextName, editTextNim, editTextPassword, editTextConfirmPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi elemen UI
        editTextName = findViewById(R.id.et_nama);
        editTextNim = findViewById(R.id.et_nim);
        editTextPassword = findViewById(R.id.et_password);
        editTextConfirmPassword = findViewById(R.id.et_ulangipassword);
        buttonRegister = findViewById(R.id.b_daftar);

        // Menambahkan onClickListener untuk tombol Register
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = editTextName.getText().toString();
        String nim = editTextNim.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        // Lakukan validasi atau proses pendaftaran pengguna di sini

        // Contoh validasi sederhana
        if (name.isEmpty() || nim.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Konfirmasi password tidak sesuai", Toast.LENGTH_SHORT).show();
        } else {
            // Proses pendaftaran pengguna
            // ...

            Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();

            // Lakukan navigasi ke halaman lain setelah pendaftaran berhasil
            // ...
        }
    }
}
