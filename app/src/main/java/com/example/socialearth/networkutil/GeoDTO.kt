package com.example.socialearth.networkutil

import com.google.gson.annotations.SerializedName

data class GeoDTO(

	@field:SerializedName("lng")
	val lng: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null
)