package com.android.gamefetcher.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.domain.usecase.GetGamesUseCase

class GameViewModelFactory(
    private val useCase: GetGamesUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GameViewModel(useCase) as T
    }
}