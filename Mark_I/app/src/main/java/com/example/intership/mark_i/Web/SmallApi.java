package com.example.intership.mark_i.Web;

import com.example.intership.mark_i.DataModelSmallApi.Site;
import com.example.intership.mark_i.DataModelSmallApi.TotalStatistic;
import com.example.intership.mark_i.DataModelSmallApi.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SmallApi {
    @GET("/v1/users")
    Call<List<User>> getUsers();

    @GET("/v1/sites")
    Call<List<Site>> getSites();

    @GET("/v1/persons/rank?groupby=siteID")
    Call<List<TotalStatistic>> getTotalStatistic();
}
