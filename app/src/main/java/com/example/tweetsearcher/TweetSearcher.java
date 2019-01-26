package com.example.tweetsearcher;

import android.util.Log;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetSearcher {


    private TwitterCore twitterCore = TwitterCore.getInstance();
    private TwitterApiClient twitterClient = twitterCore.getGuestApiClient();

    public interface Listener{
        void onFetchedTweets(List<Tweet> tweetList);
        void onFailedToFetchTweets(String errorMessage);
    }

    private Listener listener;

    public TweetSearcher(Listener listener){
        this.listener = listener;
    }


    public void getTweets(Filter filter){

        twitterClient.getSearchService().tweets(filter.getQuery(),null,filter.getLang(),null,null,filter.getCount(),filter.getUntil(),null,null,null)
                .enqueue(new Callback<Search>() {
                    @Override
                    public void onResponse(Call<Search> call, Response<Search> response) {
                        if(response.isSuccessful() && response.body() != null){
                            listener.onFetchedTweets(response.body().tweets);
                        }
                        else
                        {
                            listener.onFailedToFetchTweets("Incorrect response received.");
                        }

                    }

                    @Override
                    public void onFailure(Call<Search> call, Throwable t) {
                        Log.i("HELLO","HELLO");
                        listener.onFailedToFetchTweets(t.getMessage());
                    }
                });
    }

    public static class Filter{
        private String query;
        private String lang;
        private int count;
        private String until;

        public Filter(String query){
            this.query = query;
        }

        public Filter(String query, int count) {
            this.query = query;
            this.count = count;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getUntil() {
            return until;
        }

        public void setUntil(String until) {
            this.until = until;
        }
    }

}
