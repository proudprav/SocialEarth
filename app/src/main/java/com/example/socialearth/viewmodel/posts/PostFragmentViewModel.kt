package com.example.socialearth.viewmodel.posts

import android.arch.lifecycle.ViewModel
import com.example.socialearth.networkutil.PostDTO
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.networkutil.Users
import com.example.socialearth.networkutil.UsersDTO
import com.example.socialearth.view.posts.MypostsRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostFragmentViewModel : ViewModel() {

    var mypostsRecyclerViewAdapter: MypostsRecyclerViewAdapter = MypostsRecyclerViewAdapter()
    var compositeDisposable = CompositeDisposable()

    init {
        val service = RetrofitFactory.makeRetrofitService()

        val postResponse = service.getPosts()
        val usersResponse = service.getUsers()
        compositeDisposable.add(
            usersResponse.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> setUsers(res) },
                { e -> print(e) })
        )
        compositeDisposable.add(
            postResponse.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> showsomething(res) },
                { e -> print(e) })
        )
    }

    private fun setUsers(users: ArrayList<UsersDTO>?) {
        Users.userList = users!!
    }

    fun showsomething(post: ArrayList<PostDTO>) {
        mypostsRecyclerViewAdapter.updateDataList(post)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}