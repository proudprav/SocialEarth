package com.example.socialearth.networkutil

import com.google.gson.annotations.SerializedName

data class AlbumsDTO(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)