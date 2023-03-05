package com.home.feeds

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.home.feeds.composables.*
import com.home.feeds.dataclasses.Comment
import com.home.feeds.utils.Screen
import com.home.feeds.view_model.CommentViewModel
import com.home.feeds.view_model.CommentViewModelFactory

@Composable
fun CommentScreen(navController: NavController, id: Int = 0) {
    val viewModel: CommentViewModel = viewModel(factory = CommentViewModelFactory(id))

    // getting data for comment screen
    val feedPost = viewModel.feedPostState.value
    val comments = viewModel.commentsState.value

    // Creating UI
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            // Post Content and Author information
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Text(text = "Comments", fontSize = 16.sp, modifier = Modifier.padding(5.dp))
            }
            PostContent(feedPost = feedPost, route = Screen.Comments.route)

            // Comment List View
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .padding(vertical = 2.dp, horizontal = 5.dp)
            ) {
                items(items = comments) { comment ->
                    CommentItem(comment = comment)
                }
            }
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Row {
                PersonImage(comment.author)
                Column(modifier = Modifier.weight(1f)) {
                    PersonName(comment.author.name)
                    SmallText("Public")
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_more_vert),
                    contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            CommentText(comment.text)
            Row {
                Image(
                    painter = painterResource(id = if (comment.isLiked) R.drawable.ic_liked else R.drawable.ic_like),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(3.dp)
                        .scale(0.7f)
                )
                Text(
                    text = "Like",
                    color = if (comment.isLiked) colorResource(id = R.color.light_blue) else Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CommentScreenPreview() {
    CommentScreen(navController = rememberNavController())
}