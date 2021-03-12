package com.android.data.api

import com.android.data.response.GameResultResponse
import retrofit2.Response
import javax.inject.Inject

class ServiceApi @Inject constructor(
    private val serviceEndPoint: ServiceEndPoint
) {

    suspend fun getGames(apiKey: String, pageSize: Int): Response<GameResultResponse> {
        return serviceEndPoint.getGames(apiKey, pageSize)
    }

}