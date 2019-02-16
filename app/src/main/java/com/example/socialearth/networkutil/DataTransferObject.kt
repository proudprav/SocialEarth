package com.example.socialearth.networkutil

import com.google.gson.annotations.SerializedName
import java.util.function.Predicate

data class AddressDTO(

    @field:SerializedName("zipcode")
    val zipcode: String? = null,

    @field:SerializedName("geo")
    val geo: GeoDTO? = null,

    @field:SerializedName("suite")
    val suite: String? = null,

    @field:SerializedName("city")
    val city: String? = null,

    @field:SerializedName("street")
    val street: String? = null
)

data class GeoDTO(

    @field:SerializedName("lng")
    val lng: String? = null,

    @field:SerializedName("lat")
    val lat: String? = null
)


data class AlbumPhotosDTO(

    @field:SerializedName("albumId")
    val albumId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null
)

data class AlbumsDTO(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("userId")
    val userId: Int? = null
)

data class CompanyDTO(

    @field:SerializedName("bs")
    val bs: String? = null,

    @field:SerializedName("catchPhrase")
    val catchPhrase: String? = null,

    @field:SerializedName("name")
    val name: String? = null
)

data class PostCommentsDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("postId")
    val postId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("body")
    val body: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)

data class PostDTO(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("body")
    val body: String? = null,

    @field:SerializedName("userId")
    val userId: Int? = null
)


data class UsersDTO(

    @field:SerializedName("website")
    val website: String? = null,

    @field:SerializedName("address")
    val address: AddressDTO? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("company")
    val company: CompanyDTO? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null
)

 object Users{
     lateinit var userList : List<UsersDTO>

     fun getUsername( userId: Int) : String?{
        val dto = userList.filter { it.id == userId }
         return dto[0].username
     }
 }