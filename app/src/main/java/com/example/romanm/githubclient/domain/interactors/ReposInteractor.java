package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */

public interface ReposInteractor {

    Maybe<List<ReposLocal>> getRepos(int start,int limit);

    Single<List<ReposLocal>> getItems(int start, int limit);
}
