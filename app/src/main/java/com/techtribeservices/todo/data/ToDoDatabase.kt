package com.techtribeservices.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techtribeservices.todo.data.models.TodoTask

@Database(
    entities = [TodoTask::class],
    version = 1,
    exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao():TodoDao
}