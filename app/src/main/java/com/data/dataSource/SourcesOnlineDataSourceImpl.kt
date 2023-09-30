package com.data.dataSource

import com.data.api.WebServices
import com.data.api.model.sourcesResponse.Source
import com.route.dataSource.SourcesDataSource
import javax.inject.Inject

class SourcesOnlineDataSourceImpl @Inject constructor(val webServices: WebServices) :
    SourcesDataSource {
    override suspend fun getSources(): List<Source?>? {
        val response = webServices.getSources()
        return response.sources
    }
}