package com.mongodb.moodlogger.domain

import java.util.Date

data class Entry(
    var mood: Mood,
    var date: Date
)
