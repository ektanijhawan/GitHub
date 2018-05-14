package com.example.ekta.github

/**
 * Created by Grappus on 12/05/18.
 */

/**
 * Response holder provided to the UI
 */
class Response private constructor(val status: Status, val data: List<Repo>?, val error: Throwable?) {
    companion object {

        fun loading(): Response {
            return Response(Status.LOADING, null, null)
        }

        fun success(data: List<Repo>?): Response {
            return Response(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): Response {
            return Response(Status.ERROR, null, error)
        }
    }
}
