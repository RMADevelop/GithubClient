package com.example.romanm.githubclient.data.local;

import android.util.Log;

import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;

import static android.content.ContentValues.TAG;

@Singleton
public class Local implements LocalSource {

    LocalRoomDAO dao;

    @Inject
    public Local(LocalRoomDAO dao) {
        this.dao = dao;
    }


    @Override
    public Maybe<List<ReposLocal>> getItems(int start, int limit) {
        Log.d(TAG, "getItems() called with: start = [" + start + "], limit = [" + limit + "]");
        return dao.getItems(start,limit);
    }

    @Override
    public Maybe<List<ReposLocal>> getAll() {
        return dao.getAll();
    }

    @Override
    public Single<List<ReposLocal>> getItem(int start, int limit) {
        return dao.getItem(start, limit);
    }


    @Override
    public void saveItem(ReposLocal item) {
        dao.saveItem(item);
    }
}
