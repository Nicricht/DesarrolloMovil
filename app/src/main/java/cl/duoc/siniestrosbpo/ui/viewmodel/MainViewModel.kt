package cl.duoc.siniestrosbpo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.duoc.siniestrosbpo.data.repository.FakeSiniestroRepository
import cl.duoc.siniestrosbpo.domain.model.GestionHistorial
import cl.duoc.siniestrosbpo.domain.model.Siniestro
import cl.duoc.siniestrosbpo.domain.repository.SiniestroRepository

data class MainUiState(
    val idSiniestro: String = "",
    val siniestroEncontrado: Siniestro? = null,
    val historial: List<GestionHistorial> = emptyList(),
    val mensajeError: String? = null
)

class MainViewModel(
    private val repository: SiniestroRepository = FakeSiniestroRepository()
) : ViewModel() {

    var uiState by mutableStateOf(MainUiState())
        private set

    fun actualizarIdSiniestro(valor: String) {
        uiState = uiState.copy(
            idSiniestro = valor,
            mensajeError = null
        )
    }

    fun buscarSiniestro(): Boolean {
        val id = uiState.idSiniestro.trim()

        if (id.isBlank()) {
            uiState = uiState.copy(
                siniestroEncontrado = null,
                historial = emptyList(),
                mensajeError = "Ingresa un identificador de siniestro."
            )
            return false
        }

        val siniestro = repository.buscarPorId(id)

        if (siniestro == null) {
            uiState = uiState.copy(
                siniestroEncontrado = null,
                historial = emptyList(),
                mensajeError = "No encontramos ese siniestro ficticio."
            )
            return false
        }

        uiState = uiState.copy(
            idSiniestro = siniestro.id,
            siniestroEncontrado = siniestro,
            historial = repository.obtenerHistorial(siniestro.id),
            mensajeError = null
        )

        return true
    }
}
