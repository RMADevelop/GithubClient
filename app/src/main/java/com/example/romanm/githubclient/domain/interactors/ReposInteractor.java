package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.repository.ReposRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */

public interface ReposInteractor {

    Single<List<Repos>> getRepos();
}
