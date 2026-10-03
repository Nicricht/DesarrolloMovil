package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.ui.components.EstadoSiniestroChip
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa
import com.example.seguimientosiniestros.ui.theme.Dimens
import com.example.seguimientosiniestros.ui.viewmodel.MainUiState

@Composable
fun SeguimientoScreen(
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
        titulo = "Seguimiento",
        subtitulo = siniestroId,
        onVolver = onVolver
    ) {
        when {
            uiState.cargando -> CircularProgressIndicator()

            uiState.mensajeError != null -> TarjetaInformativa(
                titulo = "No disponible",
                descripcion = uiState.mensajeError
            )

            uiState.siniestro != null -> {
                val estadoActual = uiState.siniestro.estado

                Text(
                    text = "Etapas del proceso",
                    style = MaterialTheme.typography.titleMedium
                )

                Column(verticalArrangement = Arrangement.spacedBy(Dimens.espacioSm)) {
                    EstadoSiniestro.entries.forEach { estado ->
                        Row(horizontalArrangement = Arrangement.spacedBy(Dimens.espacioSm)) {
                            Text(
                                text = if (estado.ordinal <= estadoActual.ordinal) "✓" else "○"
                            )
                            EstadoSiniestroChip(estado = estado)
                            if (estado == estadoActual) {
                                Text(text = "Actual")
                            }
                        }
                    }
                }
            }
        }
    }
}
