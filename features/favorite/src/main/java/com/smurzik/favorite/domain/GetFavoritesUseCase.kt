package com.smurzik.favorite.domain

import com.smurzik.core_ui.Course
import com.smurzik.courses_data.CoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFavoritesUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(): List<Course> {
        return repository.getFavoriteCourses().map { it.toCourse() }
    }
}