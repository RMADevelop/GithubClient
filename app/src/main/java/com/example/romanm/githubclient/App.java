package com.example.romanm.githubclient;

import android.app.Application;

import com.example.romanm.githubclient.di.component.AppComponent;
import com.example.romanm.githubclient.di.component.DaggerAppComponent;
import com.example.romanm.githubclient.di.modules.ContextModule;

/**
 * Created by RomanM on 04.11.2017.
 */

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
//                .dataModule(new DataModule(ApiConstantse.API_GITHUB))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
