package com.example.intership.mark_i.Web;

import com.example.intership.mark_i.DataModel.TotalStatisticModel;
import com.example.intership.mark_i.DataModel.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KruseAPI {

    //получение списка пользователей
    @GET("/v1/users")
    Call<List<User>> getUsers();
    //получение общей статистики
    @GET("/v1/persons/rank")
    Call<List<TotalStatisticModel>> getTotalStatistic();

}
