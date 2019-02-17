package com.example.socialearth.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.socialearth.R
import com.example.socialearth.databinding.ActivityMainBinding
import com.example.socialearth.view.albums.AlbumFragment
import com.example.socialearth.view.posts.PostsFragment
import com.example.socialearth.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityMainBinding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var postsFragment: PostsFragment
    private lateinit var albumFragment: AlbumFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_posts -> {
                postsFragment = PostsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.feedframe, postsFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_albums -> {
                albumFragment = AlbumFragment()
                supportFragmentManager.beginTransaction().replace(R.id.feedframe, albumFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityMainBinding.mainactivityvm = mainActivityViewModel
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        this.postsFragment = PostsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.feedframe, postsFragment).commit()
    }

}
