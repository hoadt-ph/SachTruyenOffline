package com.example.sachtruyenoffline.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.example.sachtruyenoffline.R;
import com.example.sachtruyenoffline.adapter.MyFragmentAdapter;
import com.example.sachtruyenoffline.adapter.SearchAdapter;
import com.example.sachtruyenoffline.database.ListDanhSachDAO;
import com.example.sachtruyenoffline.database.SachTruyenSqlite;
import com.example.sachtruyenoffline.fragment.FrmSach;
import com.example.sachtruyenoffline.fragment.FrmTruyen;
import com.example.sachtruyenoffline.fragment.FrmYeuthich;
import com.example.sachtruyenoffline.moder.Sach;
import com.example.sachtruyenoffline.moder.Search;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrmYeuthich frmYeuthich;
    private SearchAdapter searchAdapter;
    private ArrayList<Search> inputList;
    private AutoCompleteTextView autoCompleteTextView;
    private ListDanhSachDAO listDanhSachDAO;
    SachTruyenSqlite sachTruyenSqlite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sachTruyenSqlite = new SachTruyenSqlite(this);
        sachTruyenSqlite.createDataBase();

        autoCompleteTextView = findViewById(R.id.edtSearch);
        listDanhSachDAO = new ListDanhSachDAO(this);

        inputList = listDanhSachDAO.getALL();

        searchAdapter = new SearchAdapter(this, R.layout.auto_item, inputList);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(searchAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = String.valueOf(autoCompleteTextView.getText()) ;
                Log.d("name", name);

                SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getWritableDatabase();
                String SachSQL = "SELECT IDName FROM Name Where NameSach ="+ "\"" + name + "\"";

                Cursor cursor = sqLiteDatabase.rawQuery(SachSQL, null);

                if (cursor != null) {
                    if (cursor.getCount() > 0) {

                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            String idName = cursor.getString(cursor.getColumnIndex("IDName"));
                            Intent intent = new Intent(Main2Activity.this, ActInformation.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("i", idName);
                            intent.putExtra("TT", bundle);
                            startActivity(intent);

                            cursor.moveToNext();

                        }
                        cursor.close();
                    }

                }
            }
        });


        tabLayout = findViewById(R.id.tabHome);
        viewPager = findViewById(R.id.viewPagerHome);
        final MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new FrmSach(), "Sách");
        adapter.addFragment(new FrmTruyen(), "Truyện");
        adapter.addFragment(new FrmYeuthich(), "Yêu thích");

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {

                    FrmYeuthich.reload();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }



}

