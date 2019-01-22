package com.example.tweetsearcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tweetsearcher.Base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
