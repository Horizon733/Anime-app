package com.example.animeapp.domain.repository

import com.example.animeapp.domain.models.Anime

interface AnimeRepository {

    suspend fun getTopAnime(): List<Anime>

}