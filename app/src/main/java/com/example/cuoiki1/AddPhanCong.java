package com.example.cuoiki1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cuoiki1.DAO.DAO;
import com.example.cuoiki1.models.HienThi;
import com.example.cuoiki1.models.PhanCong;
import com.example.cuoiki1.models.ThongKeClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class AddPhanCong extends AppCompatActivity {

    TextView addNvId;
    Spinner addVtId;
    TextView addMota;
    Button btnSavePc;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phan_cong);

        DAO dao = new DAO();
        addNvId = findViewById(R.id.addNvId);
        addVtId = findViewById(R.id.addVtId);
        addMota = findViewById(R.id.addMotaPc);
        btnSavePc = findViewById(R.id.btnSavePc);
        listView = findViewById(R.id.listThongKe);

        ArrayList<String> strVtId = dao.getListViTri(AddPhanCong.this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strVtId);
        addVtId.setAdapter(arrayAdapter);

        btnSavePc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                PhanCong phanCong = new PhanCong();
                phanCong.setNv_Id(Integer.parseInt(addNvId.getText().toString()));
                phanCong.setVt_Id(addVtId.getSelectedItemPosition()+1);
                phanCong.setTime(time);
                phanCong.setMota(addMota.getText().toString());

                dao.addPhanCong(phanCong, AddPhanCong.this);
                Intent intent = new Intent(AddPhanCong.this, AddPhanCong.class);
                startActivity(intent);
            }
        });

        ArrayList<HienThi> arrayList = dao.hienThi(AddPhanCong.this);
        ArrayAdapter<HienThi> arrayAdapter1 = new ArrayAdapter<HienThi>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter1);
    }
}