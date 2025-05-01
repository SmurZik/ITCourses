package com.smurzik.courses_data

import com.smurzik.courses_api.CoursesApi
import com.smurzik.courses_data.model.CourseData

class CoursesRepository(
    private val api: CoursesApi
) {
    suspend fun getCourses(): List<CourseData> {
        return api.getCourses().courses.map { it.toCourseData() }
    }
}