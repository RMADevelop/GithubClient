package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.repository.ReposRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.functions.Consumer;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposInteractorImpl implements ReposInteractor {

    private final int limit = 100;
    private int cursor;
    private int idLastLoadRepos;

    private ReposRepositoryImpl reposRepository;

    @Inject
    public ReposInteractorImpl(ReposRepositoryImpl reposRepository) {
        this.reposRepository = reposRepository;
    }

    @Override
    public Maybe<List<ItemReposDomain>> getRepos() {

        Maybe<List<ItemReposDomain>> reposList = reposRepository.loadRepos(cursor, limit,idLastLoadRepos)
                .doOnSuccess(this::getLastReposId);

        cursorNext();

        return reposList;
    }

    private void cursorNext() {
        cursor += limit;
    }

    private void getLastReposId(List<ItemReposDomain> list) {
        idLastLoadRepos = list.get(list.size() - 1).getIdRepos();
    }

}
