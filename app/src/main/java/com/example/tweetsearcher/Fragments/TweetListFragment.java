package com.example.tweetsearcher.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tweetsearcher.Base.BaseFragment;
import com.example.tweetsearcher.ListAdapter.TweetListAdapter;
import com.example.tweetsearcher.R;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.List;


public class TweetListFragment extends BaseFragment {



    private RecyclerView recyclerView;
    private TweetListAdapter tweetListAdapter;
    private List<Tweet> tweets  = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.layout_tweet_list, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tweetListAdapter = new TweetListAdapter(tweets);
        recyclerView.setAdapter(tweetListAdapter);
        return rootView;
    }

    public void setTweets(List<Tweet> tweets){
        this.tweets.clear();
        this.tweets.addAll(tweets);
        tweetListAdapter.notifyDataSetChanged();
    }


    public void scrollToUp() {
        if(recyclerView.getChildCount() > 0){
            recyclerView.scrollToPosition(0);
        }

    }
}
