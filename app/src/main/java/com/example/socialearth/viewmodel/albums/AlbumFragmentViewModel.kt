package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.ViewModel
import com.example.socialearth.networkutil.AlbumPhotosDTO
import com.example.socialearth.networkutil.AlbumsDTO
import com.example.socialearth.networkutil.ImageUrls
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
        val albumUrlResponse = service.getAlbumsbyId()
        val albumResponse = service.getAlbums()
        compositeDisposable.add(
            albumUrlResponse.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> setImages(res) },
                { e -> print(e) }, {
                    compositeDisposable.add(
                        albumResponse.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                            { res -> showsomething(res) },
                            { e -> print(e) })
                    )
                })
        )
    }

    private fun setImages(images: ArrayList<AlbumPhotosDTO>?) {
        ImageUrls.imageList = images!!
    }

    fun showsomething(alnums: ArrayList<AlbumsDTO>) {
        myAlbumRecyclerViewAdapter.updateDataList(alnums)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}