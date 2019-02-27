package com.pawardushyant.epaylaterinterview.retrofit.apicall;

import android.util.Log;

import com.pawardushyant.epaylaterinterview.retrofit.constants.Constants;
import com.pawardushyant.epaylaterinterview.retrofit.model.Balance;
import com.pawardushyant.epaylaterinterview.retrofit.model.Login;
import com.pawardushyant.epaylaterinterview.retrofit.model.Transaction;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @POST(Constants.Endpoint.login)
    Call<Login> login(@Header("Accept") String accept, @Header("Content-Type") String contentType);

    @GET(Constants.Endpoint.balance)
    Call<Balance> getBalance(@Header("Authorization") String auth, @Header("Accept") String accept);

    @POST(Constants.Endpoint.spend)
    Call<String> getSpend(@Header("Authorization") String auth, @Header("Accept") String accept,
                    @Header("Content-Type") String  contentType, @QueryMap Map<String, String> params);

    @POST(Constants.Endpoint.transactions)
    Call<Transaction> getTransactions(@Header("Authorization") String authorization,
                                      @Header("Accept") String accept, @QueryMap Map<String, String> params);

}
