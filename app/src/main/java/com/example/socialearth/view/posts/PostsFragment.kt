package com.example.socialearth.view.posts

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialearth.R
import com.example.socialearth.databinding.FragmentPostsBinding
import com.example.socialearth.viewmodel.posts.PostFragmentViewModel

class PostsFragment : Fragment() {


    lateinit var postListBinding: com.example.socialearth.databinding.FragmentPostsBinding
    lateinit var postFragmentViewModel: PostFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postFragmentViewModel = ViewModelProviders.of(this).get(PostFragmentViewModel::class.java)
        postListBinding = DataBindingUtil.inflate<FragmentPostsBinding>(
            inflater,
            R.layout.fragment_posts, container, false
        )
        postListBinding.postviewmodel = postFragmentViewModel


        return postListBinding.root
    }
}