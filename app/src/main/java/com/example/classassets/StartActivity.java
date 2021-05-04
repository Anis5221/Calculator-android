package com.example.classassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    int startIntent = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.onClickToStartNewActivity);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    startIntent = 1;
                    finish();

                }

            });



        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(startIntent == 0) {
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 5000);




    }
}