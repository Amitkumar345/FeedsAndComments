package com.home.feeds.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.home.feeds.R
import com.home.feeds.dataclasses.FeedPost
import com.home.feeds.utils.Screen

@Composable
fun PostContent(feedPost: FeedPost, route: String, navController: NavController? = null) {
    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Row {
                PersonImage(person = feedPost.author)
                Column(modifier = Modifier.weight(1f)) {
                    Row {
                        PersonName(feedPost.author.name)
                        BlueBackgroundText(feedPost.postContent.postType.toString())
                    }
                    SmallText("2 hours ago")
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_more_horiz),
                    contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            // post text
            ContentText(text = feedPost.postContent.text, fontSize = 15.sp)

            // for showing post's multimedia or images but currently showing only an image
            Image(
                painter = painterResource(id = R.drawable.scenery), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            if (route == Screen.Comments.route) {
                // For comment screen
                Text(
                    text = AnnotatedString("${feedPost.countOfComments} Comments"),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(10.dp)
                )
            } else if (navController != null) {
                // For feed screen
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        PostInfoIcons(id = R.drawable.ic_like)
                        PostInfoText("${feedPost.countOfLike} likes")
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        PostInfoIcons(id = R.drawable.ic_comment)
                        ClickableText(
                            text = AnnotatedString("${feedPost.countOfComments} comments"),
                            style = TextStyle(color = Color.Black, fontSize = 14.sp), onClick = {
                                // navigating to comment screen with post id as argument
                                navController.navigate(route = Screen.Comments.passId(feedPost.id))
                            }
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        PostInfoIcons(id = R.drawable.ic_share)
                        PostInfoText("Share")
                    }
                }
            }
        }
    }
}

/**
 * To draw UI Images of like, comments, or share
 */
@Composable
fun PostInfoIcons(@DrawableRes id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .padding(3.dp)
            .scale(0.8f)
    )
}
