package com.tech2secure.ddj.di

import com.tech2secure.ddj.data.repositories.UserRepo
import com.tech2secure.ddj.data.repositories.UserRepoImpl
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
    fun provideUserRepo(): UserRepo {
        return UserRepoImpl()
    }
}