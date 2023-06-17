package com.example.vokasi_melapor_full;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class formulir extends AppCompatActivity {

    private EditText inputNama, inputNim, inputJudul, inputLaporan;
    private ExtendedFloatingActionButton fabSend;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir);

        // Inisialisasi elemen UI
        inputNama = findViewById(R.id.inputNama);
        inputNim = findViewById(R.id.inputNim);
        inputJudul = findViewById(R.id.inputJudul);
        inputLaporan = findViewById(R.id.inputLaporan);
        fabSend = findViewById(R.id.fabSend);
        backButton = findViewById(R.id.imageButton);

        // Set listener untuk tombol Kirim
        fabSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToDatabase();
            }
        });

        // Set listener untuk tombol kembali
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke activity_main_menu
                Intent intent = new Intent(formulir.this, MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Menutup aktivitas saat ini dari tumpukan aktivitas
            }
        });
    }

    private void sendToDatabase() {
        // Ambil nilai dari input pengguna
        String nama = inputNama.getText().toString().trim();
        String nim = inputNim.getText().toString().trim();
        String judul = inputJudul.getText().toString().trim();
        String laporan = inputLaporan.getText().toString().trim();

        // Validasi input pengguna
        if (nama.isEmpty() || nim.isEmpty() || judul.isEmpty() || laporan.isEmpty()) {
            Toast.makeText(this, "Harap lengkapi semua field", Toast.LENGTH_SHORT).show();
            return;
        }

        // Buat body JSON untuk dikirim ke database
        String jsonBody = "{\"name\":\"" + nama + "\", \"nim\":\"" + nim + "\", \"title\":\"" + judul + "\", \"message\":\"" + laporan + "\"}";

        // Jalankan permintaan ke server di background menggunakan AsyncTask
        new SendToDatabaseTask(jsonBody).execute();
    }

    private class SendToDatabaseTask extends AsyncTask<Void, Void, Boolean> {
        private String jsonBody;

        public SendToDatabaseTask(String jsonBody) {
            this.jsonBody = jsonBody;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // Buat permintaan HTTP POST menggunakan OkHttp
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(JSON, jsonBody);
            Request request = new Request.Builder()
                    .url("https://ap-southeast-1.aws.data.mongodb-api.com/app/vokasi-melapor-ftvnz/endpoint/post_laporan")
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.isSuccessful();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                // Permintaan berhasil, lakukan tindakan yang sesuai (misalnya menampilkan pesan sukses)
                Toast.makeText(formulir.this, "Data berhasil dikirim", Toast.LENGTH_SHORT).show();
            } else {
                // Permintaan gagal, tangani kesalahan (misalnya menampilkan pesan error)
                Toast.makeText(formulir.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
