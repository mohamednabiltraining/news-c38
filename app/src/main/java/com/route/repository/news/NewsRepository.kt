package com.route.repository.news

import com.data.api.model.newsResponse.News

interface NewsRepository {
    suspend fun getNews(sourceId: String): List<News?>?
}