package com.android.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragMonday extends Fragment { //   프래그먼트 상속
    private View view;

    public static FragMonday newInstance(){ // 생성자
        FragMonday fragMonday = new FragMonday(); //  객체 자체로 생성
        return fragMonday; //  어댑터 연결 로직을 위하여
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_monday, container, false); //   프래그 먼트 뷰 가져오는 과정

        return view;
    }
}
