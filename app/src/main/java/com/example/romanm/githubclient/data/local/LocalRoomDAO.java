package com.example.romanm.githubclient.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.romanm.githubclient.domain.models.Item;

import io.reactivex.Single;


@Dao
public interface LocalRoomDAO  {


    @Insert
    void saveItem(Item item);

    @Query("SELECT * FROM Item WHERE id LIKE 1")
    Single<Item> checkDB();
}
//