package com.example.daniel.blogapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.daniel.blogapp.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.loginMainButton, R.id.signupMainButton, R.id.exitMainButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginMainButton:
                break;
            case R.id.signupMainButton:
                break;
            case R.id.exitMainButton:
                break;
        }
    }
}

