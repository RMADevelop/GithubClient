package com.example.romanm.githubclient.presentation.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.romanm.githubclient.R;
import com.example.romanm.githubclient.presentation.ui.fragment.ReposFragment;
import com.example.romanm.githubclient.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
        if (fragment == null) {
            fragment = ReposFragment.newInstance();
            ActivityUtils.setFragment(getSupportFragmentManager(), fragment, R.id.main_container);
        }

    }

}
