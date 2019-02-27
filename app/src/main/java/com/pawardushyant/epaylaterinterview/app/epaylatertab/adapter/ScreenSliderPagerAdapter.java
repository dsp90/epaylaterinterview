package com.pawardushyant.epaylaterinterview.app.epaylatertab.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pawardushyant.epaylaterinterview.app.epaylatertab.balance.BalanceFragment;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.spend.FragmentSpend;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.transaction.TransactionFragment;

public class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter {
    int pages;

    public ScreenSliderPagerAdapter(FragmentManager fm, int pages) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new BalanceFragment();
            case 1:
                return new FragmentSpend();
            case 2:
                return new TransactionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pages;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Balance";
            case 1:
                return "Transactions";
            case 2:
                return "Spend";
            default:
                return null;
        }
    }
}
