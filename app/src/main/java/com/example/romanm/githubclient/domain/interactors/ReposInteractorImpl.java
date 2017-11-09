package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.repository.ReposRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

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
    public Maybe<List<ItemReposDomain>> getRepos(int start, int limit) {

        return reposRepository.loadRepos(start,limit);
    }

}
