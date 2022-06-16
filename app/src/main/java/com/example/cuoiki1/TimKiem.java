package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cuoiki1.DAO.DAO;
import com.example.cuoiki1.models.NhanVien;

import java.util.ArrayList;

public class TimKiem extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);

        DAO dao = new DAO();
        ArrayList<NhanVien> arrayList = dao.searchNhanVien("Nam","1995",TimKiem.this);
        System.out.println(arrayList.toArray());

//        String[] students = {"Nam","Lan","Hoa","Hanh","Thanh",
//                "Trung","Son","Dung","Van","Manh","Thang"};

        listView = findViewById(R.id.listView);
        ArrayAdapter<NhanVien> arrayAdapter = new ArrayAdapter<NhanVien>(this,
                android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

    }
}