package com.example.socialearth

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.socialearth.databinding.ActivityMainBinding
import com.example.socialearth.networkutil.PostDTO
import com.example.socialearth.networkutil.RetrofitFactory
import com.example.socialearth.viewmodel.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainActivityMainBinding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var postsFragment: PostsFragment
    lateinit var albumFragment: AlbumFragment
    lateinit var posts: ArrayList<PostDTO>
    var compositeDisposable = CompositeDisposable()

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
        mainActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainActivityMainBinding.mainactivityvm = mainActivityViewModel
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        var service = RetrofitFactory.makeRetrofitService()

        var response = service.getPosts()

        compositeDisposable.add(response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
            { res -> showsomething(res) },
            { e -> print(e) }))


    }

    fun showsomething(post: ArrayList<PostDTO>) {

        Toast.makeText(this@MainActivity, "yes I load", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
