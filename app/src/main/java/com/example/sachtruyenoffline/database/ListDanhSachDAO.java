package com.example.sachtruyenoffline.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sachtruyenoffline.moder.Sach;
import com.example.sachtruyenoffline.moder.SachHoiky;
import com.example.sachtruyenoffline.moder.SachKhoaHoc;
import com.example.sachtruyenoffline.moder.SachKinhDoanh;
import com.example.sachtruyenoffline.moder.SachTinhyeu;
import com.example.sachtruyenoffline.moder.Search;
import com.example.sachtruyenoffline.moder.Truyen;
import com.example.sachtruyenoffline.moder.TruyenCuoi;
import com.example.sachtruyenoffline.moder.TruyenKiemHiep;
import com.example.sachtruyenoffline.moder.TruyenVietNam;
import com.example.sachtruyenoffline.moder.YeuThich;

import java.util.ArrayList;
import java.util.List;

public class ListDanhSachDAO {

    private SachTruyenSqlite sachTruyenSqlite;

    public ListDanhSachDAO(Context context) {
        this.sachTruyenSqlite = new SachTruyenSqlite(context);

    }

    private String LIST_TABLE = "Name";
    public String ID_NAME = "IDName";
    public String NAME = "NameSach";
    public String STYLES = "Styles";
    public String ANH = "Anh";


    public List<Sach> getALLSach() {
        List<Sach> sachList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
            String SachSQL = "SELECT * FROM Name WHERE Styles = \"Sách tổng hợp\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Sach sach = new Sach();

                    sach.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    sach.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    sach.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    sach.setStyle(cursor.getString(cursor.getColumnIndex(STYLES)));
                    sach.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    sachList.add(sach);
                    cursor.moveToNext();

                }
                cursor.close();
            }

        }
        return  sachList;
    }


    public ArrayList<Search> getALL() {
        ArrayList<Search> searchList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Search search = new Search();

                    search.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    search.setNameSearch(cursor.getString(cursor.getColumnIndex(NAME)));


                    searchList.add(search);
                    cursor.moveToNext();

                }
                cursor.close();
            }

        }
        return  searchList;
    }



    public List<YeuThich> getAllYeuThich() {
        List<YeuThich> yeuThichList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE YeuThich = 1 ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    YeuThich yeuThich = new YeuThich();

                    yeuThich.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    yeuThich.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    yeuThich.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    yeuThich.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));

                    yeuThichList.add(yeuThich);
                    cursor.moveToNext();

                }
                cursor.close();
            }

        }
        return  yeuThichList;
    }


        public List<SachKhoaHoc> getALLSachKhoaHoc(){
            List<SachKhoaHoc> sachKhoaHocList = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
            String SachSQL = "SELECT * FROM Name WHERE Styles = \"Sách khoa học\" ";

            Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

            if(cursor !=null){
                if (cursor.getCount() >0){

                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()){
                        SachKhoaHoc sachKhoaHoc = new SachKhoaHoc();

                        sachKhoaHoc.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                        sachKhoaHoc.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                        sachKhoaHoc.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                        sachKhoaHoc.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                        sachKhoaHoc.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                        sachKhoaHocList.add(sachKhoaHoc);
                        cursor.moveToNext();

                    }
                    cursor.close();
                }
            }
            return sachKhoaHocList;
    }



    public List<SachKinhDoanh> getALLSachKinhDoanh(){
        List<SachKinhDoanh> sachKinhDoanhList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Sách kinh doanh\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    SachKinhDoanh sachKinhDoanh = new SachKinhDoanh();

                    sachKinhDoanh.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    sachKinhDoanh.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    sachKinhDoanh.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    sachKinhDoanh.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    sachKinhDoanh.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    sachKinhDoanhList.add(sachKinhDoanh);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return sachKinhDoanhList;
    }



    public List<SachTinhyeu> getALLSachTinhYeu(){
        List<SachTinhyeu> sachTinhyeuList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Sách tình yêu\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    SachTinhyeu sachTinhyeu = new SachTinhyeu();

                    sachTinhyeu.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    sachTinhyeu.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    sachTinhyeu.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    sachTinhyeu.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    sachTinhyeu.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    sachTinhyeuList.add(sachTinhyeu);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return sachTinhyeuList;
    }

    public List<SachHoiky> getALLSachHoiky(){
        List<SachHoiky> sachHoikyList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Sách hồi ký\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    SachHoiky sachHoiky = new SachHoiky();

                    sachHoiky.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    sachHoiky.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    sachHoiky.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    sachHoiky.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    sachHoiky.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    sachHoikyList.add(sachHoiky);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return sachHoikyList;
    }


    public List<Truyen> getALLTruyen(){
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Truyện tổng hợp\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Truyen truyen = new Truyen();

                    truyen.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    truyen.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    truyen.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    truyen.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    truyen.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    truyenList.add(truyen);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return truyenList;
    }


    public List<TruyenCuoi> getALLTruyencuoi(){
        List<TruyenCuoi> truyenCuoiList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Truyện cười\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    TruyenCuoi truyenCuoi = new TruyenCuoi();

                    truyenCuoi.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    truyenCuoi.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    truyenCuoi.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    truyenCuoi.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    truyenCuoi.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    truyenCuoiList.add(truyenCuoi);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return truyenCuoiList;
    }


    public List<TruyenKiemHiep> getALLTruyenKiemHiep(){
        List<TruyenKiemHiep> truyenKiemHiepList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Truyện kiếm hiệp\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    TruyenKiemHiep truyenKiemHiep = new TruyenKiemHiep();

                    truyenKiemHiep.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    truyenKiemHiep.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    truyenKiemHiep.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    truyenKiemHiep.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    truyenKiemHiep.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    truyenKiemHiepList.add(truyenKiemHiep);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return truyenKiemHiepList;
    }

    public List<TruyenVietNam> getALLTruyenVietNam(){
        List<TruyenVietNam> truyenVietNamList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
        String SachSQL = "SELECT * FROM Name WHERE Styles = \"Truyện Việt Nam\" ";

        Cursor cursor = sqLiteDatabase.rawQuery(SachSQL,null);

        if(cursor !=null){
            if (cursor.getCount() >0){

                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    TruyenVietNam truyenVietNam = new TruyenVietNam();
                    truyenVietNam.setIdName(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID_NAME))));
                    truyenVietNam.setNameSach(cursor.getString(cursor.getColumnIndex(NAME)));
                    truyenVietNam.setAnh(cursor.getString(cursor.getColumnIndex(ANH)));
                    truyenVietNam.setStyles(cursor.getString(cursor.getColumnIndex(STYLES)));
                    truyenVietNam.setLike(Integer.parseInt(cursor.getString(cursor.getColumnIndex("YeuThich"))));

                    truyenVietNamList.add(truyenVietNam);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return truyenVietNamList;
    }
}

