package com.example.socialearth.networkutil

import com.example.socialearth.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("posts")
    fun getPosts() : Observable<ArrayList<PostDTO>>

    @GET("posts/{postId}/comments")
    fun getPostdetailed(@Path("postId") postid : String) : Observable<ArrayList<PostCommentsDTO>>

    @GET("albums")
    fun getAlbums() : Observable<ArrayList<AlbumsDTO>>

    @GET("albums/1/photos")
    fun getAlbumsbyId() : Observable<ArrayList<AlbumPhotosDTO>>

    @GET("users")
    fun getUsers() : Observable<ArrayList<UsersDTO>>
}