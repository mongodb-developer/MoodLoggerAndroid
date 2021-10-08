package com.mongodb.flashcards.moodlogger.data

interface Repository<Entity> {
    fun getAll(completion: (Result<List<Entity>>) -> Unit)
    fun add(entity: Entity, completion: (Result<Unit>) -> Unit)
}
