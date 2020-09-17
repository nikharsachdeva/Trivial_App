package com.nikharsachdeva.triviaapp.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.nikharsachdeva.triviaapp.MainActivity;
import com.nikharsachdeva.triviaapp.R;

public class SplashScreen extends AppCompatActivity {

    ImageView splash_icon;
    Animation hold, translateScale;
    private boolean isFirstAnimation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
        setupAnimations();
        startAnimation();
    }

    private void startAnimation() {
        splash_icon.startAnimation(hold);
    }

    private void setupAnimations() {
        hold = AnimationUtils.loadAnimation(this, R.anim.hold);

        /* Translates ImageView from current position to its original position, scales it from
        larger scale to its original scale.*/
        translateScale = AnimationUtils.loadAnimation(this, R.anim.translate_scale);
        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splash_icon.clearAnimation();
                splash_icon.startAnimation(translateScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        translateScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isFirstAnimation) {
                    splash_icon.clearAnimation();
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                isFirstAnimation = true;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void init() {
        splash_icon = findViewById(R.id.splash_icon);
    }
}