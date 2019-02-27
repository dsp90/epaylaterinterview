package com.pawardushyant.epaylaterinterview.retrofit.listeners;

import retrofit2.Response;

public interface OnApiResponseListener<T> {
    void onApiServiceResponse(T response);
}
