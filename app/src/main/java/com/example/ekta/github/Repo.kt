package com.example.ekta.github

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Grappus on 13/05/18.
 */
class Repo {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
}