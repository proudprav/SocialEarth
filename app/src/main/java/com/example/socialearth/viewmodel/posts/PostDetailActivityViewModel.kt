package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.example.socialearth.model.PostCommentsDTO
import com.example.socialearth.model.Users
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.view.posts.PostCommentsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostDetailActivityViewModel : ViewModel() {
    var postCommentsAdapter: PostCommentsAdapter = PostCommentsAdapter()
    private val postByUser: MutableLiveData<String> = MutableLiveData()
    private val postTitle: MutableLiveData<String> = MutableLiveData()
    private val postBody: MutableLiveData<String> = MutableLiveData()
    private var compositeDisposable = CompositeDisposable()

    private fun showComments(comments: ArrayList<PostCommentsDTO>) {
        postCommentsAdapter.updateDataList(comments)
    }

    fun initPosts(Id: Bundle) {
        postByUser.value = "- by " + Users.getUsername(Id.getInt("userId")).toString()
        postTitle.value = Id.getString("title")
        postBody.value = Id.getString("body")
        val service = RetrofitFactory.makeRetrofitService()
        compositeDisposable.add(
            service.getPostdetailed(postid = Id.getInt("id").toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(
                Schedulers.io()
            ).subscribe(
                { res -> showComments(res) },
                { e -> print(e) })
        )
    }

    fun getPostByUser(): MutableLiveData<String> {
        return postByUser
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }


}