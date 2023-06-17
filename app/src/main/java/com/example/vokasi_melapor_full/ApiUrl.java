package com.example.vokasi_melapor_full;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiUrl {

    private static  final OkHttpClient httpClient = new OkHttpClient();

    public static String getLaporan() throws IOException {

        Request request = new Request.Builder()
                .url("https://ap-southeast-1.aws.data.mongodb-api.com/app/vokasi-melapor-ftvnz/endpoint/get_laporan ")
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        String responseData = response.body().string();
        response.close();

        return responseData;
    }
}
