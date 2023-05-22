package com.example.todolist_mvvm.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.transition.Visibility.Mode
import com.example.todolist_mvvm.data.Task
import com.example.todolist_mvvm.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase( app:Application, callback: TaskDatabase.Callback ):TaskDatabase{
       return Room.databaseBuilder(app,TaskDatabase::class.java,"task_database")
           .fallbackToDestructiveMigration()
           .addCallback(callback)
           .build()
    }

    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

    @AppliicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppliicationScope