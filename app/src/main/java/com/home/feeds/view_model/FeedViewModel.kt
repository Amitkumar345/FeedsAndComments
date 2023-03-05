package com.home.feeds.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.home.feeds.FeedPagingSource
import com.home.feeds.FeedRepository
import com.home.feeds.dataclasses.FeedPost
import com.home.feeds.utils.Constants
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    val feedPager = Pager(
        PagingConfig(pageSize = Constants.PAGE_SIZE)
    ) {
        FeedPagingSource()
    }.flow.cachedIn(viewModelScope)

    val feedPostsState: MutableState<List<FeedPost>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            feedPostsState.value = fetchFeedPosts()
        }
    }

    suspend fun fetchFeedPosts(page: Int = 1, limit: Int = Constants.PAGE_SIZE): List<FeedPost> {
        return FeedRepository.getListOfPost(page, limit).feedPosts
    }
}