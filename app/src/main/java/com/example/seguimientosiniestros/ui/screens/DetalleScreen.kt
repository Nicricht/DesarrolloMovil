package com.example.seguimientosiniestros.ui.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.seguimientosiniestros.ui.components.BotonPrincipal
import com.example.seguimientosiniestros.ui.components.EstadoSiniestroChip
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa
import com.example.seguimientosiniestros.ui.viewmodel.MainUiState

@Composable
fun DetalleScreen(
    siniestroId: String,
    uiState: MainUiState,
    onCargar: () -> Unit,
    onVolver: () -> Unit,
    onSeguimiento: () -> Unit,
    onHistorial: () -> Unit,
    onEvidencias: () -> Unit
) {
    LaunchedEffect(siniestroId) {
        onCargar()
    }

    PantallaBase(
        titulo = "Detalle del siniestro",
        subtitulo = "Resumen del caso consultado.",
        onVolver = onVolver
    ) {
        Text(
            text = siniestroId,
            style = MaterialTheme.typography.titleLarge
        )

        when {
            uiState.cargando -> CircularProgressIndicator()

            uiState.mensajeError != null -> TarjetaInformativa(
                titulo = "Siniestro no encontrado",
                descripcion = uiState.mensajeError
            )

            uiState.siniestro != null -> {
                val siniestro = uiState.siniestro

                EstadoSiniestroChip(estado = siniestro.estado)

                TarjetaInformativa(
                    titulo = siniestro.tipo,
                    descripcion = buildString {
                        appendLine("Fecha de ocurrencia: ${siniestro.fechaOcurrencia}")
                        appendLine("Fecha de reporte: ${siniestro.fechaReporte}")
                        append("Equipo asignado: ${siniestro.equipoAsignado ?: "Sin asignar"}")
                    }
                )

                BotonPrincipal("Ver seguimiento", onSeguimiento)
                BotonPrincipal("Ver historial", onHistorial)
                BotonPrincipal("Ver evidencias", onEvidencias)
            }
        }
    }
}
