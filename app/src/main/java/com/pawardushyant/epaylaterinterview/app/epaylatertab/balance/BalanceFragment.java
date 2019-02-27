package com.pawardushyant.epaylaterinterview.app.epaylatertab.balance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pawardushyant.epaylaterinterview.MainApp;
import com.pawardushyant.epaylaterinterview.R;
import com.pawardushyant.epaylaterinterview.app.base.BaseFragment;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiInterface;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiManager;
import com.pawardushyant.epaylaterinterview.retrofit.constants.Constants;
import com.pawardushyant.epaylaterinterview.retrofit.model.Balance;
import com.pawardushyant.epaylaterinterview.utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalanceFragment extends BaseFragment {

    private TextView tv_balance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_balance, container, false);
        initViews(rootView);
        getBalance();
        return rootView;
    }

    private void getBalance() {
        ApiInterface apiService = ApiManager.getRetrofitClient().create(ApiInterface.class);
        Call<Balance> call = apiService.getBalance(Constants.AUTHTOKEN, Constants.CONTENT_TYPE);
        call.enqueue(new Callback<Balance>() {
            @Override
            public void onResponse(Call<Balance> call, Response<Balance> response) {
                saveBalanceData(response.body());
            }

            @Override
            public void onFailure(Call<Balance> call, Throwable t) {
                Logger.printLog("BalanceFragment", t.getMessage());
            }
        });
    }

    private void saveBalanceData(Balance response) {
        MainApp.getPrefs().setBalance(response.getBalance());
        MainApp.getPrefs().setCurrency(response.getCurrency());
        displayBalance();
    }

    private void displayBalance() {
        tv_balance.setText("Your current balance is " + MainApp.getPrefs().getBalance() + " " +
                MainApp.getPrefs().getCurrency());
    }

    private void initViews(View rootView) {
        tv_balance = rootView.findViewById(R.id.tv_balance);
    }
}
