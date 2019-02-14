package com.rikkei.demomvp.data.source.remote;

import com.rikkei.demomvp.data.api.UserApi;
import com.rikkei.demomvp.data.model.User;
import com.rikkei.demomvp.data.source.OnCompleteListener;
import com.rikkei.demomvp.data.source.UsersDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRemoteDataSource implements UsersDataSource.UsersRemoteDataSource {

    private static UsersRemoteDataSource sIntance;
    private UserApi mUserApi;

    private UsersRemoteDataSource(UserApi userApi) {
        mUserApi = userApi;
    }

    public static UsersRemoteDataSource getIntance(UserApi userApi) {
        if(sIntance == null) {
            sIntance = new UsersRemoteDataSource(userApi);
        }
        return sIntance;
    }

    @Override
    public void getUsers(final OnCompleteListener callback) {
        Call<List<User>> call = mUserApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onError((Exception) t);
            }
        });
    }
}
