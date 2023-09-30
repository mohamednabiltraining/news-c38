package com.data.repository

import com.data.api.model.newsResponse.News
import com.route.dataSource.NewsDataSource
import com.route.repository.news.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    @NewsOnlineDataSource
    private val dataSource: NewsDataSource
) : NewsRepository {
    override suspend fun getNews(sourceId: String): List<News?>? {
        return dataSource.getNews(sourceId)
    }
}