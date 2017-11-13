package com.example.romanm.githubclient.presentation.mvp.model;

/**
 * Created by RomanM on 13.11.2017.
 */

public class ReposPresentation {
    private int id;
    private String name;

    public ReposPresentation() {
    }

    public ReposPresentation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
