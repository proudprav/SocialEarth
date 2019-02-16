package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.socialearth.networkutil.PostDTO

class AlbumListViewModel : ViewModel(){

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: PostDTO){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}