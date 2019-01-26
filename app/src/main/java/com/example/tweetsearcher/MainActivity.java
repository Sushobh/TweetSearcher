package com.example.tweetsearcher;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tweetsearcher.Base.BaseActivity;
import com.example.tweetsearcher.Fragments.TweetListFragment;
import com.example.tweetsearcher.Presenter.MainPresenter;
import com.example.tweetsearcher.Views.MainView;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity implements MainView {


    private TweetListFragment tweetListFragment;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tweetListFragment = (TweetListFragment) getSupportFragmentManager().findFragmentById(R.id.twitter_list_fragment);
        mainPresenter = new MainPresenter(this);
        mainPresenter.onCreated();
    }

    @Override
    protected void onSearchQuerySubmitted(String query) {
        mainPresenter.onQuerySubmitted(query);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setUpSearchInterface(menu,R.menu.main,R.id.search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTweets(List<Tweet> tweets) {
        tweetListFragment.setTweets(tweets);
        tweetListFragment.scrollToUp();
    }
}
