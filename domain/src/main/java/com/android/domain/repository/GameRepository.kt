package com.android.domain.repository

import com.android.domain.Result
import com.android.domain.model.GameResult

interface GameRepository {

    suspend fun getGames(apiKey: String, pageSize: Int): Result<GameResult>

}