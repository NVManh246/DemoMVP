package com.rikkei.demomvp.data.api;

import com.rikkei.demomvp.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {
    @GET("users")
    Call<List<User>> getUsers();
}
