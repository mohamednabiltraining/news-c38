package com.route.newsappc38sat.ui.home.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.api.model.newsResponse.News
import com.data.api.model.newsResponse.NewsResponse
import com.data.api.model.sourcesResponse.Source
import com.data.api.model.sourcesResponse.SourcesResponse
import com.data.repository.NewsOfflineDataSource
import com.google.gson.Gson
import com.route.dataSource.NewsDataSource
import com.route.newsappc38sat.ui.ViewError
import com.route.repository.news.NewsRepository
import com.route.repository.sourcesRepository.SourcesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val sourcesRepo: SourcesRepository,
    private val newsRepository: NewsRepository,
    @NewsOfflineDataSource
    private val newsOfflineDataSource: NewsDataSource
) : ViewModel() {
    val shouldShowLoading = MutableLiveData<Boolean>()
    val sourcesLiveData = MutableLiveData<List<Source?>?>()
    val newsLiveData = MutableLiveData<List<News?>?>()
    val errorLiveData = MutableLiveData<ViewError>()

    fun getNewsSources() {
        viewModelScope.launch {
            shouldShowLoading.postValue(true)
            try {
                val sources = sourcesRepo.getSources()
                sourcesLiveData.postValue(sources)
            } catch (e: HttpException) {
                val errorBodyJsonString = e.response()?.errorBody()?.string()
                val response =
                    Gson().fromJson(errorBodyJsonString, SourcesResponse::class.java)
                errorLiveData.postValue(ViewError(
                    message = response.message
                ) {
                    getNewsSources()
                })
            } catch (e: Exception) {
                errorLiveData.postValue(
                    ViewError(
                        throwable = e
                    ) {
                        getNewsSources()
                    }
                )
            } finally {
                shouldShowLoading.postValue(false)
            }

        }
//
    }

    fun getNews(sourceId: String?) {
        shouldShowLoading.postValue(true)
        viewModelScope.launch {
            try {
                val articles = newsRepository.getNews(sourceId ?: "")
                newsLiveData.postValue(articles)

            } catch (ex: HttpException) {
                val responseJsonError = ex.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(responseJsonError, NewsResponse::class.java)
                errorLiveData.postValue(
                    ViewError(
                        message = errorResponse.message
                    ) { getNews(sourceId) }
                )
            } catch (e: Exception) {
                errorLiveData.postValue(
                    ViewError(
                        throwable = e
                    ) { getNews(sourceId) }
                )
            } finally {
                shouldShowLoading.postValue(false)
            }
        }
    }


}