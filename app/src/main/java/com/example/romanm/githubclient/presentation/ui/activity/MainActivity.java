package com.example.romanm.githubclient.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.romanm.githubclient.App;
import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.presentation.mvp.presenter.ReposPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ReposPresenter reposPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);

    }
}
