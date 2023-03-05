package com.home.feeds

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.home.feeds.utils.COMMENT_ARGUMENT_KEY
import com.home.feeds.utils.Screen

/**
 * For Navigation between Screens
 */
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Feeds.route
    ) {
        composable(route = Screen.Feeds.route) {
            FeedScreen(navController)
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(navArgument(COMMENT_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            var id = 0
            it.arguments?.let { itt ->
                id = itt.getInt(COMMENT_ARGUMENT_KEY)
            }
            CommentScreen(navController, id)
        }
    }
}