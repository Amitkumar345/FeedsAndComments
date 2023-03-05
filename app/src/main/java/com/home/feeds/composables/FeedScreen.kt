package com.home.feeds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.home.feeds.composables.PostContent
import com.home.feeds.dataclasses.FeedPost
import com.home.feeds.utils.Screen
import com.home.feeds.view_model.FeedViewModel

@Composable
fun FeedScreen(navController: NavController) {
    val viewModel: FeedViewModel = viewModel()

    // getting data by page with a limit of 10 items
    val feedPosts = viewModel.feedPager.collectAsLazyPagingItems()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // feed list view
        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .padding(vertical = 2.dp, horizontal = 5.dp)
        ) {
            items(feedPosts) { feedPost ->
                if (feedPost != null) {
                    FeedPostItem(feedPost = feedPost, navController)
                }
            }
        }
    }
}


@Composable
fun FeedPostItem(feedPost: FeedPost, navController: NavController) {
    PostContent(feedPost = feedPost, route = Screen.Feeds.route, navController = navController)
}

@Composable
@Preview(showBackground = true)
fun FeedScreenPreview() {
    FeedScreen(navController = rememberNavController())
}