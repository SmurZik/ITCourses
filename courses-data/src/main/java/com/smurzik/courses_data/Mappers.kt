package com.smurzik.courses_data

import com.smurzik.courses_api.CourseCloud
import com.smurzik.courses_data.model.CourseData
import com.smurzik.courses_database.model.CourseDBO

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

internal fun CourseDBO.toCourseData(): CourseData {
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

internal fun CourseData.toCourseDBO(): CourseDBO {
    return CourseDBO(
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