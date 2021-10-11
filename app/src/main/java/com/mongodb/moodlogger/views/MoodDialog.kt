package com.mongodb.moodlogger.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mongodb.moodlogger.viewmodels.MoodDialogViewModel

@Composable
fun MoodDialog(viewModel: MoodDialogViewModel, onShowChange: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = { /*TODO*/ }
    ) {
        Surface(
            modifier = Modifier.requiredWidth(LocalConfiguration.current.screenWidthDp.dp * 0.96f),
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colors.background
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "Choose your mood",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(
                        horizontal = 0.dp,
                        vertical = 8.dp
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        viewModel.onHappyButton()
                        onShowChange(false)
                    }) {
                        Text(text = "😃")
                    }
                    Button(onClick = {
                        viewModel.onNeutralButton()
                        onShowChange(false)
                    }) {
                        Text(text = "😑")
                    }
                    Button(onClick = {
                        viewModel.onSadButton()
                        onShowChange(false)
                    }) {
                        Text(text = "🙁")
                    }
                }
            }
        }
    }
}

// @Preview
// @Composable
// fun MoodDialogPreview() {
//     MoodLoggerTheme {
//         MoodDialog(viewModel = MoodDialogViewModel(), onShowChange = {})
//     }
// }
