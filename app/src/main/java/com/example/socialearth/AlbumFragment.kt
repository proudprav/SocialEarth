package com.example.socialearth

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialearth.databinding.FragmentAlbumBinding

import com.example.socialearth.dummy.DummyContent
import com.example.socialearth.dummy.DummyContent.DummyItem
import com.example.socialearth.viewmodel.AlbumFragmentViewModel

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
        albumBinding = DataBindingUtil.inflate<FragmentAlbumBinding>(inflater,R.layout.fragment_album_list,container,false)
        albumBinding.albumviewmodel = albumFragmentViewModel

        return albumBinding.root
    }



}
