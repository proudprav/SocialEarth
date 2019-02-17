package com.example.socialearth.model

import com.google.gson.annotations.SerializedName

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

object Users {
    var userList: List<UsersDTO>? = ArrayList()

    fun getUsername(userId: Int): String? {
        val dto = userList?.filter { it.id == userId }?.first()
        return """${dto?.username}, ${dto?.address?.city}"""
    }
}

object ImageUrls {
    var imageList: List<AlbumPhotosDTO>? = ArrayList()

    fun getThumnailImages(imageId: Int): String? {
        val dto = imageList?.filter { it.albumId == imageId }?.first()
        return dto?.thumbnailUrl
    }

    fun getImagesUrl(imageId: Int): String? {
        val dto = imageList?.filter { it.albumId == imageId }?.first()
        return dto?.url
    }

}
