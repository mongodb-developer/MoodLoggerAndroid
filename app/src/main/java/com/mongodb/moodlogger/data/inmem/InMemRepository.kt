package com.mongodb.moodlogger.data.inmem

import com.mongodb.moodlogger.data.Repository
import com.mongodb.moodlogger.data.RepositoryObserver
import com.mongodb.moodlogger.domain.Mood
import java.util.Date
import com.mongodb.moodlogger.domain.Entry as EntryModel

class InMemRepository : Repository<EntryModel> {
    private var entries: ArrayList<Entry> = arrayListOf(
        Entry(Mood.HAPPY, Date()),
        Entry(Mood.SAD, Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L)),
    )
    private var observer: RepositoryObserver? = null

    override fun getAll(completion: (Result<List<EntryModel>>) -> Unit) {
        completion(Result.success(entries.map { it.toDomain() }))
    }

    override fun add(entity: EntryModel, completion: (Result<Unit>) -> Unit) {
        entries.add(Entry(domainEntry = entity))
        completion(Result.success(Unit))
        observer?.update()
    }

    override fun observe(observer: RepositoryObserver) {
        this.observer = observer
    }
}
