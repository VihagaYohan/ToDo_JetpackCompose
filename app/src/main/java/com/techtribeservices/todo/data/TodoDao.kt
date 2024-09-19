package com.techtribeservices.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.techtribeservices.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    // get all tasks by ascending order
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks():Flow<List<TodoTask>>

    // get a task by id
    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId:Int):Flow<TodoTask>

    // add new task
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask:TodoTask)

    // update task
    @Update
    suspend fun updateTask(todoTask: TodoTask)

    // delete task
    @Delete
    suspend fun deleteTask(todoTask:TodoTask)

    // delete all tasks
    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    // search item
    @Query("SELECT * FROM todo_table WHERE title LIKE:searchQuery OR description LIKE:searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 2 END")
    fun sortByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 2 END")
    fun sortByHighPriority(): Flow<List<TodoTask>>
}