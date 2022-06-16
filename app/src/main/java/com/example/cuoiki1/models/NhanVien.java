package com.example.cuoiki1.models;

public class NhanVien {
    private int Id = -1;
    private String name;
    private String date;
    private String que;
    private String trinhDo;

    public NhanVien() {
    }

    public NhanVien(int id, String name, String date, String que, String trinhDo) {
        Id = id;
        this.name = name;
        this.date = date;
        this.que = que;
        this.trinhDo = trinhDo;
    }

    public NhanVien(String name, String date, String que, String trinhDo) {
        this.name = name;
        this.date = date;
        this.que = que;
        this.trinhDo = trinhDo;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString() {
        return
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", que='" + que + '\'' +
                ", trinhDo='" + trinhDo + '\'';
    }
}
