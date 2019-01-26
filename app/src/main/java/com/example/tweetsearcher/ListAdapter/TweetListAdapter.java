package com.example.tweetsearcher.ListAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tweetsearcher.R;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.ViewHolder> {

    private List<Tweet> tweetList;

    public TweetListAdapter(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    @Override
    public TweetListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet,parent,false));
    }

    @Override
    public void onBindViewHolder(TweetListAdapter.ViewHolder holder, int position) {
         Tweet tweet = tweetList.get(position);
         holder.tweetTextTV.setText(tweet.text);
         holder.tweetCreatorTV.setText(tweet.user.name);
         Picasso.get().load(tweet.user.profileImageUrlHttps).into(holder.tweeterImage);
         holder.tweetLoveCount.setText(""+tweet.favoriteCount);
         holder.retweetCount.setText(""+tweet.retweetCount);

    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private TextView tweetCreatorTV;
        private TextView tweetTextTV;
        private ImageView tweeterImage;
        private TextView tweetLoveCount;
        private TextView retweetCount;

        public ViewHolder(View itemView) {
            super(itemView);

            tweetCreatorTV = itemView.findViewById(R.id.tweet_creator_name);
            tweetTextTV = itemView.findViewById(R.id.tweet_text);
            tweeterImage = itemView.findViewById(R.id.tweeter_image);
            tweetLoveCount = itemView.findViewById(R.id.tweet_love_count);
            retweetCount = itemView.findViewById(R.id.tweet_retweet_count);

        }
    }
}
