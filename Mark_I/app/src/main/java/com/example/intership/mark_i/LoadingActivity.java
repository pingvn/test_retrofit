package com.example.intership.mark_i;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.intership.mark_i.Web.Web;

public class LoadingActivity extends AppCompatActivity {
    final static String KEY_ID = "user_id";
    private String mUserId;
    Web mWeb = new Web();

    public static Intent createIntent(Context mContext, String id) {
        Intent intent = new Intent(mContext, LoadingActivity.class);
        intent.putExtra(KEY_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        mUserId = getIntent().getExtras().getString(KEY_ID);
        mWeb.getSite(this);

    }
}
