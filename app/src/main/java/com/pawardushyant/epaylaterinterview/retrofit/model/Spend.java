package com.pawardushyant.epaylaterinterview.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Spend implements Parcelable {
    private String date;

    private String amount;

    private String description;

    private String currency;

    private Spend(Parcel in) {
        date = in.readString();
        amount = in.readString();
        description = in.readString();
        currency = in.readString();
    }

    public static final Creator<Spend> CREATOR = new Creator<Spend>() {
        @Override
        public Spend createFromParcel(Parcel in) {
            return new Spend(in);
        }

        @Override
        public Spend[] newArray(int size) {
            return new Spend[size];
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
    }
}
