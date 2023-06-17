package com.example.vokasi_melapor_full;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class DataLaporan extends AsyncTask<Void, Void, Void> {
    private String message;
    private ArrayList<LaporanModels> laporanModelsArrayList;
    private ListenerLaporan listener;

    public DataLaporan(ListenerLaporan listener) {
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            ApiUrl apiUrl = new ApiUrl();
            String response = apiUrl.getLaporan();

            JSONArray responseArray = new JSONArray(response);

            System.out.println(responseArray);

            laporanModelsArrayList = new ArrayList<>();

            for (int i = 0; i <responseArray.length(); i ++){
                JSONObject obj = new JSONObject(responseArray.getString(i));
                laporanModelsArrayList.add(i, new LaporanModels(
                        obj.getString("_id"),
                        obj.getString("name"),
                        obj.getString("title"),
                        obj.getString("message"),
                        obj.getString("date_at"),
                        obj.getString("nim")));
            }

        } catch (IOException e) {
            this.message = e.getMessage();
        } catch (JSONException e) {
            this.message = e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);

        if(listener != null){
            if (this.message == null){
                this.message = "Success";
            }
            listener.listenerDataLaporan(this.laporanModelsArrayList, this.message);
        }
    }
}
