package com.example.lotto;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnQR).setOnClickListener(mClick);
        findViewById(R.id.btnLotto).setOnClickListener(mClick);
        findViewById(R.id.btnList).setOnClickListener(mClick);

}

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnQR:
                    Intent ex1 = new Intent(MainActivity.this, ScannerActivity.class);
                    startActivity(ex1);
                    break;
                case R.id.btnLotto:
                    Intent ex2 = new Intent(MainActivity.this, RecommendActivity.class);
                    startActivity(ex2);
                    break;
                case R.id.btnList:
                    Intent ex3= new Intent(MainActivity.this, LogoActivity.class);
                    startActivity(ex3);
                    break;
            }
        }
    };
}