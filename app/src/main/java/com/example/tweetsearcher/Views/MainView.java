package com.example.tweetsearcher.Views;

import com.example.tweetsearcher.Base.BaseView;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

public interface MainView extends BaseView {
    void setTweets(List<Tweet> tweets);
}
