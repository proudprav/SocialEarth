package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.socialearth.model.PostCommentsDTO

class PostCommentsListViewModel: ViewModel() {
    private val postBody = MutableLiveData<String>()
    private val postByUser = MutableLiveData<String>()

    fun bind(postcomments: PostCommentsDTO){
        postBody.value = postcomments.body
        postByUser.value = "- by ${postcomments.name}"
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

    fun getPostByUser(): MutableLiveData<String> {
        return postByUser
    }
}