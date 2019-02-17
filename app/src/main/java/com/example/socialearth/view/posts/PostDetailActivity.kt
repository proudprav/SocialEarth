package com.example.socialearth.view.posts

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.socialearth.R
import com.example.socialearth.databinding.ActivityPostDetailBinding
import com.example.socialearth.viewmodel.posts.PostDetailActivityViewModel

import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetailActivity : AppCompatActivity() {

    lateinit var postDetailBinding: ActivityPostDetailBinding
    lateinit var postDetailActivityViewModel: PostDetailActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postDetailActivityViewModel = ViewModelProviders.of(this).get(PostDetailActivityViewModel::class.java)
        postDetailBinding = DataBindingUtil.setContentView<ActivityPostDetailBinding>(this,R.layout.activity_post_detail)
        postDetailBinding.postdetailviewmodel = postDetailActivityViewModel
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val postId = intent.getBundleExtra("postBundle")
        postDetailActivityViewModel.initPosts(postId)

    }

}
