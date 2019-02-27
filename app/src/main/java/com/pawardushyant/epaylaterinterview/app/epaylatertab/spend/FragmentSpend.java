package com.pawardushyant.epaylaterinterview.app.epaylatertab.spend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pawardushyant.epaylaterinterview.MainApp;
import com.pawardushyant.epaylaterinterview.R;
import com.pawardushyant.epaylaterinterview.app.base.BaseFragment;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiInterface;
import com.pawardushyant.epaylaterinterview.retrofit.apicall.ApiManager;
import com.pawardushyant.epaylaterinterview.retrofit.constants.Constants;
import com.pawardushyant.epaylaterinterview.retrofit.model.Spend;
import com.pawardushyant.epaylaterinterview.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSpend extends BaseFragment implements View.OnClickListener {

    private TextView tv_spend;
    private Button btn_spend;
    private EditText ed_spend;
    private String currency;
    private String balance;
    private EditText ed_spend_desc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_spend, container, false);
        initViews(root);
        displaySpendingLimit();
        return root;
    }

    private void displaySpendingLimit() {
        currency = MainApp.getPrefs().getCurrency();
        balance = MainApp.getPrefs().getBalance();
        tv_spend.setText("Spending limit is " + balance + " " + currency);
    }

    private void initViews(View root) {
        tv_spend = root.findViewById(R.id.tv_limit);
        btn_spend = root.findViewById(R.id.btn_spend);
        ed_spend = root.findViewById(R.id.ed_spend);
        ed_spend_desc = root.findViewById(R.id.ed_spend_desc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_spend:
                spend();
                break;
        }
    }

    private void spend() {
        String amount = ed_spend.getText().toString();
        if(isValidated(amount)){
            doSpend(amount);
        }
    }

    private void doSpend(final String amount) {

        String desc = TextUtils.isEmpty(getTextVal(ed_spend_desc)) ? "Some Item" : getTextVal(ed_spend_desc);

        Spend spend = new Spend();
        spend.setAmount(amount);
        spend.setCurrency(currency);
        spend.setDate(AppUtils.getDateTime());
        spend.setDescription(desc);

        ApiInterface apiInterface = ApiManager.getRetrofitClient().create(ApiInterface.class);
        Call<Spend> spendCall = apiInterface.getSpend(Constants.AUTHTOKEN,
                Constants.CONTENT_TYPE, Constants.CONTENT_TYPE, spend
                 );
        spendCall.enqueue(new Callback<Spend>() {
            @Override
            public void onResponse(Call<Spend> call, Response<Spend> response) {
                if (response.isSuccessful()){
                    int updatedBal = Integer.parseInt(balance) - Integer.parseInt(amount);
                    displaBalance(updatedBal);
                }
            }

            @Override
            public void onFailure(Call<Spend> call, Throwable t) {

            }
        });
    }

    private void displaBalance(int updatedBal) {
        tv_spend.setText("Spending limit is " + updatedBal + " "  + currency);
    }

    private String getTextVal(EditText editText) {
        return editText.getText().toString().trim();
    }

    private boolean isValidated(String amount) {
        int spendingAmount = Integer.parseInt(amount);
        int limit = Integer.parseInt(MainApp.getPrefs().getBalance());
        if (spendingAmount > limit){
            ed_spend.setError(getString(R.string.cannot_spend_amount_greater_than_limit));
            return false;
        }
        return true;
    }
}
