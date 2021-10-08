package com.mongodb.flashcards.moodlogger.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mongodb.flashcards.moodlogger.data.inmem.InMemRepository
import com.mongodb.flashcards.moodlogger.domain.Entry
import com.mongodb.flashcards.moodlogger.domain.Mood
import com.mongodb.flashcards.moodlogger.ui.theme.MoodLoggerTheme
import com.mongodb.flashcards.moodlogger.viewmodels.EntriesListViewModel
import com.mongodb.flashcards.moodlogger.viewmodels.MoodDialogViewModel
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun EntriesListView(viewModel: EntriesListViewModel) {
    // <editor-fold desc="State">
    var showDialog by remember {
        mutableStateOf(false)
    }
    // </editor-fold>
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
        EntriesList(viewModel = viewModel)
        if (showDialog) {
            MoodDialog(viewModel = MoodDialogViewModel(viewModel.repository), onShowChange = { showDialog = it })
        }
    }
}

@Composable
fun EntriesList(viewModel: EntriesListViewModel, modifier: Modifier = Modifier) {
    // <editor-fold desc="State">
    val entries by viewModel.entries.observeAsState(listOf())
    // </editor-fold>

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(entries) { entry ->
            EntriesListItem(entry = entry)
            Divider()
        }
    }
}

@Composable
fun EntriesListItem(entry: Entry) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
    ) {
        Text(
            text = entry.moodIcon(),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { entry.dateText() } else { entry.date.toString() },
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.h5
        )
    }
}

fun Entry.moodIcon(): String =
    when (mood) {
        Mood.SAD -> "🙁"
        Mood.NEUTRAL -> "😑"
        Mood.HAPPY -> "🙂"
    }

@RequiresApi(Build.VERSION_CODES.O)
fun Entry.dateText(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm")
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter)
}

@Preview(showBackground = true)
@Composable
fun EntriesListViewPreview() {
    MoodLoggerTheme {
        EntriesListView(viewModel = EntriesListViewModel(repository = InMemRepository()))
    }
}
