package com.example.romanm.githubclient.presentation.mvp.model.mapper;

import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;
import com.example.romanm.githubclient.presentation.mvp.model.ReposPresentation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 13.11.2017.
 */

public class DomainToPresenterMapper {

    @Inject
    public DomainToPresenterMapper() {
    }

    public ReposPresentation transform(ItemReposDomain reposDomain) {
        ReposPresentation reposPresentation = null;
        if (reposDomain == null) {
            reposPresentation = new ReposPresentation();
            reposPresentation.setId(reposDomain.getIdRepos());
            reposPresentation.setName(reposDomain.getName());
        }
        return reposPresentation;
    }

    public List<ReposPresentation> transform(List<ItemReposDomain> list) {
        List<ReposPresentation> reposPresentationList = new ArrayList<>();
        for (ItemReposDomain itemReposDomain : list) {
            if (itemReposDomain != null) {
                reposPresentationList.add(transform(itemReposDomain));
            }
        }
        return reposPresentationList;
    }
}
