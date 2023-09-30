package com.data.repository

import com.data.api.model.sourcesResponse.Source
import com.route.dataSource.SourcesDataSource
import com.route.repository.sourcesRepository.SourcesRepository
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(private val sourcesOnlineDataSource: SourcesDataSource) :
    SourcesRepository {
    override suspend fun getSources(): List<Source?>? {
        val sources = sourcesOnlineDataSource.getSources()
//        offlineDataSource.cacheSources(sources)
        return sources
    }
}