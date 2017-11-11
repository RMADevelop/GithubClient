package com.example.romanm.githubclient.repository;

import android.util.Log;

import com.example.romanm.githubclient.data.local.Local;
import com.example.romanm.githubclient.data.local.model.mapper.LocalToDomainMapper;
import com.example.romanm.githubclient.data.remote.Remote;
import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.data.remote.model.Repos;
import com.example.romanm.githubclient.data.remote.model.mapper.RemoteToLocalMapper;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

import static android.content.ContentValues.TAG;

/**
 * Created by RomanM on 04.11.2017.
 */
public class ReposRepositoryImpl implements ReposRepository {

    Local local;

    Remote remote;

    private LocalToDomainMapper localToDomainMapper;

    private RemoteToLocalMapper remoteToLocalMapper;

    @Inject
    public ReposRepositoryImpl(Local local, Remote remote, LocalToDomainMapper localToDomainMapper, RemoteToLocalMapper remoteToLocalMapper) {
        this.local = local;
        this.remote = remote;
        this.localToDomainMapper = localToDomainMapper;
        this.remoteToLocalMapper = remoteToLocalMapper;
    }


    @Override
    public Maybe<List<ItemReposDomain>> loadRepos(int start, int limit, int idLastLoadRepos) {

        Maybe<List<ReposLocal>> remoteList = remote.loadRepos(idLastLoadRepos)
                .map(list -> remoteToLocalMapper.transform(list))
                .doOnSuccess(reposLocals -> local.saveItems(reposLocals));


        Maybe<List<ReposLocal>> localList = local.getItems(start, limit)
                .flatMap(list -> {
                    if (list.isEmpty()) {
                        return remoteList;
                    }
                    return Maybe.just(list);
                });

        Log.d(TAG, "loadRepos() before concat called");
        return Maybe.concat(localList, remoteList)
                .firstElement()
                .map(reposLocals -> localToDomainMapper.transform(reposLocals));
    }


}
