package com.home.feeds.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.feeds.FeedRepository
import com.home.feeds.dataclasses.Comment
import com.home.feeds.dataclasses.FeedPost
import kotlinx.coroutines.launch

class CommentViewModel(val feedPostIndex: Int) : ViewModel() {
    val commentsState: MutableState<List<Comment>> = mutableStateOf(emptyList())
    val feedPostState: MutableState<FeedPost> =
        mutableStateOf(FeedRepository.getPostAt(feedPostIndex))

    init {
        viewModelScope.launch {
            feedPostState.value = getFeedPost()
            commentsState.value = fetchComments()
        }
    }

    fun getFeedPost(): FeedPost {
        return FeedRepository.getPostAt(feedPostIndex)
    }

    fun fetchComments(): List<Comment> {
        return FeedRepository.getComments()
    }
}