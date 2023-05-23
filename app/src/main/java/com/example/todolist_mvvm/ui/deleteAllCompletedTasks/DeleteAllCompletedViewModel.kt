package com.example.todolist_mvvm.ui.deleteAllCompletedTasks

import androidx.lifecycle.ViewModel
import com.example.todolist_mvvm.data.TaskDao
import com.example.todolist_mvvm.di.AppliicationScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteAllCompletedViewModel @Inject constructor(
    private val taskDao: TaskDao,
    @AppliicationScope private val applicationScope: CoroutineScope
) : ViewModel() {

    fun onConfirmClick() = applicationScope.launch {
        taskDao.deleteCompletedTasks()
    }
}