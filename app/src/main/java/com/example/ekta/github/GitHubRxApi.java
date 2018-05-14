package com.example.ekta.github;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Grappus on 11/05/18.
 */

public interface GitHubRxApi {

    @GET("search/repositories")
    Observable<ResponseWrapper> listRepos(@Query("q") String q);

    @GET("repos/{user}/{repo}/contributors")
    Observable<List<String/*Contributer*/>> listRepoContributors(
            @Path("user") String user,
            @Path("repo") String repo);

}
