package com.smurzik.courses_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.smurzik.courses_database.model.CourseDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Query("SELECT * FROM courses")
    fun getFavoriteCourses(): Flow<List<CourseDBO>>

    @Insert
    suspend fun insert(course: CourseDBO)

    @Delete
    suspend fun delete(course: CourseDBO)
}