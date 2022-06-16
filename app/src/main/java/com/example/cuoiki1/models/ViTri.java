package com.example.cuoiki1.models;

public class ViTri {
    private int Id = -1;
    private String name;
    private String mota;

    public ViTri() {
    }

    public ViTri(int id, String name, String mota) {
        Id = id;
        this.name = name;
        this.mota = mota;
    }

    public ViTri(String name, String mota) {
        this.name = name;
        this.mota = mota;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
