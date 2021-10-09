package com.example.animeapp.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AnimeRepository
): ViewModel() {

    private val _state = mutableStateOf(AnimeListState())
    val state: State<AnimeListState> = _state

    init {
        getTopAnime()
    }

    private fun getTopAnime() {
        viewModelScope.launch {
            _state.value = AnimeListState(isLoading = true)
            try{
                _state.value = AnimeListState(animeList = repository.getTopAnime())
            }catch (e: Exception) {
                _state.value = AnimeListState(error = e.message.toString())
            }
        }
    }
}