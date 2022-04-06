package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
                            implements View.OnTouchListener
{
    ImageView black;
    ImageView red;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        black = findViewById(R.id.touch);

        black.setOnTouchListener(this);

    }

    float x, y;
    float dx, dy;


    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (v == black)
        {
            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();

                case MotionEvent.ACTION_MOVE:
                    dx = event.getX() - x;
                    dy = event.getY() - y;

                    black.setX(black.getX() + dx);
                    black.setY(black.getY() + dy);

                    x = event.getX();
                    y = event.getY();
            }
            return true;

        }
        return false;

    }
}