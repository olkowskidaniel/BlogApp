package com.example.daniel.blogapp.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.daniel.blogapp.view.MainIView;
import com.example.daniel.blogapp.view.SignupIView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login {
    private FirebaseAuth firebaseAuth;

    public Login() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public boolean isUserLogged() {
        if (firebaseAuth != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getCurreontUser() {
        if (firebaseAuth != null) {
            return firebaseAuth.getCurrentUser().getEmail();
        } else {
            return "Failed to get email";
        }
    }

    public void loginFromMain(final String email, String password, MainIView mainIView, final MainPresenter mainPresenter) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) mainIView, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mainPresenter.userLoggedIn();
                        } else {
                            mainPresenter.failedAuth();
                        }
                    }
                });
    }

    public void loginAfterSignup(final String email, String password, SignupIView signupIView, final SignupPresenter signupPresenter) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) signupIView, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            signupPresenter.loginSuccess();
                        }
                    }
                });
    }

    public void logout() {
        firebaseAuth.signOut();
    }
}
