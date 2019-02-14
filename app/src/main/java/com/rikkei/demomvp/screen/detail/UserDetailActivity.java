package com.rikkei.demomvp.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.rikkei.demomvp.R;
import com.rikkei.demomvp.data.model.User;

public class UserDetailActivity extends AppCompatActivity {

    private final static String EXTRA_USER = "user";
    private User mUser;
    private TextView mTextId;
    private TextView mTextUsername;
    private TextView mTextName;
    private TextView mTextEmail;
    private TextView mTextAddress;
    private TextView mTextPhone;
    private TextView mTextWebsite;
    private TextView mTextCompany;

    public static Intent getUserDetailIntent(Context context, User user) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(EXTRA_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        mUser = getIntent().getParcelableExtra(EXTRA_USER);
        initView();
    }

    private void initView() {
        mTextId = findViewById(R.id.text_id);
        mTextUsername = findViewById(R.id.text_username);
        mTextName = findViewById(R.id.text_name);
        mTextEmail = findViewById(R.id.text_email);
        mTextAddress = findViewById(R.id.text_address);
        mTextPhone = findViewById(R.id.text_phone);
        mTextWebsite = findViewById(R.id.text_website);
        mTextCompany = findViewById(R.id.text_company);

        mTextId.setText(String.valueOf(mUser.getId()));
        mTextUsername.setText(mUser.getUsername());
        mTextName.setText(mUser.getName());
        mTextEmail.setText(mUser.getEmail());
        mTextAddress.setText(mUser.getAddress().getCity());
        mTextPhone.setText(mUser.getPhone());
        mTextWebsite.setText(mUser.getWebsite());
        mTextCompany.setText(mUser.getCompany().getName());
    }
}
