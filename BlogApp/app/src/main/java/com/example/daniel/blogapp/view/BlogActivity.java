package com.example.daniel.blogapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.daniel.blogapp.R;
import com.example.daniel.blogapp.presenter.Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlogActivity extends AppCompatActivity {

    @BindView(R.id.loginBlogTextView)
    TextView loginBlogTextView;
    @BindView(R.id.logoutBlogButton)
    Button logoutBlogButton;

    Login login;
    Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ButterKnife.bind(this);
        mainIntent = new Intent(BlogActivity.this, MainActivity.class);
        login = new Login();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginBlogTextView.setText(login.getCurreontUser());
    }

    @OnClick(R.id.logoutBlogButton)
    public void onViewClicked() {
        login.logout();
        startActivity(mainIntent);
    }
}
