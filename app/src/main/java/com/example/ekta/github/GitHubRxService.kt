package com.example.ekta.github

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



class GitHubRxService internal constructor() {

    private val gitHubApi: GitHubRxApi

    init {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        // add your other interceptors … set custom headers
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val builder = original.newBuilder()/*.header(HEADER_CONTENT_TYPE, contentType)*/

            builder.method(original.method(), original.body())
            val request = builder.build()

            chain.proceed(request)
        }
        // add logging as last interceptor
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()

        gitHubApi = retrofit.create(GitHubRxApi::class.java)
    }


    internal fun getTopContributors(userName: String): Observable<ResponseWrapper> {
        return gitHubApi.listRepos(userName)
        //                .flatMap(repo -> gitHubA/*pi.listRepoContributors(userName, repo.getName()))
        //                .flatMapIterable(x -> x)
        //                .filter(c -> c.getContributions() > 100)
        //                .sorted((a, b) -> b.getContributions() - a.getContributions())
        //                .map(Contributor::getName)*/

    }

}
