package com.example.romanm.githubclient.domain.models;

/**
 * Created by RomanM on 09.11.2017.
 */

public class ItemReposDomain {


    private int idRepos;
    private String name;

    public ItemReposDomain() {
    }

    public ItemReposDomain(int idRepos, String name) {
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

