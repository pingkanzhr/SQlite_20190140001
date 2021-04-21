package com.example.sqlitea.database;

public class Teman {
    String id;
    String nama;
    String telpon;

    public Teman(String id, String nama, String telpon){
        this.id = id;
        this.nama = nama;
        this.telpon = telpon;
    }

    public Teman() {

    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }
}
