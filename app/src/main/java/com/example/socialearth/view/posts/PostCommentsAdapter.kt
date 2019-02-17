package com.example.socialearth.view.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentPostsItemBinding
import com.example.socialearth.databinding.PostCommentsItemBinding
import com.example.socialearth.model.PostCommentsDTO
import com.example.socialearth.model.PostDTO
import com.example.socialearth.viewmodel.posts.PostCommentsListViewModel
import com.example.socialearth.viewmodel.posts.PostListViewModel
import java.util.ArrayList

class PostCommentsAdapter: RecyclerView.Adapter<PostCommentsAdapter.ItemRowHolder>() {

    lateinit var dataList: ArrayList<PostCommentsDTO>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val binding: PostCommentsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.post_comments_item, viewGroup, false
        )
        return ItemRowHolder(binding)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, position: Int) {
        itemRowHolder.bind(dataList[position])
    }

    fun updateDataList(list: ArrayList<PostCommentsDTO>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(val view: PostCommentsItemBinding) : RecyclerView.ViewHolder(view.root) {
        var postCommentsListViewModel: PostCommentsListViewModel = PostCommentsListViewModel()
        fun bind(data: PostCommentsDTO) {
            postCommentsListViewModel.bind(data)
            view.postcommentlistviewmodel = postCommentsListViewModel
        }
    }
}