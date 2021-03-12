package com.financords.data.repository

import com.financords.data.api.ServiceApi
import com.financords.data.mapper.GameMapper
import com.financords.data.safeApiCall
import com.financords.domain.Result
import com.financords.domain.model.GameResult
import com.financords.domain.repository.GameRepository

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