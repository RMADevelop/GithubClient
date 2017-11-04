package com.example.romanm.githubclient.repository;

import com.example.romanm.githubclient.data.local.Local;
import com.example.romanm.githubclient.data.remote.Remote;
import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposRepositoryImpl implements ReposRepository {

    Local local;

    Remote remote;

    public ReposRepositoryImpl(Local local) {
        this.local = local;
//        this.remote = remote;
    }

    @Override
    public Single<List<Repos>> getRepos() {
        return null;
    }

    @Override
    public void saveItem(Item item) {
        local.saveItem(item);
    }
}
