package com.example.ekta.github

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.KeyEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.inputmethod.EditorInfo


class MainActivity : AppCompatActivity() {

    lateinit var searchViewmodel: SearchViewModel
    lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpAdapter()
        etSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(v.text.toString())
                    return true
                }
                return false
            }
        })

        searchViewmodel = ViewModelProviders.of(this).get(SearchViewModel::class.java)


        searchViewmodel.response().observe(this,
                Observer { response -> processResponse(response?.data) })


    }

    private fun processResponse(response: List<Repo>?) {

        Log.i("got data", "" + response?.size)

        adapter.updateList(response as ArrayList<Repo>)


    }

    private fun setUpAdapter() {
        rvResults.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        rvResults.adapter = adapter
    }

    private fun performSearch(searchText: String) {
        /* searchViewmodel?.getDataToBeSearch(searchText)
                 ?.subscribeOn(Schedulers.io())
                 ?.observeOn(AndroidSchedulers.mainThread())?.
                 subscribe({ success -> Log.i("Success", "got it") },
                         { error -> Log.i("Error", "error alert") })
         */
        searchViewmodel?.searchKeyword(searchText)
    }
}
