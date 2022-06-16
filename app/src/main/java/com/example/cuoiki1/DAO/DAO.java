package com.example.cuoiki1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.contentcapture.ContentCaptureCondition;

import com.example.cuoiki1.ThongKe;
import com.example.cuoiki1.data.DatabaseHelper;
import com.example.cuoiki1.models.HienThi;
import com.example.cuoiki1.models.NhanVien;
import com.example.cuoiki1.models.PhanCong;
import com.example.cuoiki1.models.ThongKeClass;
import com.example.cuoiki1.models.ViTri;

import java.util.ArrayList;

public class DAO {
    public void addNhanVien(NhanVien nhanVien, Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.NV_NAME, nhanVien.getName());
        contentValues.put(databaseHelper.NV_DATE, nhanVien.getDate());
        contentValues.put(databaseHelper.NV_QUE, nhanVien.getQue());
        contentValues.put(databaseHelper.NV_TD, nhanVien.getTrinhDo());

        db.insert(databaseHelper.TB_NHANVIEN, null, contentValues);
        db.close();
        databaseHelper.close();

    }

    public void addViTri(ViTri viTri, Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.VT_NAME, viTri.getName());
        contentValues.put(databaseHelper.VT_MOTA, viTri.getMota());

        db.insert(databaseHelper.TB_VITRI, null, contentValues);
        db.close();
        databaseHelper.close();
    }

    public ArrayList<String> getListViTri(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        String sql = "SELECT "+databaseHelper.VT_NAME+" FROM "+databaseHelper.TB_VITRI;

        Cursor cs = db.rawQuery(sql, null);
        System.out.println("danh");
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            System.out.println("danh    " +cs.getString(0));
            arrayList.add(cs.getString(0));
            cs.moveToNext();
        }

        return arrayList;

    }

    public void addPhanCong(PhanCong phanCong, Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.PC_NV, phanCong.getNv_Id());
        contentValues.put(databaseHelper.PC_VT, phanCong.getVt_Id());
        contentValues.put(databaseHelper.PC_TIME, phanCong.getTime());
        contentValues.put(databaseHelper.PC_MOTA, phanCong.getMota());

        db.insert(databaseHelper.TB_PHANCONG, null, contentValues);
        db.close();
        databaseHelper.close();
    }

    public ArrayList<NhanVien> searchNhanVien(String name, String date, Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ArrayList<NhanVien> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM "+databaseHelper.TB_NHANVIEN+" WHERE name like \"%"+name+"\" and date = \""+date+"\"";

        Cursor cs = db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(cs.getInt(0));
            nhanVien.setName(cs.getString(1));
            nhanVien.setDate(cs.getString(2));
            nhanVien.setQue(cs.getString(3));
            nhanVien.setTrinhDo(cs.getString(4));

            arrayList.add(nhanVien);
            cs.moveToNext();
        }

        return arrayList;
    }

    //SELECT vitri.name , count(phancong.pc_id) FROM phancong
    // INNER JOIN vitri on vitri.vt_id = phancong.pc_vt_id
    // GROUP by phancong.pc_vt_id ORDER by count(phancong.pc_id) DESC
    public ArrayList<ThongKeClass> thongKe(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ArrayList<ThongKeClass> arrayList = new ArrayList<>();
        String sql = "SELECT vitri.name , count(phancong.pc_id) FROM phancong INNER JOIN vitri on vitri.vt_id = phancong.pc_vt_id GROUP by phancong.pc_vt_id ORDER by count(phancong.pc_id) DESC";

        Cursor cs = db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            ThongKeClass thongKe = new ThongKeClass();
            thongKe.setName(cs.getString(0));
            thongKe.setSoLuog(cs.getInt(1));

            arrayList.add(thongKe);
            cs.moveToNext();
        }

        return arrayList;
    }

//  SELECT nhanvien.name, vitri.name FROM phancong
//  INNER JOIN vitri on vitri.vt_id = phancong.pc_vt_id
//  INNER JOIN nhanvien on nhanvien.nv_id = phancong.pc_nv_id
//  ORDER by vitri.vt_id
    public ArrayList<HienThi> hienThi(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ArrayList<HienThi> arrayList = new ArrayList<>();
        String sql = "SELECT nhanvien.name, vitri.name FROM phancong " +
                "INNER JOIN vitri on vitri.vt_id = phancong.pc_vt_id " +
                "INNER JOIN nhanvien on nhanvien.nv_id = phancong.pc_nv_id " +
                "ORDER by vitri.vt_id";

        Cursor cs = db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            HienThi hienThi = new HienThi();
            hienThi.setName(cs.getString(0));
            hienThi.setVitri(cs.getString(1));

            arrayList.add(hienThi);
            cs.moveToNext();
        }

        return arrayList;
    }

}
