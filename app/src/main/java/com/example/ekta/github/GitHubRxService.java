package com.example.ekta.github;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Grappus on 11/05/18.
 */

public class GitHubRxService {

    private GitHubRxApi gitHubApi;

    GitHubRxService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        gitHubApi = retrofit.create(GitHubRxApi.class);
    }



    Observable<ResponseWrapper> getTopContributors(String userName) {
        return gitHubApi.listRepos(userName);
//                .flatMap(repo -> gitHubA/*pi.listRepoContributors(userName, repo.getName()))
//                .flatMapIterable(x -> x)
//                .filter(c -> c.getContributions() > 100)
//                .sorted((a, b) -> b.getContributions() - a.getContributions())
//                .map(Contributor::getName)*/

    }

}
