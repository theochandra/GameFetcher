package com.financords.data.mapper

import com.financords.data.response.GameResponse
import com.financords.data.response.GameResultResponse
import com.financords.domain.model.Game
import com.financords.domain.model.GameResult
import javax.inject.Inject

class GameMapper @Inject constructor() {

    fun map(response: GameResultResponse): GameResult {
        return GameResult(
            count = response.count,
            next = response.next,
            previous = response.previous,
            results = response.results.map { map(it) }
        )
    }

    private fun map(gameResponse: GameResponse): Game {
        return Game(
            id = gameResponse.id,
            slug = gameResponse.slug,
            name = gameResponse.name,
            released = gameResponse.released,
            backgroundImage = gameResponse.backgroundImage,
            rating = gameResponse.rating
        )
    }

}