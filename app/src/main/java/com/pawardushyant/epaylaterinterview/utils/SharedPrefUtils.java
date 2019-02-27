package com.pawardushyant.epaylaterinterview.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefUtils {

    private static final String TOKEN = "token";
    private static final String BALANCE = "balance";
    private static final String CURRENCY = "currency";

    private static final String SHARED_PREF_NAME = "epaylatersharedpreferences";

    private static SharedPrefUtils sPrefs;
    private SharedPreferences mSharedPreferences;
    private Editor mEditor;

    private SharedPrefUtils(Context context){
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static SharedPrefUtils getInstance(Context context){
        if (sPrefs == null){
            sPrefs = new SharedPrefUtils(context);
        }

        return sPrefs;
    }

    public void clearAllData(Context context){
        mEditor.clear().commit();
    }

    public String getAccountToken(){
        return mSharedPreferences.getString(TOKEN, null);
    }

    public String getBalance(){
        return mSharedPreferences.getString(BALANCE, null);
    }

    public String getCurrency(){
        return mSharedPreferences.getString(CURRENCY, null);
    }

    public void setAccountCredentials(String token){
        mEditor.putString(TOKEN, token);
        mEditor.commit();
    }

    public void setBalance(String balance){
        mEditor.putString(BALANCE, balance);
        mEditor.commit();
    }

    public void setCurrency(String currency){
        mEditor.putString(CURRENCY, currency);
        mEditor.commit();
    }
}
