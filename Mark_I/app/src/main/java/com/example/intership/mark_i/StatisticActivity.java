package com.example.intership.mark_i;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.intership.mark_i.Adapters.FragmentAdapter;
import com.example.intership.mark_i.Fragments.DayStatisticFragment;
import com.example.intership.mark_i.Fragments.TotalStatisticFragment;


public class StatisticActivity extends AppCompatActivity {

    public static String KEY = "sites";
    ViewPager mViewPage;
    TabLayout mTabLayout;

    public static Intent createIntent(Context mContext, String mId) {
        Intent mIntent = new Intent(mContext, StatisticActivity.class);
        mIntent.putExtra(KEY, mId);
        return mIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        String mId = getIntent().getExtras().getString(KEY, "");
        mViewPage = (ViewPager) findViewById(R.id.id_ViewPage);
        setupViewPager(mViewPage);
        mTabLayout = (TabLayout) findViewById(R.id.id_tl);
        mTabLayout.setupWithViewPager(mViewPage);


    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter fAdapter = new FragmentAdapter(getSupportFragmentManager());
        fAdapter.addFragment(new TotalStatisticFragment(), getResources().getString(R.string.string_Tablayaut_Total));
        fAdapter.addFragment(new DayStatisticFragment(), getResources().getString(R.string.string_Tablayaut_PerDay));
        viewPager.setAdapter(fAdapter);
    }

}
