package com.home.feeds.dataclasses

data class Comment(val author: Person, val text: String, var isLiked: Boolean = false)
