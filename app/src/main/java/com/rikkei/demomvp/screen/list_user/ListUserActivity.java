package com.rikkei.demomvp.screen.list_user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.rikkei.demomvp.R;
import com.rikkei.demomvp.data.model.User;
import com.rikkei.demomvp.screen.detail.UserDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends AppCompatActivity
        implements ListUserContract.View, UserAdapter.OnItemClickListener {

    private static final String TAG = "testtt";

    private RecyclerView mRecyclerUser;
    private List<User> mUsers;
    private UserAdapter mUserAdapter;
    private ProgressBar mProgress;

    private ListUserContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        initView();
        mPresenter = new ListUserPresenter(this);
        mPresenter.getUser();
    }

    private void initView() {
        mRecyclerUser = findViewById(R.id.recycler_user);
        mUsers = new ArrayList<>();
        mUserAdapter = new UserAdapter(this, mUsers, this);
        mRecyclerUser.setAdapter(mUserAdapter);
        mRecyclerUser.setLayoutManager(new LinearLayoutManager(this));
        mProgress = findViewById(R.id.progress);
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showListUser(List<User> users) {
        mUserAdapter.insertUsers(users);
    }

    @Override
    public void showError(Exception e) {
        Log.d(TAG, e.toString());
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = UserDetailActivity.getUserDetailIntent(this, mUsers.get(position));
        startActivity(intent);
    }
}
