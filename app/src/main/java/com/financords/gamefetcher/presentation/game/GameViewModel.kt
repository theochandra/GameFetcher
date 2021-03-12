package com.financords.gamefetcher.presentation.game

import androidx.lifecycle.ViewModel
import com.financords.domain.usecase.GetGamesUseCase
import javax.inject.Inject

class GameViewModel @Inject constructor(
    private val useCase: GetGamesUseCase
) : ViewModel() {
}