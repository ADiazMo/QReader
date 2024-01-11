package com.chiky.qreader.ui.viewModel

// SplashScreenViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    // Example function to simulate some loading process
    fun performSplashScreenTask(onTaskComplete: () -> Unit) {
        viewModelScope.launch {
            // Simulate some background task
            delay(3000) // 3 seconds delay

            // Task completed, notify the caller
            onTaskComplete.invoke()
        }
    }
}