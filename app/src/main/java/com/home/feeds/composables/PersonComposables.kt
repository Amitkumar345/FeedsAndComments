package com.home.feeds.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.feeds.R
import com.home.feeds.dataclasses.Person


@Composable
fun PersonImage(person: Person) {
    Image(
        painter = painterResource(id = R.drawable.display_pic),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(50.dp)
            .padding(2.dp)
            .clip(CircleShape)
    )
}

@Composable
fun PersonName(name: String) {
    Text(
        text = name,
        color = Color.Black,
        fontSize = 16.sp,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
    )
}
