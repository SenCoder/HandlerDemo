package com.tcl.demo.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.util.LogUtils;
import com.tcl.handler.demo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonLeft, mRadioButtonMid, mRadioButtonRight;
    private ArrayList<Fragment> fragments;


    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRadioGroup.check(R.id.rbtn_first);
                    LogUtils.d("onPageSelected " + position);
                    break;
                case 1:
                    mRadioGroup.check(R.id.rbtn_second);
                    LogUtils.d("onPageSelected " + position);
                    break;
                case 2:
                    mRadioGroup.check(R.id.rbtn_third);
                    LogUtils.d("onPageSelected " + position);
                    break;

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rbtn_first:
                    mViewPager.setCurrentItem(0);
                    LogUtils.d("click " + "0");
                    break;
                case R.id.rbtn_second:
                    mViewPager.setCurrentItem(1);
                    LogUtils.d("click " + "1");
                    break;
                case R.id.rbtn_third:
                    mViewPager.setCurrentItem(2);
                    LogUtils.d("click " + "2");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ArrayList<>();
        fragments.add(new RankFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new DownloadFragment());

        parseView();

    }

    private void parseView() {

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new MyFragmentPagerAdapter(fm, fragments));
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
//        mViewPager.

        mRadioGroup = (RadioGroup) findViewById(R.id.rg_bottom_btns);
        mRadioButtonLeft = (RadioButton) findViewById(R.id.rbtn_first);
        mRadioButtonMid = (RadioButton) findViewById(R.id.rbtn_second);
        mRadioButtonRight = (RadioButton) findViewById(R.id.rbtn_third);

        mRadioButtonLeft.setOnClickListener(mOnClickListener);
        mRadioButtonMid.setOnClickListener(mOnClickListener);
        mRadioButtonRight.setOnClickListener(mOnClickListener);
    }


}
