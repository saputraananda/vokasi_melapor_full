package com.example.vokasi_melapor_full;

public class LaporanModels {
    private String id;
    private String name;
    private String title;
    private String message;
    private String dateAt;
    private String nim;

    public LaporanModels(String id, String name, String title, String message, String dateAt, String nim) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.message = message;
        this.dateAt = dateAt;
        this.nim = nim;
    }

    public String getDateAt() {
        return dateAt;
    }

    public void setDateAt(String dateAt) {
        this.dateAt = dateAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
