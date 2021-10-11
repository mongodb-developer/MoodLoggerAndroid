package com.mongodb.moodlogger.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mongodb.moodlogger.ui.theme.MoodLoggerTheme

@Composable
fun AppToolbar(
    title: String,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Start,
                maxLines = 1
            )
        },
        actions = {
            icon()
        }
    )
}

@Preview
@Composable
fun AppToolbarPreview() {
    MoodLoggerTheme() {
        Column {
            AppToolbar(title = "Flash Cards")
        }
    }
}
