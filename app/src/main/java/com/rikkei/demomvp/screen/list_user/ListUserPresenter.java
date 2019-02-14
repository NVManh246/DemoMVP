package com.rikkei.demomvp.screen.list_user;

import com.rikkei.demomvp.data.api.ApiFactory;
import com.rikkei.demomvp.data.model.User;
import com.rikkei.demomvp.data.source.OnCompleteListener;
import com.rikkei.demomvp.data.source.UsersRepository;
import com.rikkei.demomvp.data.source.remote.UsersRemoteDataSource;

import java.util.List;

public class ListUserPresenter implements ListUserContract.Presenter {

    private ListUserContract.View mView;
    private UsersRepository mUsersRepository;

    public ListUserPresenter(ListUserContract.View view) {
        mView = view;
        mUsersRepository = UsersRepository
                .getIntance(UsersRemoteDataSource.getIntance(ApiFactory.getApi()));
    }

    @Override
    public void getUser() {
        mView.showProgress();
        mUsersRepository.getUsers(new OnCompleteListener<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                mView.hideProgress();
                mView.showListUser(users);
            }

            @Override
            public void onError(Exception t) {
                mView.hideProgress();
            }
        });
    }
}
