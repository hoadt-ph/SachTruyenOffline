package com.example.sachtruyenoffline.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sachtruyenoffline.R;
import com.example.sachtruyenoffline.adapter.SachAdapter;
import com.example.sachtruyenoffline.adapter.SachHoiKyAdapter;
import com.example.sachtruyenoffline.adapter.SachKhoaHocAdapter;
import com.example.sachtruyenoffline.adapter.SachKinhDoanhAdapter;
import com.example.sachtruyenoffline.adapter.SachTinhYeuAdapter;
import com.example.sachtruyenoffline.database.ListDanhSachDAO;
import com.example.sachtruyenoffline.moder.Sach;
import com.example.sachtruyenoffline.moder.SachHoiky;
import com.example.sachtruyenoffline.moder.SachKhoaHoc;
import com.example.sachtruyenoffline.moder.SachKinhDoanh;
import com.example.sachtruyenoffline.moder.SachTinhyeu;

import java.util.ArrayList;
import java.util.List;


public class FrmSach extends Fragment {
    private List<Sach> sachList;
    private List<SachKhoaHoc> sachListKhoahoc;
    private List<SachKinhDoanh> sachKinhDoanhList;
    private List<SachTinhyeu> sachTinhyeuList;
    private List<SachHoiky> sachHoikyList;
    private ListDanhSachDAO listDanhSachDAO;
    public FrmSach() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_frm_sach, container, false);

//sách tổng hợp

        listDanhSachDAO = new ListDanhSachDAO(getContext());
        sachList = listDanhSachDAO.getALLSach();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rySach);
        SachAdapter sachAdapter = new SachAdapter(getContext(), sachList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(sachAdapter);


//sách khoa học
        listDanhSachDAO = new ListDanhSachDAO(getContext());
        sachListKhoahoc = listDanhSachDAO.getALLSachKhoaHoc();
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.rySachKhoahoc);
        SachKhoaHocAdapter sachAdapter1 = new SachKhoaHocAdapter(getContext(), sachListKhoahoc);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView1.setAdapter(sachAdapter1);

//Sách kinh doanh
        listDanhSachDAO = new ListDanhSachDAO(getContext());
        sachKinhDoanhList = listDanhSachDAO.getALLSachKinhDoanh();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = view.findViewById(R.id.rySachKinhdoanh);
        SachKinhDoanhAdapter sachAdapter2 = new SachKinhDoanhAdapter(getContext(), sachKinhDoanhList);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(sachAdapter2);


        //Sách tình yêu
        listDanhSachDAO = new ListDanhSachDAO(getContext());
        sachTinhyeuList = listDanhSachDAO.getALLSachTinhYeu();
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView3 = view.findViewById(R.id.rySachTinhYeu);
        SachTinhYeuAdapter sachTinhYeuAdapter = new SachTinhYeuAdapter(getContext(), sachTinhyeuList);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        recyclerView3.setAdapter(sachTinhYeuAdapter);


        //Sách hồi ký
        listDanhSachDAO = new ListDanhSachDAO(getContext());
        sachHoikyList = listDanhSachDAO.getALLSachHoiky();
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView4 = view.findViewById(R.id.rySachHoiKy);
        SachHoiKyAdapter sachHoiKyAdapter = new SachHoiKyAdapter(getContext(), sachHoikyList);
        recyclerView4.setLayoutManager(linearLayoutManager4);
        recyclerView4.setAdapter(sachHoiKyAdapter);


        return view;
    }

}
