package com.financords.data.api

import com.financords.data.response.GameResultResponse
import retrofit2.Response
import javax.inject.Inject

class ServiceApi @Inject constructor(
    private val serviceEndPoint: ServiceEndPoint
) {

    suspend fun getGames(apiKey: String, pageSize: Int): Response<GameResultResponse> {
        return serviceEndPoint.getGames(apiKey, pageSize)
    }

}