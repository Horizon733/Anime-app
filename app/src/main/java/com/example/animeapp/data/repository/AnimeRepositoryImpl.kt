package com.example.animeapp.data.repository

import com.example.animeapp.data.remote.AnimeApi
import com.example.animeapp.domain.models.Anime
import com.example.animeapp.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val api: AnimeApi
) : AnimeRepository {

    override suspend fun getTopAnime(): List<Anime> {
        return api.getTopAnime().top
    }

}