package com.example.romanm.githubclient.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.githubclient.domain.interactors.ReposInteractor;
import com.example.romanm.githubclient.domain.interactors.ReposInteractorImpl;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.presentation.mvp.model.ReposPresentation;
import com.example.romanm.githubclient.presentation.mvp.model.mapper.DomainToPresenterMapper;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by RomanM on 04.11.2017.
 */
@InjectViewState
public class ReposPresenterImpl extends MvpPresenter<ReposListView> implements ReposPresenter {

    ReposInteractor reposInteractor;

    private DomainToPresenterMapper domainToPresenterMapper;

    @Inject
    public ReposPresenterImpl(ReposInteractorImpl reposInteractor, DomainToPresenterMapper mapper) {
        this.reposInteractor = reposInteractor;
        this.domainToPresenterMapper = mapper;
    }


    @Override
    public void getRepos() {
        reposInteractor.getRepos()
                .toSingle()
                .map(itemReposDomains -> domainToPresenterMapper.transform(itemReposDomains))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ReposPresentation>>() {
                    @Override
                    public void onSuccess(List<ReposPresentation> itemReposDomains) {
                        getViewState().addItemsInAdapter(itemReposDomains);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        getViewState().showError(true);
                    }
                });

    }


}
