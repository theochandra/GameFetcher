package com.android.data.mapper

import com.android.data.response.GameResponse
import com.android.data.response.GameResultResponse
import com.android.domain.model.Game
import com.android.domain.model.GameResult
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