package com.smurzik.favorite.domain

import com.smurzik.core_ui.Course
import com.smurzik.courses_data.model.CourseData
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

internal fun CourseData.toCourse(): Course {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val publishDate = LocalDate.parse(this.publishDate, inputFormatter)

    return Course(
        this.id,
        this.title,
        this.text,
        this.price,
        this.rate,
        this.startDate,
        true,
        publishDate
    )
}