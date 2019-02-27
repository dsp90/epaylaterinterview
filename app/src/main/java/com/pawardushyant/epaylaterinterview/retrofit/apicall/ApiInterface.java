package com.pawardushyant.epaylaterinterview.retrofit.apicall;

import com.pawardushyant.epaylaterinterview.retrofit.constants.Constants;
import com.pawardushyant.epaylaterinterview.retrofit.model.Balance;
import com.pawardushyant.epaylaterinterview.retrofit.model.Login;
import com.pawardushyant.epaylaterinterview.retrofit.model.Spend;
import com.pawardushyant.epaylaterinterview.retrofit.model.Transaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST(Constants.Endpoint.login)
    Call<Login> login(@Header("Accept") String accept, @Header("Content-Type") String contentType);

    @GET(Constants.Endpoint.balance)
    Call<Balance> getBalance(@Header("Authorization") String auth, @Header("Accept") String accept);

    @POST(Constants.Endpoint.spend)
    Call<Spend> getSpend(@Header("Authorization") String auth, @Header("Accept") String accept,
                          @Header("Content-Type") String  contentType, @Body Spend spend);

    @GET(Constants.Endpoint.transactions)
    Call<List<Transaction>> getTransactions(@Header("Authorization") String authorization,
                                           @Header("Accept") String accept);

}
