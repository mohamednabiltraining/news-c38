package com.route.dataSource

import com.data.api.model.sourcesResponse.Source

interface SourcesDataSource {
    suspend fun getSources(): List<Source?>?
}