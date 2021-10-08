package com.mongodb.flashcards.moodlogger.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mongodb.flashcards.moodlogger.data.Repository
import com.mongodb.flashcards.moodlogger.model.Entry

class EntriesListViewModel(repository: Repository<Entry>) {
    private var _entries = MutableLiveData<List<Entry>>(listOf())
    val entries: LiveData<List<Entry>>
        get() = _entries

    init {
        repository.getAll { result ->
            result
                .onSuccess { entries -> _entries.value = entries }
        }
    }

    fun onAddButton() {
    }
}
