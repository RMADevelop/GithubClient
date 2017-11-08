package com.example.romanm.githubclient.data.remote;

import android.util.Log;

import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 03.11.2017.
 */
@Singleton
public class Remote implements RemoteSource {

    Service service;

    @Inject
    public Remote(Service service) {
        this.service = service;
    }

    @Override
    public Maybe<List<Repos>> loadRepos() {
        Log.d(TAG, "loadRepos()hhhhhhhhhhhhhhhhhhhhhhhhhhh called");
        return service.getItems();
    }


}
