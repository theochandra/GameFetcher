package com.android.domain.usecase

import com.android.domain.Result
import com.android.domain.coroutineRule.CoroutineTestRule
import com.android.domain.model.GameResult
import com.android.domain.repository.GameRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetGamesUseCaseTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Mock
    lateinit var repository: GameRepository

    private lateinit var sut: GetGamesUseCase

    @Before
    fun setup() {
        sut = GetGamesUseCase(repository)
    }

    @Test
    fun getGamesUseCase_returnResultSuccess() {
        runBlocking {
            val gameResult: GameResult = mock()
            given(repository.getGames(any(), any()))
                .willReturn(Result.Success(gameResult))
            sut.execute("testApiKey", 10)
            verify(repository).getGames("testApiKey", 10)
        }
    }

    @Test
    fun getGamesUseCase_returnResultError() {
        runBlocking {
            given(repository.getGames(any(), any()))
                .willReturn(Result.Error(500, "Internal server error"))
            sut.execute("testApiKey", 10)
            verify(repository).getGames("testApiKey", 10)
        }
    }

    @Test
    fun getGamesUseCase_returnResultException() {
        runBlocking {
            val exception: Exception = mock()
            given(repository.getGames(any(), any()))
                .willReturn(Result.Exception(exception))
            sut.execute("testApiKey", 10)
            verify(repository).getGames("testApiKey", 10)
        }
    }

}