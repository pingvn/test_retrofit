package com.example.intership.mark_i.Web;

import com.example.intership.mark_i.DataModelSmallApi.LoginAnsver;
import com.example.intership.mark_i.DataModelSmallApi.UserJson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PksmalApiA {

    @Headers("Content-Type: application/json")
    @POST("/v1/auth")
    Call<LoginAnsver> autorization(@Body UserJson mUserJson);


}
