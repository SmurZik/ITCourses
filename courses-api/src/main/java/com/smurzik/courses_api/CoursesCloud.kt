package com.smurzik.courses_api

data class CoursesCloud(
    val courses: List<CourseCloud>
)

data class CourseCloud(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
)