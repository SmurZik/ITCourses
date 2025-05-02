package com.smurzik.home.domain

import com.smurzik.courses_data.CoursesRepository
import com.smurzik.home.domain.model.Course

class GetCoursesUseCase(
    private val repository: CoursesRepository
) {

    suspend operator fun invoke(): List<Course> {
        return repository.getCourses().map { it.toCourse() }.sortedByDescending { it.publishDate }
    }
}