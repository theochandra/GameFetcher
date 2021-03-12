package com.android.domain.usecase

import com.android.domain.Result
import com.android.domain.model.GameResult
import com.android.domain.repository.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GameRepository
) {

    suspend fun execute(apiKey: String, pageSize: Int): Result<GameResult> {
        return repository.getGames(apiKey, pageSize)
    }

}