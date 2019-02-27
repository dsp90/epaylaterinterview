package com.pawardushyant.epaylaterinterview.app.epaylatertab.transaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pawardushyant.epaylaterinterview.R;
import com.pawardushyant.epaylaterinterview.app.base.BaseFragment;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.adapter.TransactionsAdapter;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiInterface;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiManager;
import com.pawardushyant.epaylaterinterview.retrofit.constants.Constants;
import com.pawardushyant.epaylaterinterview.retrofit.model.Transaction;
import com.pawardushyant.epaylaterinterview.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionFragment extends BaseFragment {
    private RecyclerView rv_transactions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_transaction, container, false);
        initView(root);
        getTransactions();
        return root;
    }

    private void getTransactions() {
        ApiInterface apiInterface = ApiManager.getRetrofitClient().create(ApiInterface.class);
        Call<Transaction> transactionCall = apiInterface.getTransactions(Constants.AUTHTOKEN, Constants.CONTENT_TYPE);
        transactionCall.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                if (response.isSuccessful()) populateTransactions(response.body());
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Logger.printLog("TransactionFragment", t.getMessage());
            }
        });
    }

    private void populateTransactions(Transaction body) {
        List<Transaction> transactions = (List<Transaction>) body;
        TransactionsAdapter transactionsAdapter = new TransactionsAdapter(transactions);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_transactions.setAdapter(transactionsAdapter);
        rv_transactions.setHasFixedSize(true);
        rv_transactions.setLayoutManager(linearLayoutManager);
    }

    private void initView(View root) {
        rv_transactions = root.findViewById(R.id.rv_transactions);
    }
}
