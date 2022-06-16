package com.example.cuoiki1.models;

public class ThongKeClass {
    private String name;
    private int soLuog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuog() {
        return soLuog;
    }

    public void setSoLuog(int soLuog) {
        this.soLuog = soLuog;
    }

    @Override
    public String toString() {
        return
                "viTri='" + name + '\'' +
                "      soLuog=" + soLuog ;
    }
}
