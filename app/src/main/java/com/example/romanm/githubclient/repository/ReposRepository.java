package com.example.romanm.githubclient.repository;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.Repos;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 04.11.2017.
 */

public interface ReposRepository {
    Single<List<Repos>> getRepos();

    void saveItem(Item item);
}
