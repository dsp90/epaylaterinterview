package com.pawardushyant.epaylaterinterview.utils;

import android.util.Log;

import com.pawardushyant.epaylaterinterview.BuildConfig;

public class Logger {

    private static final boolean ISDEBUG = BuildConfig.DEBUG;

    public static void printLog(String TAG, String message){
        if (ISDEBUG) Log.d(TAG, message);
    }
}
