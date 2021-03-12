package com.android.domain.model

data class GameResult(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Game>
)
