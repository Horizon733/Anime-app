package com.example.animeapp.di

import com.example.animeapp.data.remote.AnimeApi
import com.example.animeapp.data.repository.AnimeRepositoryImpl
import com.example.animeapp.data.util.Constants.Companion.BASE_URL
import com.example.animeapp.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAnimeApi(): AnimeApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApi::class.java)

    @Provides
    @Singleton
    fun provideAnimeRepository(
        api: AnimeApi
    ): AnimeRepository = AnimeRepositoryImpl(api)
}