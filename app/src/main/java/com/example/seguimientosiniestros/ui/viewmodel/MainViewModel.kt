package com.example.seguimientosiniestros.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: SiniestroRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun consultarSiniestro(id: String) {
        val identificador = id.trim().uppercase()

        viewModelScope.launch {
            _uiState.value = MainUiState(cargando = true)

            try {
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
            } catch (_: Exception) {
                _uiState.value = MainUiState(
                    mensajeError = "No se pudo consultar el siniestro. Revisa la conexión e inténtalo nuevamente."
                )
            }
        }
    }
}
