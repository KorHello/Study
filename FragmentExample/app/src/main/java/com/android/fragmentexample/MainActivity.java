package com.android.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //프래그먼트는  xml레이아웃 파일 하나랑 자바소스 파일 하나로 정의할 수 있다.
    //이게 하나의 뷰처럼 쓸 수 있는데 뷰하고 약간 다른특성들이 있다.
    //엑티비티를 본떠 만들었기 떄문에 프래그먼트 매니저가 소스코드에서 담당한다.
    MainFragment mainfragment;
    MenuFragment menufragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프래그먼트는 뷰와 다르게 context를 매개변수로 넣어줄 필요가 없다.
        mainfragment = new MainFragment();
        menufragment = new MenuFragment();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //프래그먼트 추가하거나 할떄는 여러개 명령을 한꺼번에 쓸 수 있으므로
                //beginTransaction을 사용
                //fragment1를 R.id.container에 넣어달라(add 또는 replace, replace는 기존에있던걸 대체해줌)
                //트랜잭션안에서 수행되는것이므로 마지막에 꼭 commit을 해줘야 실행이된다.
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mainfragment).commit();/*프래그먼트 매니저가 프래그먼트를 담당한다!*/
                /*getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();*/

            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, menufragment).commit();/*프래그먼트 매니저가 프래그먼트를 담당한다!*/
            }
        });
    }

    //프래그먼트와 프래그먼트끼리 직접접근을하지않는다. 프래그먼트와 엑티비티가 접근
    public void onFragmentChange(int index){
        if(index == 0 ){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainfragment).commit();
        }else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menufragment).commit();
        }
    }
}