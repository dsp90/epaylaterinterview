package com.pawardushyant.epaylaterinterview.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.pawardushyant.epaylaterinterview.MainApp;

public class AppUtils {

    public static boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager)MainApp.getInstance().getApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

}
