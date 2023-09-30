package com.data.api

import com.data.api.model.newsResponse.NewsResponse
import com.data.api.model.sourcesResponse.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

//apiKey=5909ae28122a471d8b0c237d5989cb73
interface WebServices {
    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") key: String = ApiConstants.apiKey
    ): SourcesResponse

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") key: String = ApiConstants.apiKey,
        @Query("sources") sources: String
    ): NewsResponse


}