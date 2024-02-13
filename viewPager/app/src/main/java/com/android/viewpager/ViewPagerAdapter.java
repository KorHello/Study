package com.android.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //프래그 먼트를 교체를 보여주는 처리를 구현한곳
    @NonNull
    @Override
    public Fragment getItem(int position) { //   fragment 생성한 3개를 불러들인다
        switch (position) {
            case 0:
                return FragMonday.newInstance();
                //0번일 경우 생성자 리턴
            case 1:
                return FragTuesday.newInstance();
                //1번일 경우 생성자 리턴
            case 2:
                return FragWednesday.newInstance();
                //2번일 경우 생성자 리턴
            default:
                return null;
        }
    }

    @Override
    public int getCount() { //   프래그먼트를 기준으로 몇개에 대하여 리턴해줄것인가
        return 3;
    }

    //상단의 탭 레이아웃 인디케이터 쪽 텍스트를 선언해주는 곳
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { //   안드로이드 탭 레이아웃 기본제공에 쓰일 타이틀 구성
        switch (position) {
            case 0:
                return "Monday";
            //0번일 경우 Monday 탭 리턴
            case 1:
                return "Tuesday";
            //1번일 경우 Tuesday 탭 리턴
            case 2:
                return "Wednesday";
            //2번일 경우 Wednesday 탭 리턴
            default:
                return null;
        }
    }
}
