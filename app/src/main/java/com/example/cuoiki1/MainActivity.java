package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cuoiki1.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button btnAddNv;
    Button btnAddVt;
    Button btnAddPc;
    Button btnTimKiem;
    Button btnThongke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        btnAddNv = findViewById(R.id.btnThemNv);
        btnAddVt = findViewById(R.id.btnThemVt);
        btnAddPc = findViewById(R.id.btnThemPc);
        btnTimKiem = findViewById(R.id.btnTimkiem);
        btnThongke = findViewById(R.id.btnThongke);

        btnAddNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNhanVien.class);
                startActivity(intent);
            }
        });

        btnAddVt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddViTri.class);
                startActivity(intent);
            }
        });

        btnAddPc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPhanCong.class);
                startActivity(intent);
            }
        });

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimKiem.class);
                startActivity(intent);
            }
        });

        btnThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongKe.class);
                startActivity(intent);
            }
        });

    }
}