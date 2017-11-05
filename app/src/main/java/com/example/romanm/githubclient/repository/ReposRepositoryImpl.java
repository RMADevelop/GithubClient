package com.example.romanm.githubclient.repository;

import com.example.romanm.githubclient.data.local.Local;
import com.example.romanm.githubclient.data.remote.Remote;
import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposRepositoryImpl implements ReposRepository {

    Local local;

    Remote remote;

    @Inject
    public ReposRepositoryImpl(Local local, Remote remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Single<List<Repos>> loadRepos() {
        return remote.loadRepos();
    }
}
