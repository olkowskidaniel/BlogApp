package com.example.daniel.blogapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.daniel.blogapp.R;
import com.example.daniel.blogapp.presenter.BlogPresenter;
import com.example.daniel.blogapp.presenter.Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlogActivity extends AppCompatActivity implements BlogIView{

    @BindView(R.id.loginBlogTextView)
    TextView loginBlogTextView;
    @BindView(R.id.logoutBlogButton)
    Button logoutBlogButton;

    Intent mainIntent;
    BlogPresenter blogPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ButterKnife.bind(this);
        mainIntent = new Intent(BlogActivity.this, MainActivity.class);
        blogPresenter = new BlogPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        blogPresenter.attach(this);
        loginBlogTextView.setText(blogPresenter.getCurrentUser());
        if(blogPresenter.checkIfLoggedIn()) {
            return;
        } else {
            startActivity(mainIntent);
        }
    }

    @Override
    protected void onDestroy() {
        blogPresenter.detach();
        super.onDestroy();
    }

    @OnClick(R.id.logoutBlogButton)
    public void onViewClicked() {
        blogPresenter.logoutButtonClicked();
        startActivity(mainIntent);
    }
}
