package com.data.dataSource

import com.data.api.model.newsResponse.News
import com.route.dataSource.NewsDataSource
import javax.inject.Inject

class NewsOfflineDataSourceImpl @Inject constructor() : NewsDataSource {
    override suspend fun getNews(sourceId: String): List<News?>? {
        return listOf()
    }
}