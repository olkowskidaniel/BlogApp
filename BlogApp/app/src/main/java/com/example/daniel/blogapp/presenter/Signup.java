package com.example.daniel.blogapp.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.daniel.blogapp.view.SignupIView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup {
    FirebaseAuth firebaseAuth;

    public Signup() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void createAccount(final String email, final String password, SignupIView signupIView, final SignupPresenter signupPresenter) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) signupIView, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            signupPresenter.accountCreateSuccess(email, password);
                        } else {
                            signupPresenter.accountCreateFailed();
                        }
                    }
                });
    }
}
