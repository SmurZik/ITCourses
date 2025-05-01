package com.smurzik.itcourses

import com.smurzik.courses_api.CoursesApi
import com.smurzik.courses_data.CoursesRepository
import com.smurzik.home.domain.GetCoursesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideCoursesRepository(api: CoursesApi): CoursesRepository {
        return CoursesRepository(api)
    }

    @Provides
    fun provideGetCoursesUseCase(repository: CoursesRepository): GetCoursesUseCase {
        return GetCoursesUseCase(repository)
    }
}