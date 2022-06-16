package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cuoiki1.DAO.DAO;
import com.example.cuoiki1.models.NhanVien;

public class AddNhanVien extends AppCompatActivity {

    TextView nvName;
    TextView nvDate;
    TextView nvQue;
    Spinner nvTd;
    Button btnSaveNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);

        nvName = findViewById(R.id.addName);
        nvDate = findViewById(R.id.addDate);
        nvQue = findViewById(R.id.addQue);
        btnSaveNv = findViewById(R.id.btnSaveNv);

        String[] trinhDo = getResources().getStringArray(R.array.trinh_do);
        nvTd = (Spinner) findViewById(R.id.addTrinhDo);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, trinhDo);
        nvTd.setAdapter(arrayAdapter);

        btnSaveNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NhanVien nhanVien = new NhanVien();
                nhanVien.setName(nvName.getText().toString());
                nhanVien.setDate(nvDate.getText().toString());
                nhanVien.setQue(nvQue.getText().toString());
                nhanVien.setTrinhDo(nvTd.getSelectedItem().toString());
                System.out.println(nhanVien.toString());

                DAO DAO = new DAO();
                DAO.addNhanVien(nhanVien, AddNhanVien.this);
                System.out.println("done");
                Intent intent = new Intent(AddNhanVien.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}