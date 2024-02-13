package com.android.kakaoapi;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtAdress = findViewById(R.id.et_address);
        // block touch

        mEtAdress.setFocusable(false);
        mEtAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //주소 검색 웹뷰 화면으로 이동
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                getSearchResult.launch(intent);

            }
        });


    }
    private final ActivityResultLauncher <Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // 서치 액티비티 로부터 결과 값이 이곳으로 전달 받는다
                if (result.getResultCode() == RESULT_OK) {
                    if(result.getData() != null) { // null 체크
                        String data = result.getData().getStringExtra("data");
                        mEtAdress.setText(data);
                    }
                }
            }
    );

}