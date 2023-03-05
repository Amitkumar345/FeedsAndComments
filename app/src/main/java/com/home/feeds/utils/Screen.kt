package com.home.feeds.utils

/**
 * KEY for arguments
 */
const val COMMENT_ARGUMENT_KEY = "id"

/**
 * Route for different screen
 */
sealed class Screen(val route: String) {
    object Feeds : Screen(route = "feed_screen")
    object Comments : Screen(route = "comment_screen/{$COMMENT_ARGUMENT_KEY}") {
        fun passId(id: Int): String {
            return this.route.replace(
                oldValue = "{$COMMENT_ARGUMENT_KEY}",
                newValue = id.toString()
            )
        }
    }
}
