package com.example.tweetsearcher.Base;

public interface BaseView {
    void showToast(String message);
    void showProgressDialog(String message,boolean indeterminate,boolean cancellable);
    void hideProgressDialog();
    void dismissKeyBoard();
    boolean isNetworkAvailable();
}
