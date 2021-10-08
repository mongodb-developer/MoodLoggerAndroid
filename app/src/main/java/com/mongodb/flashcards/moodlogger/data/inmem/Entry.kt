package com.mongodb.flashcards.moodlogger.data.inmem

import com.mongodb.flashcards.moodlogger.domain.Mood
import java.util.Date
import com.mongodb.flashcards.moodlogger.domain.Entry as EntryDomain

data class Entry(
    var mood: Mood,
    var date: Date
) {
    constructor(domainEntry: EntryDomain) : this(
        mood = domainEntry.mood,
        date = domainEntry.date
    )
    fun toDomain() = EntryDomain(mood = mood, date = date)
}
