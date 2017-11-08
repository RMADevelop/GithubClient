package com.example.romanm.githubclient.presentation.mvp.presenter;

import android.arch.persistence.room.EmptyResultSetException;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.romanm.githubclient.domain.interactors.ReposInteractor;
import com.example.romanm.githubclient.domain.interactors.ReposInteractorImpl;
import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.domain.models.ReposLocal;
import com.example.romanm.githubclient.presentation.mvp.view.ReposListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 04.11.2017.
 */
@InjectViewState
public class ReposPresenterImpl extends MvpPresenter<ReposListView> implements IReposPresenter {

    ReposInteractor reposInteractor;

    @Inject
    public ReposPresenterImpl(ReposInteractorImpl reposInteractor) {
        this.reposInteractor = reposInteractor;
    }


    @Override
    public void getRepos(int start, int limit) {
        reposInteractor.getRepos(start, limit)
                .flatMapSingle(new Function<List<ReposLocal>, SingleSource<List<ReposLocal>>>() {
                    @Override
                    public SingleSource<List<ReposLocal>> apply(List<ReposLocal> reposLocals) throws Exception {
                        return Single.just(reposLocals);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribeWith(new DisposableSingleObserver<List<ReposLocal>>() {
                    @Override
                    public void onSuccess(List<ReposLocal> repos) {
                        Log.d(TAG, "onSuccess() called with: repos = [" + repos + "]");
                        getViewState().addItemsInAdapter(repos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void getItems(int start, int limit) {
        reposInteractor.getItems(0, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ReposLocal>>() {
                    @Override
                    public void onSuccess(List<ReposLocal> reposLocals) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });


//        reposInteractor.getItems(start, limit)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<List<ReposLocal>>() {
//                    @Override
//                    public void onSuccess(List<ReposLocal> reposLocals) {
//                        if (reposLocals.size() == 0) {
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//e.printStackTrace();
//                    }
//                });
    }
}
