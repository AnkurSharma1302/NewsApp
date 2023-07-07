package com.ankroid.mynewsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();
            case 1:
                return new sportsFragment();
            case 2:
                return new scienceAndTechFragment();
            case 3:
                return new healthFragment();
            case 4:
                return new businessFragement();
            case 5:
                return new entertainmentFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return tabcount;
    }
}
