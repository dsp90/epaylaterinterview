package com.pawardushyant.epaylaterinterview.app.epaylatertab.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pawardushyant.epaylaterinterview.MainApp;
import com.pawardushyant.epaylaterinterview.R;
import com.pawardushyant.epaylaterinterview.retrofit.model.Transaction;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.CustomViewHolder> {

    private List<Transaction> transactions;

    public TransactionsAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(MainApp.getInstance().getApplicationContext()).inflate(R.layout.row_transaction, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.tv_trans_id.setText(transactions.get(i).getId());
        customViewHolder.tv_trans_date.setText(transactions.get(i).getDate());
        customViewHolder.tv_amount.setText(transactions.get(i).getAmount() + " " + transactions.get(i).getCurrency() );
        customViewHolder.tv_desc.setText(transactions.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return transactions == null ? 0 : transactions.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_amount, tv_trans_id, tv_trans_date, tv_desc;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_trans_date = itemView.findViewById(R.id.tv_trans_date);
            tv_trans_id = itemView.findViewById(R.id.tv_transid);
            tv_desc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
