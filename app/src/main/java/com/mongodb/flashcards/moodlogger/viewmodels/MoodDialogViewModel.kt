package com.mongodb.flashcards.moodlogger.viewmodels

import com.mongodb.flashcards.moodlogger.data.Repository
import com.mongodb.flashcards.moodlogger.domain.Entry
import com.mongodb.flashcards.moodlogger.domain.Mood
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
