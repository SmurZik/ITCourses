package com.smurzik.home.domain

import com.smurzik.courses_data.model.CourseData
import com.smurzik.home.domain.model.Course

internal fun CourseData.toCourse(): Course {
    return Course(
        this.id,
        this.title,
        this.text,
        this.price,
        this.rate,
        this.startDate,
        this.hasLike,
        this.publishDate
    )
}