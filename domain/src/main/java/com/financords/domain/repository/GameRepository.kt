package com.financords.domain.repository

import com.financords.domain.Result
import com.financords.domain.model.GameResult

interface GameRepository {

    suspend fun getGames(apiKey: String, pageSize: Int): Result<GameResult>

}