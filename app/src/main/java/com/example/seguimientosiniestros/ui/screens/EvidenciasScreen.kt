package com.example.seguimientosiniestros.ui.screens

import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa

@Composable
fun EvidenciasScreen(
    siniestroId: String,
    onVolver: () -> Unit
) {
    PantallaBase(
        titulo = "Evidencias",
        subtitulo = siniestroId,
        onVolver = onVolver
    ) {
        TarjetaInformativa(
            titulo = "Sin evidencias",
            descripcion = "Las imágenes y documentos asociados al caso se mostrarán en esta sección."
        )
    }
}
