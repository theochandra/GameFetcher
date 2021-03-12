package com.android.data.mapper

import com.android.data.response.GameResponse
import com.android.data.response.GameResultResponse
import com.android.domain.model.Game
import com.android.domain.model.GameResult
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class GameMapperTest {

    private lateinit var sut: GameMapper

    private lateinit var gameResultResponse: GameResultResponse
    private lateinit var gameResponse: GameResponse

    private lateinit var gameResult: GameResult
    private lateinit var game: Game

    @Before
    fun setup() {
        sut = GameMapper()

        gameResponse = GameResponse(
            id = 10101,
            slug = "",
            name = "",
            released = "",
            backgroundImage = "",
            rating = 4.8f
        )

        gameResultResponse = GameResultResponse(
            count = 10,
            next = "",
            previous = "",
            results = listOf(gameResponse)
        )

        game = Game(
            id = 10101,
            slug = "",
            name = "",
            released = "",
            backgroundImage = "",
            rating = 4.8f
        )

        gameResult = GameResult(
            count = 10,
            next = "",
            previous = "",
            results = listOf(game)
        )
    }

    @Test
    fun gameMapper_mapsGameResultResponse_returnGameResult() {
        val result = sut.map(gameResultResponse)
        assertThat(result, equalTo(gameResult))
    }

    @Test
    fun gameMapper_mapsGameResultResponseCount_returnGameResultCount() {
        val result = sut.map(gameResultResponse)
        assertThat(result.count, equalTo(gameResult.count))
    }

    @Test
    fun gameMapper_mapsGameResultResponseNext_returnGameResultNext() {
        val result = sut.map(gameResultResponse)
        assertThat(result.next, equalTo(gameResult.next))
    }

    @Test
    fun gameMapper_mapsGameResultResponsePrevious_returnGameResultPrevious() {
        val result = sut.map(gameResultResponse)
        assertThat(result.previous, equalTo(gameResult.previous))
    }

    @Test
    fun gameMapper_mapsGameResultResponseResults_returnGameResultResults() {
        val  result = sut.map(gameResultResponse)
        assertThat(result.results, equalTo(gameResult.results))
    }

    @Test
    fun gameMapper_mapsGameResponse_returnGame() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0], equalTo(game))
    }

    @Test
    fun gameMapper_mapsGameResponseId_returnGameId() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].id, equalTo(game.id))
    }

    @Test
    fun gameMapper_mapsGameResponseSlug_returnGameSlug() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].slug, equalTo(game.slug))
    }

    @Test
    fun gameMapper_mapsGameResponseName_returnGameName() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].name, equalTo(game.name))
    }

    @Test
    fun gameMapper_mapsGameResponseReleased_returnGameReleased() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].released, equalTo(game.released))
    }

    @Test
    fun gameMapper_mapsGameResponseBackgroundImage_returnGameBackgroundImage() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].backgroundImage, equalTo(game.backgroundImage))
    }

    @Test
    fun gameMapper_mapsGameResponseRating_returnGameRating() {
        val result = sut.map(gameResultResponse)
        assertThat(result.results[0].rating, equalTo(game.rating))
    }

}