package com.example.romanm.githubclient.domain.interactors;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.presentation.mvp.presenter.ReposPresenter;
import com.example.romanm.githubclient.repository.ReposRepository;
import com.example.romanm.githubclient.repository.ReposRepositoryImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposInteractorImpl implements ReposInteractor {

    ReposRepositoryImpl reposRepository;

    public ReposInteractorImpl(ReposRepositoryImpl reposRepository) {
        this.reposRepository = reposRepository;
    }

    @Override
    public Single<Item> checkDb() {
        return null;
    }

    @Override
    public void saveItem(Item item) {
        reposRepository.saveItem(item);
    }
}
