package com.home.feeds.dataclasses

data class FeedsResponse(
    val feedPosts: List<FeedPost>,
    val page: Int,
    val limit: Int
)
