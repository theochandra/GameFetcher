package com.android.data.api

import com.android.data.response.GameResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceEndPoint {

    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("page_size") pageSize: Int
    ): Response<GameResultResponse>

}