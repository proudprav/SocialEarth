package com.example.socialearth.view.albums

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentAlbumItemBinding
import com.example.socialearth.model.AlbumsDTO
import com.example.socialearth.model.PostDTO
import com.example.socialearth.view.posts.MypostsRecyclerViewAdapter
import com.example.socialearth.viewmodel.albums.AlbumListViewModel
import java.util.*

class MyAlbumRecyclerViewAdapter(listner : OnItemClickListener ): RecyclerView.Adapter<MyAlbumRecyclerViewAdapter.ItemRowHolder>() {

    lateinit var dataList: ArrayList<AlbumsDTO>
    private val listener: OnItemClickListener = listner

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val binding: FragmentAlbumItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.fragment_album_item, viewGroup, false
        )
        return ItemRowHolder(binding)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, position: Int) {
        itemRowHolder.bind(dataList[position], listener)
        itemRowHolder.albumListViewModel
    }
    fun updateDataList(list: ArrayList<AlbumsDTO>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(val view: FragmentAlbumItemBinding) : RecyclerView.ViewHolder(view.root) {

        var albumListViewModel: AlbumListViewModel = AlbumListViewModel()
        fun bind(data: AlbumsDTO,listner: OnItemClickListener) {
            view.albumImage.setOnClickListener { listner.onItemClick(data) }
            albumListViewModel.bind(data)
            view.albumlistviewmodel = albumListViewModel
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: AlbumsDTO)
    }

}
