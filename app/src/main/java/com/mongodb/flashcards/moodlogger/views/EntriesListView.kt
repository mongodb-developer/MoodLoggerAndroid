package com.mongodb.flashcards.moodlogger.views

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.mongodb.flashcards.moodlogger.ui.theme.MoodLoggerTheme

@Composable
fun EntriesListView() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = { AppToolbar(title = "Mood Logger") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {
        if (showDialog) {
            MoodDialog()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EntriesListViewPreview() {
    MoodLoggerTheme {
        EntriesListView()
    }
}
