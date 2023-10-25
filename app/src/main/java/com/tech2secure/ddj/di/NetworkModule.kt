package com.tech2secure.ddj.di

import com.tech2secure.ddj.data.repositories.ShopRepo
import com.tech2secure.ddj.data.repositories.ShopRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideShopRepo(): ShopRepo {
        return ShopRepoImpl()
    }
}