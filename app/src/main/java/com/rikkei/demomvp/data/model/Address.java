package com.rikkei.demomvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Address implements Parcelable {
    @SerializedName("street")
    private String mStreet;
    @SerializedName("suite")
    private String mSuite;
    @SerializedName("city")
    private String mCity;
    @SerializedName("zipcode")
    private String mZipCode;

    public Address() {
    }

    public Address(String street, String suite, String city, String zipCode) {
        mStreet = street;
        mSuite = suite;
        mCity = city;
        mZipCode = zipCode;
    }

    protected Address(Parcel in) {
        mStreet = in.readString();
        mSuite = in.readString();
        mCity = in.readString();
        mZipCode = in.readString();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public String getStreet() {
        return mStreet;
    }

    public String getSuite() {
        return mSuite;
    }

    public String getCity() {
        return mCity;
    }

    public String getZipCode() {
        return mZipCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mStreet);
        dest.writeString(mSuite);
        dest.writeString(mCity);
        dest.writeString(mZipCode);
    }
}
