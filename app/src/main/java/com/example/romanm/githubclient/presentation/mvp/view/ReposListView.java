package com.example.romanm.githubclient.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.githubclient.domain.models.Repos;
import com.example.romanm.githubclient.domain.models.ReposLocal;

import java.util.List;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface ReposListView extends MvpView {

    void addItemsInAdapter(List<ReposLocal> list);
}
