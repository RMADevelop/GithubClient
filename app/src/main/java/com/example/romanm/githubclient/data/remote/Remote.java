package com.example.romanm.githubclient.data.remote;

import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

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
    public Single<List<Repos>> loadRepos() {
        return service.getItems();
    }


}
