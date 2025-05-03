package com.smurzik.home.domain

import com.smurzik.core_ui.Course
import com.smurzik.courses_data.model.CourseData
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

internal fun CourseData.toCourse(): Course {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
    val startDate = LocalDate.parse(this.startDate, inputFormatter)
    val tempStartDate = startDate.format(outputFormatter)
    val parts = tempStartDate.split(" ")
    val capitalizeMonth = parts[1].replaceFirstChar { it.titlecaseChar() }
    val formattedStartDate = "${parts[0]} $capitalizeMonth ${parts[2]}"

    val publishDate = LocalDate.parse(this.publishDate, inputFormatter)

    return Course(
        this.id,
        this.title,
        this.text,
        this.price,
        this.rate,
        formattedStartDate,
        this.hasLike,
        publishDate
    )
}

internal fun Course.toCourseData(): CourseData {
    return CourseData(
        this.id,
        this.title,
        this.text,
        this.price,
        this.rate,
        this.startDate,
        this.hasLike,
        this.publishDate.toString()
    )
}