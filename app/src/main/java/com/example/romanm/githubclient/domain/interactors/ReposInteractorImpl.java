package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.ReposLocal;
import com.example.romanm.githubclient.repository.ReposRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposInteractorImpl implements ReposInteractor {

    ReposRepositoryImpl reposRepository;

    @Inject
    public ReposInteractorImpl(ReposRepositoryImpl reposRepository) {
        this.reposRepository = reposRepository;
    }

    @Override
    public Maybe<List<ReposLocal>> getRepos(int start,int limit) {

        return reposRepository.loadRepos(start,limit);
    }

    @Override
    public Single<List<ReposLocal>> getItems(int start, int limit) {
        return reposRepository.getItems(start, limit);
    }
}
