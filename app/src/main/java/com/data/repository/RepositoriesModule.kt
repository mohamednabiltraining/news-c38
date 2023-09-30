package com.data.repository

import com.data.dataSource.NewsOfflineDataSourceImpl
import com.data.dataSource.NewsOnlineDataSourceImpl
import com.data.dataSource.SourcesOnlineDataSourceImpl
import com.route.dataSource.NewsDataSource
import com.route.dataSource.SourcesDataSource
import com.route.repository.news.NewsRepository
import com.route.repository.sourcesRepository.SourcesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideSourcesRepository(
        repo: SourcesRepositoryImpl
    ): SourcesRepository

    @Binds
    abstract fun provideSourcesDataSource(
        dataSource: SourcesOnlineDataSourceImpl
    ): SourcesDataSource

    @NewsOnlineDataSource
    @Binds
    abstract fun provideNewsDataSource(
        dataSourceImpl: NewsOnlineDataSourceImpl
    ): NewsDataSource

    @NewsOfflineDataSource
    @Binds
    abstract fun provideNewsOfflineDataSource(
        dataSourceImpl: NewsOfflineDataSourceImpl
    ): NewsDataSource

    @Binds
    abstract fun provideNewsRepository(
        repo: NewsRepositoryImpl
    ): NewsRepository
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsOfflineDataSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NewsOnlineDataSource