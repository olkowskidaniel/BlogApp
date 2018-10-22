package com.example.daniel.blogapp.presenter;

import android.content.Intent;

import com.example.daniel.blogapp.view.SignupIView;

public class SignupPresenter {
    SignupIView signupIView;

    public void attach(SignupIView signupIView) {
        this.signupIView = signupIView;
    }

    public void detach() {
        this.signupIView = null;
    }
}
