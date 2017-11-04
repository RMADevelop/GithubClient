package com.example.romanm.githubclient.di.component;

import com.example.romanm.githubclient.di.modules.ContextModule;
import com.example.romanm.githubclient.di.modules.DataModule;
import com.example.romanm.githubclient.presentation.ui.activity.MainActivity;
import com.example.romanm.githubclient.presentation.ui.fragment.ReposFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by RomanM on 04.11.2017.
 */
@Singleton
@Component(modules = {ContextModule.class, DataModule.class})
public interface AppComponent {

    void inject(ReposFragment reposFragment);

    void inject(MainActivity mainActivity);
}
