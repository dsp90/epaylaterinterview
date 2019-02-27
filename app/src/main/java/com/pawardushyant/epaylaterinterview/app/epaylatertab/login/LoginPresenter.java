package com.pawardushyant.epaylaterinterview.app.epaylatertab.login;

import com.pawardushyant.epaylaterinterview.utils.Logger;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor){
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validate(){
        if (loginView != null){
            loginView.showProgress();
        }

        loginInteractor.doLogin(this);
    }

    public void onDestroy(){
        loginView = null;
    }

    @Override
    public void onSuccess() {
        if (loginView != null){
            loginView.hideProgress();
            loginView.showTabs();
            Logger.printLog("LoginPresenter", "login success");
        }
    }
}
