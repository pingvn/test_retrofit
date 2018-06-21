package com.example.intership.mark_i.Web;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.intership.mark_i.DataModel.EnterUser;
import com.example.intership.mark_i.DataModel.TotalStatisticModel;
import com.example.intership.mark_i.DataModel.User;
import com.example.intership.mark_i.LoadingActivity;
import com.example.intership.mark_i.ShowTotalStatistic;
import com.example.intership.mark_i.Statistic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Web {
    static final String BASE_URL = "https://kruserapi.dtgb.solutions";
    static final int FAIL_USER = -1;
    static final String ERROR_USER = "Пользователя не существует";
    private Retrofit mRetrofit;
    private KruseAPI mKruseApi;


    public Web() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mKruseApi = mRetrofit.create(KruseAPI.class);
    }

    public void getUsers(final EnterUser mLocal, final Context mContext) {
        Call<List<User>> mUsers = mKruseApi.getUsers();
        mUsers.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                int mId = checkUser(mLocal, response.body());
                if (mId >= 0) {
                   Toast.makeText(mContext,response.body().get(mId).getEmail(),Toast.LENGTH_LONG).show();
                    Intent intent = LoadingActivity.createIntent(mContext,response.body().get(mId).getId());
                    mContext.startActivity(intent);

                }else{
                    Toast.makeText(mContext,ERROR_USER,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public void getTotalStatistic (final Context mContext){
        Call<List<TotalStatisticModel>> mTStatistic = mKruseApi.getTotalStatistic();
        mTStatistic.enqueue(new Callback<List<TotalStatisticModel>>() {
            @Override
            public void onResponse(Call<List<TotalStatisticModel>> call, Response<List<TotalStatisticModel>> response) {
                Toast.makeText(mContext,response.body().get(0).getPageID().getSiteId().getName(),Toast.LENGTH_LONG).show();
                //response.body().get(0).getPageID().getSiteId().getName();
            }

            @Override
            public void onFailure(Call<List<TotalStatisticModel>> call, Throwable t) {

            }
        });
    }

    private int checkUser(EnterUser mlocal, List<User> mUsers) {
        for (int i = 0; i < mUsers.size(); i++) {
            if (mlocal.getmLogin().equals(mUsers.get(i).getLogin())) {
                return i;
            }
        }
        return FAIL_USER;
    }
}
