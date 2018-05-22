package com.example.ekta.github

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseWrapper {

    @SerializedName("total_count")
    @Expose
    var totalCount : String?=null

    @SerializedName("incomplete_results")
    @Expose
    var incompleteResults : Boolean?=null

    @SerializedName("items")
    @Expose
    var dataList : List<Repo>?=null

}