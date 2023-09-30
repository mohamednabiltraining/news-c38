package com.route.dataSource

import com.data.api.model.newsResponse.News

interface NewsDataSource {
    suspend fun getNews(sourceId: String): List<News?>?
}