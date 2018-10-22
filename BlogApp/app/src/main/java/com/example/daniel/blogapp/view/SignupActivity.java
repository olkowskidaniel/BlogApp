package com.example.daniel.blogapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.daniel.blogapp.R;
import com.example.daniel.blogapp.presenter.SignupPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends Activity implements SignupIView{

    @BindView(R.id.nameSignupEditText)
    EditText nameSignupEditText;
    @BindView(R.id.lastnameSignupEditText)
    EditText lastnameSignupEditText;
    @BindView(R.id.emailSignupEditText)
    EditText emailSignupEditText;
    @BindView(R.id.passwordSignupEditText)
    EditText passwordSignupEditText;
    @BindView(R.id.rePasswordSignupEditText)
    EditText rePasswordSignupEditText;
    @BindView(R.id.createSignupButton)
    Button createSignupButton;

    SignupPresenter signupPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        signupPresenter = new SignupPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        signupPresenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signupPresenter.detach();
    }

    @OnClick(R.id.createSignupButton)
    public void onViewClicked() {
    }
}
