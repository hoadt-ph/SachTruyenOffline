package com.example.sachtruyenoffline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sachtruyenoffline.R;

public class ActChao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_chao);
        Thread bamgio= new Thread()
        {
            public void run(){
                try {
                    sleep(1000);

                }
                catch (Exception e){

                }
                finally {
                    Intent intent=new Intent(ActChao.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        };
        bamgio.start();

    }

    public void ActHome(View view) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
