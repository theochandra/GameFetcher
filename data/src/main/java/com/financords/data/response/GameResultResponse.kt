package com.financords.data.response

import com.google.gson.annotations.SerializedName

data class GameResultResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<GameResponse>
)
