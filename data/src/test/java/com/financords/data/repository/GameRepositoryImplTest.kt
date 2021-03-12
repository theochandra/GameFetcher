package com.financords.data.repository

import com.financords.data.api.ServiceApi
import com.financords.data.mapper.GameMapper
import com.financords.data.response.GameResultResponse
import com.financords.domain.Result
import com.financords.domain.model.GameResult
import com.financords.domain.repository.GameRepository
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response.success

@RunWith(MockitoJUnitRunner::class)
class GameRepositoryImplTest {

    @Mock
    lateinit var serviceApi: ServiceApi

    @Mock
    lateinit var mapper: GameMapper

    private lateinit var sut: GameRepository

    @Before
    fun setup() {
        sut = GameRepositoryImpl(serviceApi, mapper)
    }

    @Test
    fun gameRepository_getGameResultResponse() {
        runBlocking {
            given(serviceApi.getGames(any(), any())).willReturn(mock())
            sut.getGames("testApiKey", 10)
            verify(serviceApi).getGames(any(), any())
        }
    }

    @Test
    fun gameRepository_mapsGameResultResponse() {
        runBlocking {
            val gameResultResponse = mock<GameResultResponse>()
            val response = success(gameResultResponse)

            given(serviceApi.getGames(any(), any()))
                .willReturn(response)
            given(mapper.map(any()))
                .willReturn(mock())
            sut.getGames("testApiKey", 10)
            verify(mapper).map(eq(gameResultResponse))
        }
    }

    @Test
    fun gameRepository_returnGameResult() {
        runBlocking {
            val gameResultResponse = mock<GameResultResponse>()
            val response = success(gameResultResponse)
            val gameResult = mock<GameResult>()

            given(serviceApi.getGames(any(), any()))
                .willReturn(response)
            given(mapper.map(any()))
                .willReturn(gameResult)

            val result = sut.getGames("testApiKey", 10)
            assertThat(result, equalTo(Result.Success(gameResult)))
        }
    }

}