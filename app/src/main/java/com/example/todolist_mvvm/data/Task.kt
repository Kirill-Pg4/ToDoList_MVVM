package com.example.todolist_mvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity(tableName = "task_table")
data class Task(
    var name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) {

    val createdDateFormatted: String
        get() = DateFormat.getDateInstance().format(created)

}