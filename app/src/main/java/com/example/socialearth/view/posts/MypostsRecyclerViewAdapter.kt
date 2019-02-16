package com.example.socialearth.view.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentPostsBinding
import com.example.socialearth.databinding.FragmentPostsItemBinding


import com.example.socialearth.dummy.DummyContent.DummyItem
import com.example.socialearth.networkutil.PostDTO
import com.example.socialearth.viewmodel.posts.PostListViewModel

import java.util.ArrayList

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MypostsRecyclerViewAdapter() : RecyclerView.Adapter<MypostsRecyclerViewAdapter.ItemRowHolder>() {


    lateinit var dataList: ArrayList<PostDTO>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val binding: FragmentPostsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.fragment_posts_item, viewGroup, false
        )
        return ItemRowHolder(binding)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, position: Int) {

        itemRowHolder.bind(dataList[position])


    }

    fun updateDataList(list: ArrayList<PostDTO>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(val view: FragmentPostsItemBinding) : RecyclerView.ViewHolder(view.root) {
        var postListViewModel: PostListViewModel = PostListViewModel()
        fun bind(data: PostDTO) {
            postListViewModel.bind(data)

            view.postitemviewmodel = postListViewModel
        }
    }
}
