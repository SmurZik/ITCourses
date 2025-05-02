package com.smurzik.courses_database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "courses")
data class CourseDBO(
    @PrimaryKey @ColumnInfo("id") val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("text") val text: String,
    @ColumnInfo("price") val price: String,
    @ColumnInfo("rate") val rate: String,
    @ColumnInfo("startDate") val startDate: String,
    @ColumnInfo("hasLike") val hasLike: Boolean,
    @ColumnInfo("publishDate") val publishDate: String
)