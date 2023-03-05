package com.home.feeds

import com.home.feeds.dataclasses.*
import com.home.feeds.utils.Constants
import kotlinx.coroutines.delay

class FeedRepository {
    companion object {
        suspend fun getListOfPost(page: Int, limit: Int): FeedsResponse {
            /* //to test page loading by pages
            delay(2000) */

            val list = mutableListOf<FeedPost>()
            for (i in 1..limit) {
                val person = Person("Ayush Agrawal", "")
                val postContent = PostContent(
                    if (i % 2 == 0) PostType.QUESTION else PostType.MARKETING,
                    Constants.POST_TEXT,
                    ""
                )
                list.add(FeedPost(i, person, postContent, i * 10, (i * 54) % 100))
            }
            return FeedsResponse(list, page, limit)
        }

        fun getPostAt(id: Int): FeedPost {
            val person = Person("Ayush Agrawal", "")
            val postContent = PostContent(PostType.QUESTION, Constants.POST_TEXT, "")
            return FeedPost(id, person, postContent, id * 10, (id * 54) % 100)
        }

        fun getComments(): List<Comment> {
            // Sending same created list of comments
            var list = mutableListOf<Comment>()
            for (i in 1..20) {
                val person = Person("Amar Singh", "")
                list.add(Comment(person, Constants.COMMENT, i % 3 == 2))
            }
            return list
        }
    }
}