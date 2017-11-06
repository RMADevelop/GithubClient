package com.example.romanm.githubclient.data.local;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class Local implements LocalSource {

    LocalRoomDAO dao;

    @Inject
    public Local(LocalRoomDAO dao) {
        this.dao = dao;
    }


    @Override
    public Single<List<ReposLocal>> getItems() {
        return null;
    }



    @Override
    public void saveItem(ReposLocal item) {
        dao.saveItem(item);
    }
}
