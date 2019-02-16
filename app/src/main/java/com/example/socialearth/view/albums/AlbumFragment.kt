package com.example.socialearth.view.albums

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentAlbumBinding
import com.example.socialearth.viewmodel.albums.AlbumFragmentViewModel


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AlbumFragment.OnListFragmentInteractionListener] interface.
 */
class AlbumFragment : Fragment() {

    lateinit var albumBinding: FragmentAlbumBinding
    lateinit var albumFragmentViewModel: AlbumFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        albumFragmentViewModel = ViewModelProviders.of(this).get(AlbumFragmentViewModel::class.java)
        albumBinding = DataBindingUtil.inflate<FragmentAlbumBinding>(
            inflater,
            R.layout.fragment_album, container, false
        )
        albumBinding.albumviewmodel = albumFragmentViewModel


        return albumBinding.root
    }



}
