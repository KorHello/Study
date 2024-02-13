package com.android.fragmentdatasend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment1 fragment1 = new Fragment1(); // 프래그먼트 1 생성
        transaction.replace(R.id.frameLayout,fragment1); // startActivity 와 비슷한 생각해도 된다
        // replace(교체할 화면(영역) , 이동할 프래그먼트)

        transaction.commit(); //저장

    }
}