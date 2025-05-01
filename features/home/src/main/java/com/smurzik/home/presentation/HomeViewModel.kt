package com.smurzik.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smurzik.home.domain.GetCoursesUseCase
import com.smurzik.home.domain.model.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    private val _courseListLiveData = MutableLiveData<List<Course>>()
    val courseListLiveData: LiveData<List<Course>> = _courseListLiveData

    fun getCourse() {
        viewModelScope.launch(Dispatchers.IO) {
            _courseListLiveData.postValue(getCoursesUseCase.invoke())
        }
    }
}