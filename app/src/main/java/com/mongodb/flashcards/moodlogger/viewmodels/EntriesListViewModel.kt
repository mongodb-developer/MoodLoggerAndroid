package com.mongodb.flashcards.moodlogger.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mongodb.flashcards.moodlogger.data.Repository
import com.mongodb.flashcards.moodlogger.data.RepositoryObserver
import com.mongodb.flashcards.moodlogger.domain.Entry

class EntriesListViewModel(var repository: Repository<Entry>) : RepositoryObserver {

    // <editor-fold desc="Properties">
    private var _entries = MutableLiveData<List<Entry>>(listOf())
    val entries: LiveData<List<Entry>>
        get() = _entries
    // </editor-fold>

    // <editor-fold desc="Events">
    init {
        repository.observe(this)
        repository.getAll { result ->
            result
                .onSuccess { entries -> _entries.value = entries }
        }
    }

    fun onAddButton() {
    }
    // </editor-fold>
    override fun update() {
        repository.getAll { result ->
            result
                .onSuccess { entries -> _entries.value = entries }
        }
    }
}
