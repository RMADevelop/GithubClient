package com.example.romanm.githubclient.data.remote;

import com.example.romanm.githubclient.data.remote.model.Repos;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface RemoteSource {

    Maybe<List<Repos>> loadRepos(int idLastLoadRepos);
}
