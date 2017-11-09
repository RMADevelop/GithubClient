package com.example.romanm.githubclient.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.romanm.githubclient.data.local.model.ReposLocal;


@Database(entities = {ReposLocal.class}, version = 1)
public abstract class LocalDataRoom extends RoomDatabase {

    public abstract LocalRoomDAO getDAO();


}
