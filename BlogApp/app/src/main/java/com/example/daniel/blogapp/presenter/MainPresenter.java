package com.example.daniel.blogapp.presenter;

import android.app.Application;

import com.example.daniel.blogapp.view.MainIView;

public class MainPresenter {
    MainIView mainIView;
    Login login;

    public MainPresenter() {
        login = new Login();
    }

    public void attach(MainIView mainIView) {
        this.mainIView = mainIView;
    }

    public void detach() {
        this.mainIView = null;
    }

    public void exitApp() {
        System.exit(0);
    }

    public void signupButtonClicked() {
        mainIView.openSignupActivity();
    }

    public void loginButtonClicked(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {
            login.loginFromMain(email, password, this.mainIView, this);
        } else {
            mainIView.showEmptyFieldMessage("Email and password cannot be empty");
        }
    }

    public boolean checkIfUserLogged() {
        return login.isUserLogged();
    }

    public void userLoggedIn() {
        mainIView.openBlogActivity();
    }

    public void failedAuth() {
        mainIView.showFailedAuthErrorMessage("Wrong email or password");
    }
}
