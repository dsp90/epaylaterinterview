package com.pawardushyant.epaylaterinterview;

import android.app.Application;

import com.pawardushyant.epaylaterinterview.utils.SharedPrefUtils;

public class MainApp extends Application {

    private static MainApp mInstance;

    private SharedPrefUtils sharedPrefUtils;

    public static MainApp getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MainApp.mInstance = this;

        sharedPrefUtils = SharedPrefUtils.getInstance(getApplicationContext());
    }

    public static SharedPrefUtils getPrefs(){
        return MainApp.getInstance().getAppPreferencesImpl();
    }

    private SharedPrefUtils getAppPreferencesImpl(){
        if(sharedPrefUtils == null) {
            sharedPrefUtils = SharedPrefUtils.getInstance(getApplicationContext());
        }
        return sharedPrefUtils;
    }
}
