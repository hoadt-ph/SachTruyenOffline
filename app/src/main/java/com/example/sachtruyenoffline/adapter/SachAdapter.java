package com.example.sachtruyenoffline.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sachtruyenoffline.R;
import com.example.sachtruyenoffline.activity.ActInformation;
import com.example.sachtruyenoffline.database.SachTruyenSqlite;
import com.example.sachtruyenoffline.moder.Sach;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SachAdapter extends RecyclerView.Adapter<SachAdapter.MyRecycleview> {
    private SachTruyenSqlite sachTruyenSqlite;
    SharedPreferences sharedPreferences;
    private Context mContext;
    private List<Sach> sachList;
    AlertDialog.Builder builder;



    public SachAdapter(Context mContext, List<Sach> sachList) {
        this.mContext = mContext;
        this.sachList = sachList;
    }

    @NonNull
    @Override
    public MyRecycleview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        final LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row_list_sach, parent, false);


        return new MyRecycleview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRecycleview holder, final int position) {

        final Sach sach = sachList.get(position);
        holder.tv_Name.setText(sachList.get(position).getNameSach());
        Picasso.with(mContext).load(sach.anh).into(holder.anh);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ActInformation.class);
                Bundle bundle = new Bundle();
                bundle.putString("i", String.valueOf(sachList.get(position).idName));
                intent.putExtra("TT", bundle);
                mContext.startActivity(intent);
            }
        });
        if (sachList.get(position).getLike() == 1) {
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
                            sqLiteDatabase.update("Name", contentValues, "IDName" + "=?", new String[]{String.valueOf(sachList.get(position).getIdName())});
                            sqLiteDatabase.close();

                } else {

                    builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("Xóa khỏi danh sách yêu thích ?")
                            .setCancelable(false).setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sachTruyenSqlite = new SachTruyenSqlite(mContext);
                            SQLiteDatabase sqLiteDatabase = sachTruyenSqlite.getReadableDatabase();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("YeuThich", 0);
                            sqLiteDatabase.update("Name", contentValues, "IDName" + "=?", new String[]{String.valueOf(sachList.get(position).getIdName())});
                            sqLiteDatabase.close();

                        }
                    }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            holder.checkBoxLike.setChecked(true);
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert1 = builder.create();
                    alert1.setTitle("Yêu thích");
                    alert1.show();



                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class MyRecycleview extends RecyclerView.ViewHolder {
        TextView tv_Name;
        ImageView anh;
        CheckBox checkBoxLike;


        public MyRecycleview(@NonNull View itemView) {
            super(itemView);
            anh = (ImageView) itemView.findViewById(R.id.imgAvataSach);
            tv_Name = (TextView) itemView.findViewById(R.id.tvNamesach);
            checkBoxLike = (CheckBox) itemView.findViewById(R.id.btn_like);
        }
    }

}
