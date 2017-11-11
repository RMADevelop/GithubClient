package com.example.romanm.githubclient.data.remote;

import com.example.romanm.githubclient.data.remote.model.Repos;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RomanM on 03.11.2017.
 */

public interface Service {

    @GET("repositories")
    Maybe<List<Repos>> getItems(@Query("since") int idLastRepos);
}
