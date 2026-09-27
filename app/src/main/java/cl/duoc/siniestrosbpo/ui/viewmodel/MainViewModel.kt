package cl.duoc.siniestrosbpo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class MainUiState(
    val idSiniestro: String = ""
)

class MainViewModel : ViewModel() {

    var uiState by mutableStateOf(MainUiState())
        private set

    fun actualizarIdSiniestro(valor: String) {
        uiState = uiState.copy(idSiniestro = valor)
    }
}
