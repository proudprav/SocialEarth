package com.example.socialearth.viewmodel.posts

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.socialearth.model.PostDTO
import com.example.socialearth.model.Users
import com.example.socialearth.model.UsersDTO
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock


class PostListViewModelTest {

    @Mock
    val postListViewModel  = PostListViewModel()

    @Mock
    val postDTO: PostDTO = PostDTO()
    @Mock
    val usersDTO = ArrayList<UsersDTO>()


    @Rule @JvmField
    var rule: TestRule = InstantTaskExecutorRule()


    @Test
    fun bind() {
        postDTO.id = 1
        postDTO.body = "fwfqwf"
        postDTO.title = "myName"
        postDTO.userId = 2
        usersDTO.add(UsersDTO(name = "uguvu",id = 2))
        Users.userList = usersDTO
        postListViewModel.bind(postDTO)
        assertNotNull(postListViewModel.getPostTitle())
        assertNotNull(postListViewModel.getPostBody())
        assertNotNull(postListViewModel.getPostByUser())

    }


}