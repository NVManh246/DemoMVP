package com.rikkei.demomvp.data.source;

public class UsersDataSource {
    public interface UsersRemoteDataSource {
        void getUsers(OnCompleteListener callback);
    }
}
