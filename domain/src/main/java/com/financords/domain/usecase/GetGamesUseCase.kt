package com.financords.domain.usecase

import com.financords.domain.Result
import com.financords.domain.model.GameResult
import com.financords.domain.repository.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GameRepository
) {

    suspend fun execute(apiKey: String, pageSize: Int): Result<GameResult> {
        return repository.getGames(apiKey, pageSize)
    }

}