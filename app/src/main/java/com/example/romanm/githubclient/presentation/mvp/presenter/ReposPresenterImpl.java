package com.example.romanm.githubclient.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.githubclient.domain.interactors.ReposInteractor;
import com.example.romanm.githubclient.domain.interactors.ReposInteractorImpl;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 04.11.2017.
 */
@InjectViewState
public class ReposPresenterImpl extends MvpPresenter<ReposListView> implements ReposPresenter {

    ReposInteractor reposInteractor;

    @Inject
    public ReposPresenterImpl(ReposInteractorImpl reposInteractor) {
        this.reposInteractor = reposInteractor;
    }


    @Override
    public void getRepos() {
        reposInteractor.getRepos()
                .toSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ItemReposDomain>>() {
                    @Override
                    public void onSuccess(List<ItemReposDomain> itemReposDomains) {
                        getViewState().addItemsInAdapter(itemReposDomains);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }


}
