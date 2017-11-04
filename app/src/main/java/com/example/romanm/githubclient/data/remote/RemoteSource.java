package com.example.romanm.githubclient.data.remote;

import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface RemoteSource {

    Single<List<Repos>> getRepos();
}
