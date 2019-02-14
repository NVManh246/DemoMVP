package com.rikkei.demomvp.data.api;

import com.rikkei.demomvp.data.model.User;

public class ApiFactory {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static UserApi getApi() {
        return ApiConfig.getRetrofit(BASE_URL).create(UserApi.class);
    }
}
