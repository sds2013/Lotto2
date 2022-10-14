package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RecommendActivity extends AppCompatActivity {

    Handler mHandler;
    boolean check =false;
    Button btnStop,btnRe,btnHome;

    int idNumbers[] = {R.id.lotto1, R.id.lotto2, R.id.lotto3, R.id.lotto4, R.id.lotto5, R.id.lotto6};
    // 로또번호 6개를 저장할 번호
    int lottoNums[] = new int[6];

    private void init() {
        for(int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = 0;
        }
    }
    private void makeLottoNumbers() {
        for(int i=0; i<6; i++) {
            lottoNums[i] = (int)(Math.random() * 45) + 1;

            // 중복 번호 제거
            for(int j=0; j<i; j++) {
                if(lottoNums[i] == lottoNums[j]) {
                    i--;
                    break;
                }
            }
        }
    }
    private void sort() {
        int t;
        for(int i = 0; i < 5; i++) {
            for(int j = i; j < 6; j++) {
                if(lottoNums[i] > lottoNums[j]) {
                    t = lottoNums[i];
                    lottoNums[i] = lottoNums[j];
                    lottoNums[j] = t;
                }
            }
        }
    }

    private void fillLottoNumbers() {
        init();
        makeLottoNumbers();
        sort();
        for (int i = 0; i < idNumbers.length; i++) {
            // 위에서 2차원배열에 저장하였던 button의 id로 버튼을 찾아서
            Button lottoNumber = (Button) findViewById(idNumbers[i]);
            String str = "" + lottoNums[i];
            // 버튼에 번호를 표시한다.
            lottoNumber.setText(str);
            // 정수를 문자로 바꾸어
            if(lottoNums[i]>=40){
                lottoNumber.setBackgroundResource(R.drawable.oval_green);
            }
            else if(lottoNums[i]>=30){
                lottoNumber.setBackgroundResource(R.drawable.oval_grey);
            }
            else if(lottoNums[i]>=20){
                lottoNumber.setBackgroundResource(R.drawable.oval_red);
            }
            else if(lottoNums[i]>=10){
                lottoNumber.setBackgroundResource(R.drawable.oval_blue);
            }
            else if(lottoNums[i]>=0){
                lottoNumber.setBackgroundResource(R.drawable.oval_yellow);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        btnStop = (Button)findViewById(R.id.btnStop);
        btnRe = (Button)findViewById(R.id.btnRe);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnStop.setOnClickListener(mClickListener);
        btnRe.setOnClickListener(mClickListener);
        btnHome.setOnClickListener(mClickListener);
        check = true;
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                if(check==true) {
                    fillLottoNumbers();
                }
                mHandler.sendEmptyMessageDelayed(0, 250);
            }
        };
        mHandler.sendEmptyMessage(0);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStop:
                    Toast.makeText(getApplicationContext(), "Lotto 번호를 생성하였습니다.", Toast.LENGTH_SHORT).show();
                    check = false;
                    fillLottoNumbers();
                    break;
                case R.id.btnRe:
                    check = true;
                    break;
                case R.id.btnHome:
                    Intent intent= new Intent(RecommendActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}