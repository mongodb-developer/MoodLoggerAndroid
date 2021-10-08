package com.mongodb.flashcards.moodlogger.model

import java.util.Date

interface Entry {
    var mood: Mood
    var date: Date
}
