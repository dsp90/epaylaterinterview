package com.pawardushyant.epaylaterinterview.app.epaylatertab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;

import com.pawardushyant.epaylaterinterview.R;
import com.pawardushyant.epaylaterinterview.app.base.BaseActivity;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.adapter.ScreenSliderPagerAdapter;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.login.LoginInteractor;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.login.LoginPresenter;
import com.pawardushyant.epaylaterinterview.app.epaylatertab.login.LoginView;


public class HomeScreenActivity extends BaseActivity implements LoginView, ViewPager.OnPageChangeListener {

    ProgressBar progressBar;

    private static final int pages = 3;
    private ViewPager view_pager_home;
    private TabLayout tablayout_home;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initViews();
        toggleProgressBar(View.GONE);
        LoginPresenter loginPresenter = new LoginPresenter(this, new LoginInteractor());
        loginPresenter.validate();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_circular);
        view_pager_home = findViewById(R.id.view_pager_home);
        tablayout_home = findViewById(R.id.tablayout_home);
    }

    private void toggleProgressBar(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showProgress() {
        toggleProgressBar(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        toggleProgressBar(View.GONE);
    }

    @Override
    public void onBackPressed() {
        if (view_pager_home.getCurrentItem() == 0 ) {
            super.onBackPressed();
        } else {
            view_pager_home.setCurrentItem(view_pager_home.getCurrentItem() - 1);
        }
    }

    @Override
    public void showTabs() {
        ScreenSliderPagerAdapter adapter = new ScreenSliderPagerAdapter(getSupportFragmentManager(), pages);
        tablayout_home.setupWithViewPager(view_pager_home);
        view_pager_home.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (view_pager_home != null)
        view_pager_home.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
