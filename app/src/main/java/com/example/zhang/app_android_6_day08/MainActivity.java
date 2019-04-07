package com.example.zhang.app_android_6_day08;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] title = {"1","2","3","4","5"};
    private MyAdapter adapter;
    private RadioButton[] radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        initButton();
    }

    private void initData() {
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());


    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        r5 = (RadioButton) findViewById(R.id.r5);

        adapter = new MyAdapter(getSupportFragmentManager());
        tab.setupWithViewPager(vp);
        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                for (int j = 0; j < radioButtons.length; j++) {

                    radioButtons[i].setTextColor(Color.BLACK);
                    radioButtons[i].setTextColor(Color.YELLOW);
                }

                if (i == 0){
                    r1.setChecked(true);


                } if (i == 1){
                    r2.setChecked(true);


                } if (i == 2){
                    r3.setChecked(true);


                } if (i == 3){
                    r4.setChecked(true);


                } if (i == 4){
                    r5.setChecked(true);

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



    }


    private void initButton(){
        radioButtons = new RadioButton[fragments.size()];
        RadioGroup rg = findViewById(R.id.rg);
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = (RadioButton) rg.getChildAt(i);
            radioButtons[i].setTextColor(Color.BLACK);

        }
        radioButtons[0].setTextColor(Color.YELLOW);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < radioButtons.length; i++) {
                    if (radioButtons[i].getId() == checkedId){
                        vp.setCurrentItem(i);
                    }
                }

            }
        });
    }

    class MyAdapter extends FragmentStatePagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
