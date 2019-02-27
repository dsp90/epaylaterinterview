package com.pawardushyant.epaylaterinterview.app.epaylatertab.login;

import com.pawardushyant.epaylaterinterview.MainApp;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiInterface;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiManager;
import com.pawardushyant.epaylaterinterview.retrofit.model.Login;
import com.pawardushyant.epaylaterinterview.utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor{

    final String TAG = "LoginInteractor";

    private ApiInterface apiService = ApiManager.getRetrofitClient().create(ApiInterface.class);
    private boolean isLoggedIn;

    interface OnLoginFinishedListener{
        void onSuccess();
    }


    void doLogin(final OnLoginFinishedListener onLoginFinishedListener){
        Call<Login> call = apiService.login("application/json","application/json");
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Logger.printLog(TAG, response.body().getToken());
                String token = null;
                if (response.isSuccessful()) {
                    isLoggedIn = true;
                    token = response.body().getToken();
                    MainApp.getPrefs().setAccountCredentials(token);
                    onLoginFinishedListener.onSuccess();
                } else {
                    isLoggedIn = false;
                    Logger.printLog(TAG, response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Logger.printLog(TAG, t.getMessage());
                isLoggedIn = false;
            }
        });
    }

}
