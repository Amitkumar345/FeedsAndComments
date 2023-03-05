package com.home.feeds.dataclasses

data class FeedPost(
    val id: Int,
    val author: Person,
    val postContent: PostContent,
    val countOfLike: Int,
    val countOfComments: Int
)