package com.example.daniel.blogapp.presenter;

import com.example.daniel.blogapp.view.BlogIView;

public class BlogPresenter {
    BlogIView blogIView;
    Login login;

    public BlogPresenter() {
        login = new Login();
    }

    public void attach(BlogIView blogIView) {
        this.blogIView = blogIView;
    }

    public void detach() {
        this.blogIView = null;
    }

    public String getCurrentUser() {
        return login.getCurrentUser();
    }

    public void logoutButtonClicked() {
        login.logout();
    }

    public boolean checkIfLoggedIn() {
        return login.isUserLogged();
    }
}
