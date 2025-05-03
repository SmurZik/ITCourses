package com.smurzik.home.domain

import com.smurzik.core_ui.Course
import com.smurzik.courses_data.CoursesRepository

class AddToFavoriteUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(course: Course) {
        if (repository.getFavoriteCourses().map { it.id }.contains(course.id))
            repository.deleteFromFavorite(course.toCourseData())
        else
            repository.addToFavorite(course.toCourseData())
    }
}