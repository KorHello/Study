package com.devhouse.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.devhouse.recyclerview.fragmentClasses.Fragment_First;
import com.devhouse.recyclerview.fragmentClasses.Fragment_Second;
import com.devhouse.recyclerview.fragmentClasses.Fragment_Third;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new Fragment_First(), "첫번째 페이지");
        adapter.addFragment(new Fragment_Second(), "두번째 페이지");
        adapter.addFragment(new Fragment_Third(), "세번째 페이지");
        viewPager.setAdapter(adapter);
    }

}