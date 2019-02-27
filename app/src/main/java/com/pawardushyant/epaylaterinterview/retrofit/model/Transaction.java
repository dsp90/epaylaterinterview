package com.pawardushyant.epaylaterinterview.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {

    private String date;

    private String amount;

    private String description;

    private String currency;

    private String id;

    private Transaction(Parcel in) {
        date = in.readString();
        amount = in.readString();
        description = in.readString();
        currency = in.readString();
        id = in.readString();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(amount);
        dest.writeString(description);
        dest.writeString(currency);
        dest.writeString(id);
    }
}
