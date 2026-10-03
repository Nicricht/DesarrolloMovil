package com.example.seguimientosiniestros.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository

class MainViewModelFactory(
    private val repository: SiniestroRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("ViewModel no soportado: ${modelClass.name}")
    }
}
