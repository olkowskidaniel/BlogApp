package com.example.daniel.blogapp.presenter;

import android.content.Intent;

import com.example.daniel.blogapp.model.User;
import com.example.daniel.blogapp.view.SignupIView;

public class SignupPresenter {
    SignupIView signupIView;
    Signup signup;
    Login login;
    User user;
    Database database;

    public void attach(SignupIView signupIView) {
        this.signupIView = signupIView;
    }

    public void detach() {
        this.signupIView = null;
    }

    public void onCreateAccountButtonClicked(String email, String password, String retypedPassword, String name, String lastName) {
        signup = new Signup();
        if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty() && !lastName.isEmpty()) {
            if (password.equals(retypedPassword)) {
                signup.createAccount(email, password, this.signupIView, this);
            } else {
                signupIView.showPasswordsDontMatchMessage("Passwords don't match.");
            }
        } else {
            signupIView.showEmptyFieldMessage("No field can be empty.");
        }
    }

    public void accountCreateSuccess(String email, String password) {
        signupIView.showAccountCreatedMessage("Account successfully created");
        login.loginAfterSignup(email, password, this.signupIView, this);

    }

    public void accountCreateFailed() {
        signupIView.showAccountCreateFailedMessage("Account creating failed");
    }

    public void loginSuccess() {
        signupIView.openBlogActivity();
    }

}
