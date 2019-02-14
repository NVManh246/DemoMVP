package com.rikkei.demomvp.data.source;

import com.rikkei.demomvp.data.source.remote.UsersRemoteDataSource;

public class UsersRepository implements UsersDataSource.UsersRemoteDataSource{

    private static UsersRepository sIntance;
    private UsersDataSource.UsersRemoteDataSource mRemoteDataSource;

    private UsersRepository(UsersRemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static UsersRepository getIntance(UsersRemoteDataSource remoteDataSource) {
        if(sIntance == null) {
            sIntance = new UsersRepository(remoteDataSource);
        }
        return sIntance;
    }

    @Override
    public void getUsers(OnCompleteListener callback) {
        mRemoteDataSource.getUsers(callback);
    }
}
