package com.example.animeapp.presentation.home_screen

import com.example.animeapp.domain.models.Anime

data class AnimeListState(
    val isLoading: Boolean = false,
    val animeList: List<Anime> = emptyList(),
    val error: String = ""
)
