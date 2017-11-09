package com.example.romanm.githubclient.data.local;

import com.example.romanm.githubclient.data.local.model.ReposLocal;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface LocalSource {

    Maybe<List<ReposLocal>> getItems(int start, int limit);

    Maybe<List<ReposLocal>> getAll();

    Single<List<ReposLocal>> getItem(int start, int limit);


    void saveItem(ReposLocal item);

    void saveItems(List<ReposLocal> list);
}
