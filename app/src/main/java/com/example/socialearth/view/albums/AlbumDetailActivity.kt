package com.example.socialearth.view.albums

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.socialearth.R
import com.example.socialearth.databinding.ActivityAlbumDetailBinding
import com.example.socialearth.viewmodel.albums.AlbumDetailViewModel
import kotlinx.android.synthetic.main.activity_album_detail.*


class AlbumDetailActivity : AppCompatActivity() {
    lateinit var  albumDetailBinding : ActivityAlbumDetailBinding
    lateinit var albumDetailViewModel: AlbumDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumDetailViewModel = ViewModelProviders.of(this).get(AlbumDetailViewModel::class.java)
        albumDetailBinding = DataBindingUtil.setContentView<ActivityAlbumDetailBinding>(this,R.layout.activity_album_detail)
        albumDetailBinding.albumdetailviewmodel = albumDetailViewModel
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        albumDetailViewModel.initImage(intent)
    }



}
