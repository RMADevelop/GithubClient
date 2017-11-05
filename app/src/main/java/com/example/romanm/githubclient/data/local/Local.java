package com.example.romanm.githubclient.data.local;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.Repos;

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
    public Single<Repos> getItems() {
        return null;
    }

    @Override
    public Single<Item> checkDb() {
        return dao.checkDB();
    }

    @Override
    public void saveItem(Item item) {
        dao.saveItem(item);
    }
}
