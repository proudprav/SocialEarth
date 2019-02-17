package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.socialearth.model.AlbumsDTO
import com.example.socialearth.model.ImageUrls
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.view.albums.AlbumListViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AlbumFragmentViewModel : ViewModel(), AlbumListViewAdapter.OnItemClickListener {
    val uiEventLiveData = MutableLiveData<String>()
    var albumListViewAdapter: AlbumListViewAdapter = AlbumListViewAdapter(this)
    private var compositeDisposable = CompositeDisposable()
    private val service = RetrofitFactory.makeRetrofitService()

    init {
        compositeDisposable.add(
            service.getAlbums().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
                { res -> updateList(res) },
                { e -> print(e) })
        )
    }

    private fun updateList(albums: ArrayList<AlbumsDTO>) {
        albumListViewAdapter.updateDataList(albums)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    override fun onItemClick(item: AlbumsDTO) {
        uiEventLiveData.value = ImageUrls.getImagesUrl(item.id!!)
    }
}