package com.example.daniel.blogapp.view;

public interface SignupIView {
    void showEmptyFieldMessage(String message);
    void showPasswordsDontMatchMessage(String message);
    void showAccountCreatedMessage(String message);
    void showAccountCreateFailedMessage(String message);
    void openBlogActivity();
}
