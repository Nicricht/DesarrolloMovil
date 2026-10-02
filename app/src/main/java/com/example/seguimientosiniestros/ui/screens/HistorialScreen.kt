package com.example.seguimientosiniestros.ui.screens

import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa

@Composable
fun HistorialScreen(
    siniestroId: String,
    onVolver: () -> Unit
) {
    PantallaBase(
        titulo = "Historial",
        subtitulo = siniestroId,
        onVolver = onVolver
    ) {
        TarjetaInformativa(
            titulo = "Sin gestiones cargadas",
            descripcion = "Las gestiones aparecerán aquí cuando se conecte el historial del repositorio."
        )
    }
}
