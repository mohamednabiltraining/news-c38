package com.data.dataSource

import com.data.api.WebServices
import com.data.api.model.newsResponse.News
import com.route.dataSource.NewsDataSource
import javax.inject.Inject

class NewsOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    NewsDataSource {
    override suspend fun getNews(sourceId: String): List<News?>? {
        val response = webServices.getNews(sources = sourceId)
        return response.articles
    }
}