package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.ViewModel
import com.example.socialearth.model.AlbumPhotosDTO
import com.example.socialearth.model.AlbumsDTO
import com.example.socialearth.model.ImageUrls
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.view.albums.MyAlbumRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AlbumFragmentViewModel : ViewModel() {

    var myAlbumRecyclerViewAdapter: MyAlbumRecyclerViewAdapter = MyAlbumRecyclerViewAdapter()
    var compositeDisposable = CompositeDisposable()
    val service = RetrofitFactory.makeRetrofitService()

    init {
        compositeDisposable.add(
            service.getAlbums().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> showsomething(res) },
                { e -> print(e) })
        )
    }

    fun showsomething(albums: ArrayList<AlbumsDTO>) {
        myAlbumRecyclerViewAdapter.updateDataList(albums)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}