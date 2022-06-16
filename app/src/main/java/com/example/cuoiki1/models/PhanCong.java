package com.example.cuoiki1.models;

import java.util.Date;

public class PhanCong {
    private int Id = -1;
    private int Nv_Id;
    private int Vt_Id;
    private String time;
    private String mota;

    public PhanCong() {
    }

    public PhanCong(int id, int nv_Id, int vt_Id, String time, String mota) {
        Id = id;
        Nv_Id = nv_Id;
        Vt_Id = vt_Id;
        this.time = time;
        this.mota = mota;
    }

    public PhanCong(int nv_Id, int vt_Id, String time, String mota) {
        Nv_Id = nv_Id;
        Vt_Id = vt_Id;
        this.time = time;
        this.mota = mota;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNv_Id() {
        return Nv_Id;
    }

    public void setNv_Id(int nv_Id) {
        Nv_Id = nv_Id;
    }

    public int getVt_Id() {
        return Vt_Id;
    }

    public void setVt_Id(int vt_Id) {
        Vt_Id = vt_Id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
