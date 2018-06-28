package com.example.intership.mark_i;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.intership.mark_i.Adapters.FragmentAdapter;
import com.example.intership.mark_i.DataModelSmallApi.LoginAnsver;
import com.example.intership.mark_i.Fragments.DayStatisticFragment;
import com.example.intership.mark_i.Fragments.TotalStatisticFragment;


public class StatisticActivity extends AppCompatActivity {

    public static String KEY_USER_ID = "UserId";
    public static String KEY_TOKEN = "Token";
    public static String KEY_SUCCESS = "Success";
    ViewPager mViewPage;
    TabLayout mTabLayout;
    public static LoginAnsver mUserData = new LoginAnsver() ;

    public static Intent createIntent(Context mContext, String mUserId,String mToken,String mSuccess) {
        Intent mIntent = new Intent(mContext, StatisticActivity.class);
        mIntent.putExtra(KEY_USER_ID, mUserId);
        mIntent.putExtra(KEY_TOKEN,mToken);
        mIntent.putExtra(KEY_SUCCESS,mSuccess);
        return mIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        mUserData.setUser_id(getIntent().getExtras().getString(KEY_USER_ID, ""));
        mUserData.setToken_auth(getIntent().getExtras().getString(KEY_TOKEN, ""));
        mUserData.setSuccess(getIntent().getExtras().getString(KEY_SUCCESS, ""));
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
