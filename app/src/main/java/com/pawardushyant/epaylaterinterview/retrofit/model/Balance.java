package com.pawardushyant.epaylaterinterview.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Balance implements Parcelable {
    private String balance, currency;

    protected Balance(Parcel in) {
        balance = in.readString();
        currency = in.readString();
    }

    public static final Creator<Balance> CREATOR = new Creator<Balance>() {
        @Override
        public Balance createFromParcel(Parcel in) {
            return new Balance(in);
        }

        @Override
        public Balance[] newArray(int size) {
            return new Balance[size];
        }
    };

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(balance);
        dest.writeString(currency);
    }
}