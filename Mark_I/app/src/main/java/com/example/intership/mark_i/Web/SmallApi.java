package com.example.intership.mark_i.Web;

import com.example.intership.mark_i.DataModelSmallApi.LoginAnsver;
import com.example.intership.mark_i.DataModelSmallApi.Site;
import com.example.intership.mark_i.DataModelSmallApi.TotalStatistic;
import com.example.intership.mark_i.DataModelSmallApi.User;
import com.example.intership.mark_i.DataModelSmallApi.UserJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SmallApi {
    @GET("/v1/users")
    Call<List<User>> getUsers();

    @GET("/v1/sites")
    Call<List<Site>> getSites();

    @GET("/v1/persons/rank?groupby=siteID")
    Call<List<TotalStatistic>> getTotalStatistic();

    @GET("/v1/persons/rank?groupby=siteID")
    Call<List<TotalStatistic>> getTotalStatisticToken(@Query("token_auth") String mToken);


    @GET("/v1/persons/rank/date?_from={fromdate}&_till={tilldate}")
    Call<List<TotalStatistic>> getPerdayStatistic(@Path("fromdate") String mfromeDate, @Path("tilldate") String mtilldate);

    @Headers("Content-Type: application/json")
    @POST("/v1/auth")
    Call<LoginAnsver> autorization(@Body UserJson mUserJson);


}
