package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.ViewModel
import com.example.socialearth.networkutil.PostDTO
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.view.albums.MyAlbumRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AlbumFragmentViewModel : ViewModel() {

    var myAlbumRecyclerViewAdapter: MyAlbumRecyclerViewAdapter =
        MyAlbumRecyclerViewAdapter()
    var compositeDisposable = CompositeDisposable()

    init {
        val service = RetrofitFactory.makeRetrofitService()

        val response = service.getPosts()

        compositeDisposable.add(
            response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> showsomething(res) },
                { e -> print(e) })
        )


    }

    fun showsomething(post: ArrayList<PostDTO>) {

        myAlbumRecyclerViewAdapter.updateDataList(post)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}