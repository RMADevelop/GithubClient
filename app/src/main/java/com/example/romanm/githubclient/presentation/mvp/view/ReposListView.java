package com.example.romanm.githubclient.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.presentation.mvp.model.ReposPresentation;

import java.util.List;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface ReposListView extends MvpView {

    void addItemsInAdapter(List<ReposPresentation> list);

    void showError(boolean state);

    void showProgress(boolean state);
}
