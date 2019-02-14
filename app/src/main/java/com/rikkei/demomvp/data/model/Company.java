package com.rikkei.demomvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable {
    @SerializedName("name")
    private String mName;
    @SerializedName("catchPhrase")
    private String mCatchPhrase;
    @SerializedName("bs")
    private String mBs;

    public Company() {
    }

    public Company(String name, String catchPhrase, String bs) {
        mName = name;
        mCatchPhrase = catchPhrase;
        mBs = bs;
    }

    protected Company(Parcel in) {
        mName = in.readString();
        mCatchPhrase = in.readString();
        mBs = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    public String getName() {
        return mName;
    }

    public String getCatchPhrase() {
        return mCatchPhrase;
    }

    public String getBs() {
        return mBs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mCatchPhrase);
        dest.writeString(mBs);
    }
}
