package com.android.data.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String,
    @SerializedName("released") val released: String,
    @SerializedName("background_image") val backgroundImage: String,
    @SerializedName("rating") val rating: Float
)
