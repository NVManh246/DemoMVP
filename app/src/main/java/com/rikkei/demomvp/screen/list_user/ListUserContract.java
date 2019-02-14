package com.rikkei.demomvp.screen.list_user;

import com.rikkei.demomvp.data.model.User;

import java.util.List;

public interface ListUserContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showListUser(List<User> users);
        void showError(Exception e);
    }

    interface Presenter {
        void getUser();
    }
}
