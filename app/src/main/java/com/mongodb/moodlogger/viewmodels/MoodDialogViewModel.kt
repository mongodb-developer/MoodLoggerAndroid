package com.mongodb.moodlogger.viewmodels

import com.mongodb.moodlogger.data.Repository
import com.mongodb.moodlogger.domain.Entry
import com.mongodb.moodlogger.domain.Mood
import java.util.Date

class MoodDialogViewModel(private val repository: Repository<Entry>) {
    fun onHappyButton() {
        repository.add(entity = Entry(mood = Mood.HAPPY, date = Date())) { result ->
            result.onFailure { println("ERROR: something failed while adding an entry.") }
        }
    }

    fun onNeutralButton() {
        repository.add(entity = Entry(mood = Mood.NEUTRAL, date = Date())) { result ->
            result.onFailure { println("ERROR: something failed while adding an entry.") }
        }
    }

    fun onSadButton() {
        repository.add(entity = Entry(mood = Mood.SAD, date = Date())) { result ->
            result.onFailure { println("ERROR: something failed while adding an entry.") }
        }
    }
}
