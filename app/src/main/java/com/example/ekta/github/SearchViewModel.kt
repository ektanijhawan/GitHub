package com.example.ekta.github

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class SearchViewModel : ViewModel() {


    private val disposables = CompositeDisposable()

    private var response = MutableLiveData<Response>()


    var observable: Observable<String>? = null


    /*fun getDataToBeSearch(searchKeyword: String): Observable<String> {

        *//*io.reactivex.Observable.just(searchKeyword)
                .subscribe({ s -> System.out.println(s) })*//*

        *//* observable?.subscribeOn(Schedulers.io())
         observable?.observeOn(AndroidSchedulers.mainThread())*//*

        return GitHubRxService().getTopContributors(searchKeyword);
    }*/

    override fun onCleared() {
        disposables.clear()
    }

    fun response(): MutableLiveData<Response> {
        return response
    }

    fun searchKeyword(searchKeyword: String) {
        loadData(searchKeyword)
    }


    private fun loadData(searchKeyword: String) {
        disposables.add(
                GitHubRxService().getTopContributors(searchKeyword)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
//                        .doOnSubscribe({ __ -> response.setValue(Response.loading()) })
                        .subscribe(
                                { greeting -> response.setValue(Response.success(greeting.dataList/*greeting.dataList?.size.toString()*/)) },
                                { throwable -> response.setValue(Response.error(throwable)) }
                        )
        )
    }

}