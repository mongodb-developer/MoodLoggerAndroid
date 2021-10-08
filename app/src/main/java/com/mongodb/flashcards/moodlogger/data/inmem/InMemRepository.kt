package com.mongodb.flashcards.moodlogger.data.inmem

import com.mongodb.flashcards.moodlogger.data.Repository
import com.mongodb.flashcards.moodlogger.model.Mood
import java.util.Date
import com.mongodb.flashcards.moodlogger.model.Entry as EntryModel

class InMemRepository : Repository<EntryModel> {
    private var entries: List<EntryModel> = listOf(
        Entry(Mood.HAPPY, Date()),
        Entry(Mood.SAD, Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L)),
    )

    override fun getAll(completion: (Result<List<EntryModel>>) -> Unit) {
        completion(Result.success(entries))
    }

    override fun add(entity: EntryModel, completion: (Result<Unit>) -> Unit) {
        TODO("Not yet implemented")
    }
}
