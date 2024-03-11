package com.example.wethernow.splachscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wethernow.R;
import com.example.wethernow.activities.ActivityMainDnipro;

public class SplachScreen extends AppCompatActivity {

    private static int SPLACH_SCREEN_DELAY = 3000;

    Handler handler = new Handler();
    private Object Window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);



        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

        ImageView imageView = findViewById(R.id.textviewsplachscreen);
        TextView textView = findViewById(R.id.textviewanimation);

        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplachScreen.this, ActivityMainDnipro.class);
                startActivity(intent);
                finish();


                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<>(textView, "logo_text");
                pairs[1] = new Pair<>(imageView, "image_logo");

            }
        },SPLACH_SCREEN_DELAY);


    }
}