package com.example.tweetsearcher.Base;

import com.example.tweetsearcher.Views.MainView;

public abstract class BasePresenter<T extends BaseView> {

    private T baseView;

    public BasePresenter(T view) {
        this.baseView = view;
    }

    public T getView() {
        return baseView;
    }

    protected abstract void onCreated();

    public void showNoInternetMessage(){
        getView().showToast("Please check your internet conenction");
    }
}
