package com.example.romanm.githubclient.data.remote.model.mapper;

import com.example.romanm.githubclient.data.local.model.ReposLocal;
import com.example.romanm.githubclient.data.remote.model.Repos;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by RomanM on 09.11.2017.
 */

public class RemoteToLocalMapper {
    @Inject
    public RemoteToLocalMapper() {
    }

    public ReposLocal transform(Repos repos) {
        ReposLocal reposLocal = null;

        if (repos != null) {
            reposLocal = new ReposLocal(
                    repos.getId(),
                    repos.getName()
            );
        }
        return reposLocal;
    }

    public List<ReposLocal> transform(List<Repos> list) {
        List<ReposLocal> reposLocalList = new ArrayList<>();
        for (Repos repos : list) {
            reposLocalList.add(transform(repos));
        }
        return reposLocalList;
    }
}
