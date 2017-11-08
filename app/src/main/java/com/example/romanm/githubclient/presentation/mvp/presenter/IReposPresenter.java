package com.example.romanm.githubclient.presentation.mvp.presenter;

import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 05.11.2017.
 */

public interface IReposPresenter {

    void getRepos(int start,int limit);

    void getItems(int start, int limit);
}
