package com.example.socialearth.networkutil

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("posts")
    fun getPosts() : Observable<ArrayList<PostDTO>>
}