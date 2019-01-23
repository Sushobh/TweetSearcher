package com.example.tweetsearcher;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);
    }

}
