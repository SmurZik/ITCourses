package com.smurzik.courses_data

import com.smurzik.courses_api.CoursesApi
import com.smurzik.courses_data.model.CourseData
import com.smurzik.courses_database.dao.CourseDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map

class CoursesRepository(
    private val api: CoursesApi,
    private val dao: CourseDao
) {
    suspend fun getCourses(): List<CourseData> {
        val favoritesIds = getFavoriteCourses().map { it.id }
        return api.getCourses().courses.map {
            it.toCourseData().copy(hasLike = favoritesIds.contains(it.id))
        }
    }

    suspend fun getFavoriteCourses(): List<CourseData> {
        return dao.getFavoriteCourses().map { it.toCourseData() }
    }

    suspend fun addToFavorite(course: CourseData) {
        dao.insert(course.toCourseDBO())
    }

    suspend fun deleteFromFavorite(course: CourseData) {
        dao.delete(course.toCourseDBO())
    }
}