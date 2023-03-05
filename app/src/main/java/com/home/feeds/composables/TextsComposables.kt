package com.home.feeds.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.feeds.R


@Composable
fun SmallText(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        color = Color.Black,
        modifier = Modifier.padding(horizontal = 5.dp)
    )
}

@Composable
fun BlueBackgroundText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 15.sp,
        modifier = Modifier
            .background(colorResource(id = R.color.light_blue_bg))
            .padding(horizontal = 5.dp, vertical = 2.dp)
    )
}

@Composable
fun CommentText(text: String) {
    ContentText(text = text, fontSize = 13.sp)
}

@Composable
fun ContentText(text: String, fontSize: TextUnit) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = fontSize,
        color = Color.Black,
        text = text
    )
}

@Composable
fun PostInfoText(text: String) {
    Text(
        text = text, color = Color.Black,
        fontSize = 14.sp
    )
}