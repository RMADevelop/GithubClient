package com.example.romanm.githubclient.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface LocalRoomDAO  {


    @Insert
    void saveItem(ReposLocal repos);

    @Query("SELECT * FROM ReposLocal LIMIT :start, :limit")
    Single<List<ReposLocal>> getItems(int start, int limit);


}
//