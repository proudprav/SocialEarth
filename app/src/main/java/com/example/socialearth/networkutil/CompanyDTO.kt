package com.example.socialearth.networkutil

import com.google.gson.annotations.SerializedName

data class CompanyDTO(

	@field:SerializedName("bs")
	val bs: String? = null,

	@field:SerializedName("catchPhrase")
	val catchPhrase: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)