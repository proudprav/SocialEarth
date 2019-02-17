package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.example.socialearth.model.PostDTO
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.model.Users
import com.example.socialearth.model.UsersDTO
import com.example.socialearth.view.posts.MypostsRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostFragmentViewModel : ViewModel(),MypostsRecyclerViewAdapter.OnItemClickListener {
    val uiEventLiveData = MutableLiveData<Bundle>()
    var mypostsRecyclerViewAdapter: MypostsRecyclerViewAdapter = MypostsRecyclerViewAdapter(this)
    var compositeDisposable = CompositeDisposable()

    init {
        val service = RetrofitFactory.makeRetrofitService()
        compositeDisposable.add(
            service.getPosts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> showsomething(res) },
                { e -> print(e) })
        )
    }

    fun showsomething(post: ArrayList<PostDTO>) {
        mypostsRecyclerViewAdapter.updateDataList(post)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    override fun onItemClick(item: PostDTO) {
        var bundle : Bundle = Bundle()
        bundle.putString("title",item.title)
        bundle.putString("body",item.body)
        bundle.putInt("userId",item.userId!!)
        bundle.putInt("id",item.id!!)
        uiEventLiveData.value = bundle
    }

}