package com.example.seguimientosiniestros.ui.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa
import com.example.seguimientosiniestros.ui.viewmodel.MainUiState

@Composable
fun HistorialScreen(
    siniestroId: String,
    uiState: MainUiState,
    onCargar: () -> Unit,
    onVolver: () -> Unit
) {
    LaunchedEffect(siniestroId) {
        if (uiState.siniestro?.id != siniestroId) {
            onCargar()
        }
    }

    PantallaBase(
        titulo = "Historial",
        subtitulo = siniestroId,
        onVolver = onVolver
    ) {
        when {
            uiState.cargando -> CircularProgressIndicator()

            uiState.mensajeError != null -> TarjetaInformativa(
                titulo = "No disponible",
                descripcion = uiState.mensajeError
            )

            uiState.historial.isEmpty() -> TarjetaInformativa(
                titulo = "Sin gestiones",
                descripcion = "Todavía no hay movimientos registrados para este siniestro."
            )

            else -> uiState.historial.forEach { gestion ->
                TarjetaInformativa(
                    titulo = gestion.fechaHora.replace("T", " · "),
                    descripcion = buildString {
                        append(gestion.descripcion)
                        gestion.estadoResultante?.let {
                            append("\nEstado: ")
                            append(
                                when (it) {
                                    com.example.seguimientosiniestros.domain.model.EstadoSiniestro.RECIBIDO -> "Recibido"
                                    com.example.seguimientosiniestros.domain.model.EstadoSiniestro.EN_EVALUACION -> "En evaluación"
                                    com.example.seguimientosiniestros.domain.model.EstadoSiniestro.EN_LIQUIDACION -> "En liquidación"
                                    com.example.seguimientosiniestros.domain.model.EstadoSiniestro.CERRADO -> "Cerrado"
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}
