package com.example.romanm.githubclient.presentation.mvp.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.githubclient.domain.interactors.ReposInteractor;
import com.example.romanm.githubclient.domain.interactors.ReposInteractorImpl;
import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 04.11.2017.
 */
@InjectViewState
public class ReposPresenter extends MvpPresenter<ReposListView> {

    ReposInteractor reposInteractor;

    public ReposPresenter(ReposInteractorImpl reposInteractor) {
        this.reposInteractor = reposInteractor;
    }

    public void saveItems() {
        Completable.fromAction(() -> {
            for (int i = 0; i < 10; i++) {
                reposInteractor.saveItem(new Item());
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe(() -> Log.v("DFSD", "complete"),
                        Throwable::printStackTrace);
    }
}
