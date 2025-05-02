package com.smurzik.courses_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.smurzik.courses_database.dao.CourseDao
import com.smurzik.courses_database.model.CourseDBO

@Database(entities = [CourseDBO::class], version = 1)
abstract class CoursesDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
}

fun CoursesDatabase(applicationContext: Context): CoursesDatabase {
    return Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        CoursesDatabase::class.java,
        "courses"
    ).build()
}