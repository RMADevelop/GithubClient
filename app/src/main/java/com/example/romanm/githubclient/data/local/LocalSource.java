package com.example.romanm.githubclient.data.local;

import com.example.romanm.githubclient.domain.models.Item;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface LocalSource  {

    Single<List<ReposLocal>> getItems();

    void saveItem(ReposLocal item);
}
