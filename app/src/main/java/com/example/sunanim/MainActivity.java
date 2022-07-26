package com.example.sunanim;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Animation upAnim, backFadeIn;
    RelativeLayout layout, yellowBackground;
    AnimationDrawable trans;
    ImageView img;
    Button btnSunRise,btnSunSet;
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.sun);
        layout = (RelativeLayout) findViewById(R.id.layout);
        yellowBackground = (RelativeLayout) findViewById(R.id.yellow_back);

        btnSunRise = findViewById(R.id.btnSunRise);
        btnSunSet = findViewById(R.id.btnSunSet);




        btnSunRise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSunRise();
            }
        });
        btnSunSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSunSet();
            }
        });



    }

    private void makeSunSet() {

        upAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_anim);
        img.startAnimation(upAnim);
        upAnim.setFillAfter(true);

        backFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.background_fadeout);
        yellowBackground.startAnimation(backFadeIn);
    }

    private void makeSunRise() {

        upAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_anim);
        img.startAnimation(upAnim);
        upAnim.setFillAfter(true);

        backFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.background_fadein);
        yellowBackground.startAnimation(backFadeIn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayer = MediaPlayer.create(MainActivity.this, R.raw.morning_fluete);
        mPlayer.start();
        makeSunRise();
    }

    @Override
    protected void onPause() {
        mPlayer.stop();
        super.onPause();
    }
}