package com.route.repository.sourcesRepository

import com.data.api.model.sourcesResponse.Source

interface SourcesRepository {
    suspend fun getSources(): List<Source?>?
}