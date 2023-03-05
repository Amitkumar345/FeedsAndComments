package com.home.feeds

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.home.feeds.dataclasses.FeedPost
import com.home.feeds.utils.Constants

class FeedPagingSource : PagingSource<Int, FeedPost>() {
    override fun getRefreshKey(state: PagingState<Int, FeedPost>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FeedPost> {
        // if key is null, so fetch 1st page
        val page = params.key ?: 1
        val response = FeedRepository.getListOfPost(page, Constants.PAGE_SIZE)
        return LoadResult.Page(
            data = response.feedPosts,
            prevKey = if (response.page > 1) response.page - 1 else null,
            nextKey = if (response.feedPosts.isNotEmpty()) response.page + 1 else null
        )
    }
}