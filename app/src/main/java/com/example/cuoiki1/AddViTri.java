package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cuoiki1.DAO.DAO;
import com.example.cuoiki1.models.ViTri;
import com.google.android.material.badge.BadgeUtils;

public class AddViTri extends AppCompatActivity {

    TextView addNameVt;
    TextView addMotaVt;
    Button btnSaveVt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vi_tri);

        addNameVt = findViewById(R.id.addNameVt);
        addMotaVt = findViewById(R.id.addMotaVt);
        btnSaveVt = findViewById(R.id.btnSaveVt);

        btnSaveVt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViTri viTri = new ViTri();
                viTri.setName(addNameVt.getText().toString());
                viTri.setMota(addMotaVt.getText().toString());
                System.out.println(viTri.toString());

                DAO dao = new DAO();
                dao.addViTri(viTri, AddViTri.this);
                System.out.println("done");

                Intent intent = new Intent(AddViTri.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}