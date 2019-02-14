package com.rikkei.demomvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("address")
    private Address mAddress;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("website")
    private String mWebsite;
    @SerializedName("company")
    private Company mCompany;

    public User() {
    }

    public User(int id, String name, String username, String email,
                Address address, String phone, String website, Company company) {
        mId = id;
        mName = name;
        mUsername = username;
        mEmail = email;
        mAddress = address;
        mPhone = phone;
        mWebsite = website;
        mCompany = company;
    }

    protected User(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mUsername = in.readString();
        mEmail = in.readString();
        mAddress = in.readParcelable(Address.class.getClassLoader());
        mPhone = in.readString();
        mWebsite = in.readString();
        mCompany = in.readParcelable(Company.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getEmail() {
        return mEmail;
    }

    public Address getAddress() {
        return mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public Company getCompany() {
        return mCompany;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mUsername);
        dest.writeString(mEmail);
        dest.writeParcelable(mAddress, flags);
        dest.writeString(mPhone);
        dest.writeString(mWebsite);
        dest.writeParcelable(mCompany, flags);
    }
}
