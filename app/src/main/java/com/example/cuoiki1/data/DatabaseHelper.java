package com.example.cuoiki1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cuoiky";
    private static final int DATABASE_VERSION = 1;

    public static final String TB_NHANVIEN = "nhanvien";
    public static final String NV_ID = "nv_id";
    public static final String NV_NAME = "name";
    public static final String NV_DATE = "date";
    public static final String NV_QUE = "que";
    public static final String NV_TD = "trinhdo";

    public static final String TB_VITRI = "vitri";
    public static final String VT_ID = "vt_id";
    public static final String VT_NAME = "name";
    public static final String VT_MOTA = "data";

    public static final String TB_PHANCONG = "phancong";
    public static final String PC_ID = "pc_id";
    public static final String PC_NV = "pc_nv_id";
    public static final String PC_VT = "pc_vt_id";
    public static final String PC_TIME = "time";
    public static final String PC_MOTA = "mota";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_nv_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT,%s TEXT)", TB_NHANVIEN, NV_ID, NV_NAME, NV_DATE, NV_QUE, NV_TD);
        db.execSQL(create_nv_table);

        String create_vt_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)", TB_VITRI, VT_ID, VT_NAME, VT_MOTA);
        db.execSQL(create_vt_table);

        String create_pc_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER, %s INTEGER, %s TEXT, %s TEXT)", TB_PHANCONG, PC_ID, PC_NV, PC_VT, PC_TIME, PC_MOTA);
        db.execSQL(create_pc_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
