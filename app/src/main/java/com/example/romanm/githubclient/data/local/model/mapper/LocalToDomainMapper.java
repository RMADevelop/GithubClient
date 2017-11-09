package com.example.romanm.githubclient.data.local.model.mapper;

import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.domain.models.ItemReposDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 09.11.2017.
 */

public class LocalToDomainMapper {

    @Inject
    public LocalToDomainMapper() {
    }

    public ItemReposDomain transform(ReposLocal reposLocal) {
        ItemReposDomain itemReposDomain = null;
        if (reposLocal != null) {
            itemReposDomain = new ItemReposDomain(
                    reposLocal.getIdRepos(),
                    reposLocal.getName()
            );
        }
        return itemReposDomain;
    }

    public List<ItemReposDomain> transform(List<ReposLocal> list) {
        List<ItemReposDomain> domainList = new ArrayList<>();
        for (ReposLocal reposLocal : list) {
            if (reposLocal != null) {
                domainList.add(transform(reposLocal));
            }
        }
        return domainList;
    }
}
