package com.example.daniel.blogapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.blogapp.R;
import com.example.daniel.blogapp.presenter.Login;
import com.example.daniel.blogapp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainIView {

    @BindView(R.id.emailMainEditText)
    EditText emailMainEditText;
    @BindView(R.id.passwordMainEditText)
    EditText passwordMainEditText;
    @BindView(R.id.loginMainButton)
    Button loginMainButton;
    @BindView(R.id.signupMainButton)
    Button signupMainButton;
    @BindView(R.id.exitMainButton)
    Button exitMainButton;

    MainPresenter mainPresenter;
    Intent signupIntent;
    Intent blogIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter();
        signupIntent = new Intent(MainActivity.this, SignupActivity.class);
        blogIntent = new Intent(MainActivity.this, BlogActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attach(this);
        if (mainPresenter.checkIfUserLogged()) {
            startActivity(blogIntent);
        } else {
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detach();
    }

    @OnClick({R.id.loginMainButton, R.id.signupMainButton, R.id.exitMainButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginMainButton:
                mainPresenter.loginButtonClicked(emailMainEditText.getText().toString().trim(), passwordMainEditText.getText().toString().trim());
                break;
            case R.id.signupMainButton:
                mainPresenter.signupButtonClicked();
                break;
            case R.id.exitMainButton:
                mainPresenter.exitApp();
                break;
        }
    }

    public void openSignupActivity() {
        startActivity(signupIntent);
    }

    public void openBlogActivity() {
        startActivity(blogIntent);
    }

    public void showEmptyFieldMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    public void showFailedAuthErrorMessage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}

