package com.example.romanm.githubclient.repository;

import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */

public interface ReposRepository {
    Maybe<List<ItemReposDomain>> loadRepos(int start, int limit,int idLastLoadRepos);

}
