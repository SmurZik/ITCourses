package com.smurzik.itcourses

import android.content.Context
import com.smurzik.courses_api.CoursesApi
import com.smurzik.courses_data.CoursesRepository
import com.smurzik.courses_data.model.CourseData
import com.smurzik.courses_database.CoursesDatabase
import com.smurzik.favorite.domain.GetFavoritesUseCase
import com.smurzik.home.domain.AddToFavoriteUseCase
import com.smurzik.home.domain.GetCoursesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoursesApi(): CoursesApi {
        return CoursesApi()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CoursesDatabase {
        return CoursesDatabase(context)
    }

    @Provides
    fun provideCoursesRepository(api: CoursesApi, database: CoursesDatabase): CoursesRepository {
        return CoursesRepository(api, database.courseDao())
    }

    @Provides
    fun provideGetCoursesUseCase(repository: CoursesRepository): GetCoursesUseCase {
        return GetCoursesUseCase(repository)
    }

    @Provides
    fun provideGetFavoritesUseCase(repository: CoursesRepository): GetFavoritesUseCase {
        return GetFavoritesUseCase(repository)
    }

    @Provides
    fun provideAddToFavoriteUseCase(repository: CoursesRepository): AddToFavoriteUseCase {
        return AddToFavoriteUseCase(repository)
    }
}