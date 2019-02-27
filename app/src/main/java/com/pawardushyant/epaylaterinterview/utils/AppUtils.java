package com.pawardushyant.epaylaterinterview.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.pawardushyant.epaylaterinterview.MainApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {

    public static boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager)MainApp.getInstance().getApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

    public static String getDateTime(){
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

}
