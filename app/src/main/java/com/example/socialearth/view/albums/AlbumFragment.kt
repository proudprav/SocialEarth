package com.example.socialearth.view.albums

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentAlbumBinding
import com.example.socialearth.viewmodel.albums.AlbumFragmentViewModel
import kotlinx.android.synthetic.main.fragment_album.*

class AlbumFragment : Fragment() {

    lateinit var albumBinding: FragmentAlbumBinding
    lateinit var albumFragmentViewModel: AlbumFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        albumFragmentViewModel = ViewModelProviders.of(this).get(AlbumFragmentViewModel::class.java)
        albumBinding = DataBindingUtil.inflate<FragmentAlbumBinding>(
            inflater,
            R.layout.fragment_album, container, false
        )
        albumBinding.albumviewmodel = albumFragmentViewModel

        return albumBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list?.layoutManager = GridLayoutManager(activity, 3)

    }
}
