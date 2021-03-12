package com.android.data.repository

import com.android.data.api.ServiceApi
import com.android.data.mapper.GameMapper
import com.android.data.safeApiCall
import com.android.domain.Result
import com.android.domain.model.GameResult
import com.android.domain.repository.GameRepository

class GameRepositoryImpl(
    private val serviceApi: ServiceApi,
    private val mapper: GameMapper
) : GameRepository {

    override suspend fun getGames(apiKey: String, pageSize: Int): Result<GameResult> {
        return safeApiCall(
            call ={ getGamesFromApi(apiKey, pageSize) },
            errorMessage = "Exception occurred!"
        )
    }

    private suspend fun getGamesFromApi(apiKey: String, pageSize: Int): Result<GameResult> {
        val result = serviceApi.getGames(apiKey, pageSize)

        if (result.isSuccessful) {
            val body = result.body()
            body?.let {
                val gameResult = mapper.map(it)
                return Result.Success(gameResult)
            }
        }

        return Result.Error(result.code(), result.message())
    }

}