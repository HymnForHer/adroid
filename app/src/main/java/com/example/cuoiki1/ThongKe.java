package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cuoiki1.DAO.DAO;
import com.example.cuoiki1.models.ThongKeClass;

import java.util.ArrayList;

public class ThongKe extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        listView = findViewById(R.id.listThongKe);
        DAO dao = new DAO();

        ArrayList<ThongKeClass> arrayList = dao.thongKe(ThongKe.this);
        ArrayAdapter<ThongKeClass> arrayAdapter = new ArrayAdapter<ThongKeClass>(this,
                android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

    }
}