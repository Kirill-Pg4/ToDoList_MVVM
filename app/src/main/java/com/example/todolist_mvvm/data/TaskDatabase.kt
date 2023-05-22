package com.example.todolist_mvvm.data

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todolist_mvvm.di.AppliicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Qualifier


@Database(entities = [Task::class], version = 1, )
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @AppliicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Play"))
                dao.insert(Task("Watch Video"))
                dao.insert(Task("Eat", completed = true))
                dao.insert(Task("Coding in Android Studio",important = true))
                dao.insert(Task("Eat"))
                dao.insert(Task("Wash the dishes", completed = true))
                dao.insert(Task("Sleep"))

            }

        }

    }
}
