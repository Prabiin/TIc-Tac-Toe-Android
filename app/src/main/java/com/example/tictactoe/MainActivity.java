package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    Animation xAnimation, oAnimation, smileNoseAnimation, tagLineAnimation;

    ImageView circle, cross;

    TextView nose, smile, tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        xAnimation = AnimationUtils.loadAnimation(this, R.anim.xanimation);
        oAnimation = AnimationUtils.loadAnimation(this, R.anim.oanimation);
        smileNoseAnimation = AnimationUtils.loadAnimation(this, R.anim.smilenoseanimation);
        tagLineAnimation = AnimationUtils.loadAnimation(this, R.anim.taglineanimation);

        cross = findViewById(R.id.cross);
        circle = findViewById(R.id.circle);
        nose = findViewById(R.id.nose);
        smile = findViewById(R.id.smile);
        tagline = findViewById(R.id.tagline);

        cross.setAnimation(xAnimation);
        circle.setAnimation(oAnimation);
        nose.setAnimation(smileNoseAnimation);
        smile.setAnimation(smileNoseAnimation);
        tagline.setAnimation(tagLineAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
