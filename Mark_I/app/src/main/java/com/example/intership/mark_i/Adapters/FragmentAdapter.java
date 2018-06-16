package com.example.intership.mark_i.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
  //  private Context mContext;
    final static int PAGE_COUNT = 2;
    private final List<Fragment> mFragment = new ArrayList<>();
    private final List<String> mTitle = new ArrayList<>();


    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        mFragment.add(fragment);
        mTitle.add(title);
    }
}
