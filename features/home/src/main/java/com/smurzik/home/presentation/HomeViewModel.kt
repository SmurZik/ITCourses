package com.smurzik.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smurzik.core_ui.Course
import com.smurzik.home.domain.AddToFavoriteUseCase
import com.smurzik.home.domain.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase
) : ViewModel() {

    private val _courseListLiveData = MutableLiveData<List<Course>>()
    val courseListLiveData: LiveData<List<Course>> = _courseListLiveData

    private val sortingAscLiveData = MutableLiveData(false)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _courseListLiveData.postValue(getCoursesUseCase.invoke())
        }
    }

    fun sortCourseList() {
        viewModelScope.launch(Dispatchers.Default) {
            if (sortingAscLiveData.value != true) {
                val sortedCourses = _courseListLiveData.value?.sortedBy { it.publishDate }
                withContext(Dispatchers.Main) {
                    _courseListLiveData.value =
                        sortedCourses ?: listOf()
                }

            } else {
                val sortedDescendingCourses =
                    _courseListLiveData.value?.sortedByDescending { it.publishDate }
                withContext(Dispatchers.Main) {
                    _courseListLiveData.value =
                        sortedDescendingCourses ?: listOf()
                }
            }
            sortingAscLiveData.postValue(!sortingAscLiveData.value!!)
        }
    }

    fun addToFavorite(course: Course) {
        viewModelScope.launch(Dispatchers.IO) {
            addToFavoriteUseCase(course)
            withContext(Dispatchers.Main) {
                _courseListLiveData.value =
                    _courseListLiveData.value?.map { if (it.id == course.id) it.copy(hasLike = !it.hasLike) else it }
            }
        }
    }
}