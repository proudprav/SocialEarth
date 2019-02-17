package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.socialearth.networkutil.PostDTO
import com.example.socialearth.networkutil.Users

class PostListViewModel : ViewModel(){

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()
    private val postByUser = MutableLiveData<String>()

    fun bind(post: PostDTO){
        postTitle.value = post.title
        postBody.value = post.body
        postByUser.value = "- by " + Users.getUsername(post.userId!!).toString()
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

    fun getPostByUser():MutableLiveData<String>{
        return postByUser
    }
}