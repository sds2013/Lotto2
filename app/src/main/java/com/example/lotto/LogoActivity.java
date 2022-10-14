package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lotto.MainActivity;
import com.example.lotto.R;

public class LogoActivity extends AppCompatActivity {
    Animation ani1,ani2;
    ImageView ivTest;
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        ivTest = (ImageView)findViewById(R.id.imageView);
        tvTitle = (TextView)findViewById(R.id.tvTitle);

        ivTest = (ImageView)findViewById(R.id.imageView);
        Glide.with(LogoActivity.this).load(R.drawable.scan).into(ivTest);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (LogoActivity.this, MainActivity.class);
                startActivity(intent); //인트로 실행 후 바로 MainActivity로 넘어감.
                finish();
            }
        },2500); //1초 후 인트로 실행
    }
}