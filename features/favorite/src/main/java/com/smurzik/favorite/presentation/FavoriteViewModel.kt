package com.smurzik.favorite.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.smurzik.core_ui.Course
import com.smurzik.favorite.domain.GetFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
) : ViewModel() {

    private val _courseListLiveData = MutableLiveData<List<Course>>()
    val courseListLiveData: LiveData<List<Course>> = _courseListLiveData

    fun getFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            _courseListLiveData.postValue(getFavoritesUseCase.invoke())
        }
    }
}