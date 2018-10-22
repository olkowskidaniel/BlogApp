package com.example.daniel.blogapp.view;

public interface MainIView {
    void openSignupActivity();
    void openBlogActivity();
    void showEmptyFieldMessage(String message);
    void showFailedAuthErrorMessage(String message);
}
