package com.glocalfarm.adaptor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.glocalfarm.R;
import com.glocalfarm.activities.MainActivity;
import com.glocalfarm.fragments.VegetableCategoryFragment;
import com.glocalfarm.fragments.FruitsCategoryFragment;

public class MainAdaptor extends FragmentPagerAdapter {

    private MainActivity mContext;

    public MainAdaptor(FragmentManager fm, MainActivity context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VegetableCategoryFragment();
            case 1:
                return new FruitsCategoryFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return mContext.getResources().getString(R.string.vegetable);
            case 1:
                return mContext.getResources().getString(R.string.fruits);

        }
        return null;
    }
}
