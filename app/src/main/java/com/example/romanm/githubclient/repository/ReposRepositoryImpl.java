package com.example.romanm.githubclient.repository;

import android.util.Log;

import com.example.romanm.githubclient.data.local.Local;
import com.example.romanm.githubclient.data.remote.Remote;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposRepositoryImpl implements ReposRepository {

    Local local;

    Remote remote;

    @Inject
    public ReposRepositoryImpl(Local local, Remote remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Maybe<List<ReposLocal>> loadRepos(int  start, int limit) {
        Maybe<List<ReposLocal>> localList = local.getItems(start,limit);


        Maybe<List<ReposLocal>> remoteList = remote.loadRepos()
                .flatMapObservable(Observable::fromIterable)
                .map(repos -> new ReposLocal(repos.getId(),repos.getName()))
                .doOnNext(reposLocal -> local.saveItem(reposLocal))
                .toList()
                .toMaybe();

        Log.d(TAG, "loadRepos() called");
        return Maybe.concat(remoteList,localList)
                .firstElement();



//        return remote.loadRepos();
    }

    @Override
    public Single<List<ReposLocal>> getItems(int start, int limit) {
        return local.getItem(start, limit);
    }
}
