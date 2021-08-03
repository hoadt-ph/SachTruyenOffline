package com.example.sachtruyenoffline.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachtruyenoffline.R;
import com.example.sachtruyenoffline.activity.ActInformation;
import com.example.sachtruyenoffline.database.SachTruyenSqlite;
import com.example.sachtruyenoffline.moder.SachHoiky;
import com.example.sachtruyenoffline.moder.SachKhoaHoc;
import com.example.sachtruyenoffline.moder.ThongTin;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SachHoiKyAdapter extends RecyclerView.Adapter<SachHoiKyAdapter.MyRecycleview> {
    private Context mContext;
    private List<SachHoiky> sachHoikyList;
    SachTruyenSqlite sachTruyenSqlite;

    public SachHoiKyAdapter(Context mContext, List<SachHoiky> sachHoikyList) {
        this.mContext = mContext;
        this.sachHoikyList = sachHoikyList;
    }

    @NonNull
    @Override
    public MyRecycleview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row_list_sach, parent, false);


        return new MyRecycleview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRecycleview holder, final int position) {
        SachHoiky sachHoiky = sachHoikyList.get(position);
        Picasso.with(mContext).load(sachHoiky.anh).into(holder.anh);
        holder.tv_Name.setText(sachHoikyList.get(position).getNameSach());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ActInformation.class);
                Bundle bundle = new Bundle();
                intent.putExtra("TT", bundle);
                bundle.putString("i", String.valueOf(sachHoikyList.get(position).idName));
                mContext.startActivity(intent);

            }
        });


        if (sachHoikyList.get(position).getLike() == 1) {
            holder.checkBoxLike.setChecked(true);
        } else {
            holder.checkBoxLike.setChecked(false);
        }

        holder.checkBoxLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (holder.checkBoxLike.isChecked()) {
                    sachTruyenSqlite = new SachTruyenSqlite(mContext);
                    SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getReadableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("YeuThich", 1);
                    sqLiteDatabase.update("Name", contentValues, "IDName" + "=?", new String[]{String.valueOf(sachHoikyList.get(position).getIdName())});
                    sqLiteDatabase.close();

                } else {
                    sachTruyenSqlite = new SachTruyenSqlite(mContext);
                    SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getReadableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("YeuThich", 0);
                    sqLiteDatabase.update("Name", contentValues, "IDName" + "=?", new String[]{String.valueOf(sachHoikyList.get(position).getIdName())});
                    sqLiteDatabase.close();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return sachHoikyList.size();

    }

    public class MyRecycleview extends RecyclerView.ViewHolder {
        TextView tv_Name;
        ImageView anh;
        CheckBox checkBoxLike;


        public MyRecycleview(@NonNull View itemView) {
            super(itemView);
            anh = (ImageView) itemView.findViewById(R.id.imgAvataSach);
            tv_Name = (TextView) itemView.findViewById(R.id.tvNamesach);
            checkBoxLike = itemView.findViewById(R.id.btn_like);


        }
    }

}
