package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.ItemReposDomain;

import java.util.List;

import io.reactivex.Maybe;

/**
 * Created by RomanM on 04.11.2017.
 */

public interface ReposInteractor {

    Maybe<List<ItemReposDomain>> getRepos();
}
