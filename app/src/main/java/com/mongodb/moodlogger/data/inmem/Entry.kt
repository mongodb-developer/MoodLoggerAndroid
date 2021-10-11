package com.mongodb.moodlogger.data.inmem

import com.mongodb.moodlogger.domain.Mood
import java.util.Date
import com.mongodb.moodlogger.domain.Entry as EntryDomain

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
