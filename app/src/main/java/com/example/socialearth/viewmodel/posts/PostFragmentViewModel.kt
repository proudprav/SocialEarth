package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.example.socialearth.model.PostDTO
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.view.posts.PostsListViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostFragmentViewModel : ViewModel(), PostsListViewAdapter.OnItemClickListener {

    val uiEventLiveData = MutableLiveData<Bundle>()
    var postsListViewAdapter: PostsListViewAdapter = PostsListViewAdapter(this)
    var compositeDisposable = CompositeDisposable()

    init {
        val service = RetrofitFactory.makeRetrofitService()
        compositeDisposable.add(
            service.getPosts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> updatPost(res) },
                { e -> print(e) })
        )
    }

    private fun updatPost(post: ArrayList<PostDTO>) {
        postsListViewAdapter.updateDataList(post)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    override fun onItemClick(item: PostDTO) {
        val bundle = Bundle()
        bundle.putString("title", item.title)
        bundle.putString("body", item.body)
        bundle.putInt("userId", item.userId!!)
        bundle.putInt("id", item.id!!)
        uiEventLiveData.value = bundle
    }

}