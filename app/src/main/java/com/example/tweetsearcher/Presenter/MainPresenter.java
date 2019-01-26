package com.example.tweetsearcher.Presenter;

import com.example.tweetsearcher.Base.BasePresenter;
import com.example.tweetsearcher.Base.BaseView;
import com.example.tweetsearcher.TweetSearcher;
import com.example.tweetsearcher.Views.MainView;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements TweetSearcher.Listener {

    private boolean isRequestGoingOn = false;
    private TweetSearcher tweetSearcher;
    private TweetSearcher.Filter tweetFilter;
    private static final int DEFAULT_COUNT_OF_TWEETS_LOADED = 50;

    public MainPresenter(MainView baseView) {
        super(baseView);
        tweetSearcher = new TweetSearcher(this);
        tweetFilter = new TweetSearcher.Filter("Donald Trump",DEFAULT_COUNT_OF_TWEETS_LOADED);
    }

    @Override
    public void onCreated() {
        getView().showProgressDialog("Please wait",true,false);
        searchForTweets(tweetFilter);
    }

    private void searchForTweets(TweetSearcher.Filter filter) {
        if( getView().isNetworkAvailable()){
            tweetSearcher.getTweets(filter);
        }
        else
        {
            showNoInternetMessage();
        }
    }

    @Override
    public void onFetchedTweets(List<Tweet> tweetList) {
        getView().setTweets(tweetList);
        getView().hideProgressDialog();
        isRequestGoingOn = false;
    }

    @Override
    public void onFailedToFetchTweets(String errorMessage) {
        getView().hideProgressDialog();
        isRequestGoingOn = false;
        getView().showToast("Something went wrong");
    }

    public void onQuerySubmitted(String query){
        getView().dismissKeyBoard();
        if(!query.isEmpty() && !isRequestGoingOn){
            tweetFilter.setQuery(query);
            searchForTweets(tweetFilter);
            getView().showProgressDialog("Searching for "+query,true,false);
            isRequestGoingOn = true;
        }

    }

    public void clickedOnFilter() {
        getView().showToast("Clicked on filter");
    }
}
