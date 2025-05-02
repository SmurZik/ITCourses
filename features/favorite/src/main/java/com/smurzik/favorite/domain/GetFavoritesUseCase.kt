package com.smurzik.favorite.domain

import com.smurzik.core_ui.Course
import com.smurzik.courses_data.CoursesRepository

class GetFavoritesUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(): List<Course> {
        return repository.getCourses().map { it.toCourse() }.sortedByDescending { it.publishDate }
    }
}