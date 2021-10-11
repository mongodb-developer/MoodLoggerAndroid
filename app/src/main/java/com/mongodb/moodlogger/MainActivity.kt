package com.mongodb.moodlogger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.mongodb.moodlogger.data.inmem.InMemRepository
import com.mongodb.moodlogger.ui.theme.MoodLoggerTheme
import com.mongodb.moodlogger.viewmodels.EntriesListViewModel
import com.mongodb.moodlogger.views.EntriesListView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodLoggerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    EntriesListView(viewModel = EntriesListViewModel(InMemRepository()))
                }
            }
        }
    }
}
