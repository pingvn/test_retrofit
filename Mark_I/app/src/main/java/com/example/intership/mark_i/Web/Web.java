package com.example.intership.mark_i.Web;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.intership.mark_i.DataModel.EnterUser;
import com.example.intership.mark_i.DataModelSmallApi.LoginAnsver;
import com.example.intership.mark_i.DataModelSmallApi.Site;
import com.example.intership.mark_i.DataModelSmallApi.TotalStatistic;
import com.example.intership.mark_i.DataModelSmallApi.User;
import com.example.intership.mark_i.DataModelSmallApi.UserJson;
import com.example.intership.mark_i.R;
import com.example.intership.mark_i.ShowTotalStatistic;
import com.example.intership.mark_i.StatisticActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Web {
    static final String BASE_URL_K = "https://kruserapi.dtgb.solutions";
    static final String BASE_URL_S = "https://smallapi.dtgb.solutions";
    static final String BAD_RESPONE = "0";
    static final int FAIL_USER = -1;
    static final String ERROR_USER = "Пользователя не существует";
    private Retrofit mRetrofit;
    private KruseAPI mKruseApi;
    private SmallApi mSmallApi;


    public Web() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_S)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //mKruseApi = mRetrofit.create(KruseAPI.class);
        mSmallApi = mRetrofit.create(SmallApi.class);
    }

    /*
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
    */
    //проверка логин без получения токена
    public void getUsers(final EnterUser mLocal, final Context mContext) {
        Call<List<User>> mUsers = mSmallApi.getUsers();
        mUsers.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                int mId = checkUser(mLocal, response.body());
                if (mId >= 0) {
                    //  Toast.makeText(mContext,response.body().get(mId).getEmail(),Toast.LENGTH_LONG).show();
                    //  Intent mIntent = StatisticActivity.createIntent(mContext, response.body().get(mId).getId());
                    //  mContext.startActivity(mIntent);

                } else {
                    Toast.makeText(mContext, ERROR_USER, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    /*
        public void getTotalStatistic (final Context mContext, String mUserID){
            Call<List<TotalStatisticModel>> mTStatistic = mKruseApi.getTotalStatistic();
            mTStatistic.enqueue(new Callback<List<TotalStatisticModel>>() {
                @Override
                public void onResponse(Call<List<TotalStatisticModel>> call, Response<List<TotalStatisticModel>> response) {
                    Toast.makeText(mContext,response.body().get(0).getPageID().getSiteId().getName(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<List<TotalStatisticModel>> call, Throwable t) {

                }
            });
        }
    */
    public void getSite(final Context mContext) {
        Call<List<Site>> mSites = mSmallApi.getSites();
        mSites.enqueue(new Callback<List<Site>>() {
            @Override
            public void onResponse(Call<List<Site>> call, Response<List<Site>> response) {

            }

            @Override
            public void onFailure(Call<List<Site>> call, Throwable t) {

            }
        });

    }

    public void getTotalStatistic(final Context mContext, final View mView) {
        Call<List<TotalStatistic>> mTotalStatistic = mSmallApi.getTotalStatistic();
        mTotalStatistic.enqueue(new Callback<List<TotalStatistic>>() {
            @Override
            public void onResponse(Call<List<TotalStatistic>> call, Response<List<TotalStatistic>> response) {
                List<String> list = getSites(response.body());
                ShowTotalStatistic ts = new ShowTotalStatistic(mView);
                ts.putSites(list, response.body());
                // ts.showTotalStatistic("1",response.body());
            }

            @Override
            public void onFailure(Call<List<TotalStatistic>> call, Throwable t) {

            }
        });
    }


    public void getTotalStatisticToken(final Context mContext, final View mView) {
        String mToken = StatisticActivity.mUserData.getToken_auth();
        Call<List<TotalStatistic>> mTotalStatistic = mSmallApi.getTotalStatisticToken(mToken);
        mTotalStatistic.enqueue(new Callback<List<TotalStatistic>>() {
            @Override
            public void onResponse(Call<List<TotalStatistic>> call, Response<List<TotalStatistic>> response) {
                List<String> list = getSites(response.body());
                ShowTotalStatistic ts = new ShowTotalStatistic(mView);
                ts.putSites(list, response.body());
                // ts.showTotalStatistic("1",response.body());
            }

            @Override
            public void onFailure(Call<List<TotalStatistic>> call, Throwable t) {

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

    private List<String> getSites(List<TotalStatistic> mListTS) {
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < mListTS.size(); i++) {
            if(cheksite(mList,mListTS.get(i).getSite_name()))
            mList.add(mListTS.get(i).getSite_name());
        }
        return mList;
    }
    private boolean cheksite(List<String> list, String site){
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                if(site.equals(list.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public void autorization(String user, String password, final Context mContext) {
        UserJson mUser = new UserJson(user, password);
        Call<LoginAnsver> mAutorization = mSmallApi.autorization(mUser);
        mAutorization.enqueue(new Callback<LoginAnsver>() {
            @Override
            public void onResponse(Call<LoginAnsver> call, Response<LoginAnsver> response) {
                if (!response.body().getSuccess().equals(BAD_RESPONE)) {
                    Intent mIntent = StatisticActivity.createIntent(mContext,
                            response.body().getUser_id(),
                            response.body().getToken_auth(),
                            response.body().getSuccess());
                    mContext.startActivity(mIntent);
                } else {
                    Toast.makeText(mContext, mContext.getResources().getString(R.string.string_error_Login), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginAnsver> call, Throwable t) {

            }
        });
    }

}
