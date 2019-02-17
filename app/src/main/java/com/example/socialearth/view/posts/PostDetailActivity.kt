package com.example.socialearth.view.posts

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.socialearth.R
import com.example.socialearth.databinding.ActivityPostDetailBinding
import com.example.socialearth.viewmodel.posts.PostDetailActivityViewModel

class PostDetailActivity : AppCompatActivity() {

    private lateinit var postDetailBinding: ActivityPostDetailBinding
    private lateinit var postDetailActivityViewModel: PostDetailActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postDetailActivityViewModel = ViewModelProviders.of(this).get(PostDetailActivityViewModel::class.java)
        postDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
        postDetailBinding.postdetailviewmodel = postDetailActivityViewModel
        val postId = intent.getBundleExtra("postBundle")
        postDetailActivityViewModel.initPosts(postId)

    }

}
