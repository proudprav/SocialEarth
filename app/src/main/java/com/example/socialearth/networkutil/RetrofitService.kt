package com.example.socialearth.networkutil

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("posts")
    fun getPosts() : Observable<ArrayList<PostDTO>>

    @GET("albums")
    fun getAlbums() : Observable<ArrayList<AlbumsDTO>>

    @GET("albums/1/photos")
    fun getAlbumsbyId() : Observable<ArrayList<AlbumPhotosDTO>>

    @GET("users")
    fun getUsers() : Observable<ArrayList<UsersDTO>>
}