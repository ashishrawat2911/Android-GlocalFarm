package com.glocalfarm.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.glocalfarm.adaptor.MainAdaptor;
import com.glocalfarm.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class MainActivity extends AppCompatActivity {
    private SmartTabLayout mSmartTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmartTabLayout = (SmartTabLayout) findViewById(R.id.tab_view_pager_fav);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_fav);
        mViewPager.setAdapter(new MainAdaptor(getSupportFragmentManager(), this));
        mSmartTabLayout.setViewPager(mViewPager);
    }
}
