package com.example.cuoiki1.models;

public class HienThi {
    private String name;
    private String vitri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                "      vitri=" + vitri ;
    }
}
