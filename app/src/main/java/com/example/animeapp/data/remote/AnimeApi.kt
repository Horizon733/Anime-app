package com.example.animeapp.data.remote

import com.example.animeapp.domain.models.TopAnime
import retrofit2.http.GET

interface AnimeApi {

    @GET("top/anime")
    suspend fun getTopAnime(): TopAnime

}