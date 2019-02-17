package com.example.socialearth.view.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentPostsItemBinding
import com.example.socialearth.model.PostDTO
import com.example.socialearth.viewmodel.posts.PostListViewModel
import java.util.*

class PostsListViewAdapter(listner: OnItemClickListener) : RecyclerView.Adapter<PostsListViewAdapter.ItemRowHolder>() {

    private lateinit var dataList: ArrayList<PostDTO>
    private val listener: OnItemClickListener = listner

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val binding: FragmentPostsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.fragment_posts_item, viewGroup, false
        )
        return ItemRowHolder(binding)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, position: Int) {
        itemRowHolder.bind(dataList[position], listener)
    }

    fun updateDataList(list: ArrayList<PostDTO>) {
        dataList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (::dataList.isInitialized) dataList.size else 0
    }

    inner class ItemRowHolder(val view: FragmentPostsItemBinding) : RecyclerView.ViewHolder(view.root) {
        private var postListViewModel: PostListViewModel = PostListViewModel()
        fun bind(data: PostDTO, listner: OnItemClickListener) {
            view.root.setOnClickListener { listner.onItemClick(data) }
            postListViewModel.bind(data)
            view.postitemviewmodel = postListViewModel
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: PostDTO)
    }
}
