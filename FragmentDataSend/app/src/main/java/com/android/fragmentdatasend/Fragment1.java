package com.android.fragmentdatasend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private View view;
    private TextView tv_frag1;
    private Button btn_move;

    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {// 프래그먼트 처음 실행시 수행되는 문
        view = inflater.inflate(R.layout.fragment_1,container,false);

        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null) { // fragment1에 넘겨온 값을 getArguments로 받게 되는대 만약 null값이 아닐경우
            result = getArguments().getString("fromFrag2"); // 번들에 넣어 전달한 fromFrag1 값을 받게 된다
            // 프래그먼트 1으로부터 setArguments된 데이터를 받아온다
            tv_frag1.setText(result); //데이터를 받아온걸 setText를 활용하여 보여준다
        }

        btn_move.setOnClickListener(new View.OnClickListener() { //   프래그먼트 2로 이동
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();// 무언가를 담을 준비를 할수 있는 보따리 같은 개념
                bundle.putString("fromFrag1","안드로이드 프래그먼트");

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction(); // 프래그먼트를 관리하는 역활 (인텐트와 비슷)

                Fragment2 fragment2 = new Fragment2(); // 프래그먼트 2 생성
                fragment2.setArguments(bundle); //bundle에 담은 보따리들을 프래그먼트 2에 넣어주는 역활
                transaction.replace(R.id.frameLayout,fragment2); // startActivity 와 비슷한 생각해도 된다
                // replace(교체할 화면(영역) , 이동할 프래그먼트)

                transaction.commit(); //저장
            }
        });

        return view;
    }
}
