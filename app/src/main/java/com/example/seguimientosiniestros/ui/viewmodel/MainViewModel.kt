package com.example.seguimientosiniestros.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seguimientosiniestros.data.demo.DatosDemo
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: SiniestroRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private val inicializacion = viewModelScope.async {
        if (repository.obtenerSiniestro(DatosDemo.SINIESTRO_ID) == null) {
            repository.guardarSiniestro(DatosDemo.siniestro)
            repository.guardarHistorial(DatosDemo.historial)
        }
    }

    fun consultarSiniestro(id: String) {
        val identificador = id.trim().uppercase()

        viewModelScope.launch {
            _uiState.value = MainUiState(cargando = true)

            inicializacion.await()

            val siniestro = repository.obtenerSiniestro(identificador)

            if (siniestro == null) {
                _uiState.value = MainUiState(
                    mensajeError = "No se encontró el siniestro $identificador."
                )
                return@launch
            }

            val historial = repository.obtenerHistorial(identificador)

            _uiState.value = MainUiState(
                siniestro = siniestro,
                historial = historial
            )
        }
    }
}
