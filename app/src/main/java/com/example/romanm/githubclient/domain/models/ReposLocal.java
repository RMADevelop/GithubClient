package com.example.romanm.githubclient.domain.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by RomanM on 06.11.2017.
 */
@Entity
public class ReposLocal {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int idRepos;

    public String name;


    public ReposLocal(int idRepos, String name) {
        this.idRepos = idRepos;
        this.name = name;
    }

    public int getIdRepos() {
        return idRepos;
    }

    public void setIdRepos(int idRepos) {
        this.idRepos = idRepos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
