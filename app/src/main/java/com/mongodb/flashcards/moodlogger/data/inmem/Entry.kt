package com.mongodb.flashcards.moodlogger.data.inmem

import com.mongodb.flashcards.moodlogger.model.Mood
import java.util.Date
import com.mongodb.flashcards.moodlogger.model.Entry as EntryModel

data class Entry(
    override var mood: Mood,
    override var date: Date
) : EntryModel
