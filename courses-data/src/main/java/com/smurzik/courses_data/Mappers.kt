package com.smurzik.courses_data

import com.smurzik.courses_api.CourseCloud
import com.smurzik.courses_data.model.CourseData

internal fun CourseCloud.toCourseData(): CourseData {
    return CourseData(
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