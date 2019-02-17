package com.example.socialearth.viewmodel.albums

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class AlbumDetailViewModel : ViewModel(){
    private var imageId = MutableLiveData<String>()


    fun initImage(intent: Intent?) {
        imageId.value = intent?.getStringExtra("imageurl")

    }


    fun getImageId(): MutableLiveData<String> {
        return imageId
    }


    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(view: ImageView, imageUrl: String) {
            Picasso.get().load(imageUrl).into(view)
        }
    }
}