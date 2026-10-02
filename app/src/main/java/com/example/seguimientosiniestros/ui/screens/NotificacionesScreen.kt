package com.example.seguimientosiniestros.ui.screens

import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa

@Composable
fun NotificacionesScreen(
    onVolver: () -> Unit
) {
    PantallaBase(
        titulo = "Notificaciones",
        subtitulo = "Cambios relevantes asociados a tus siniestros.",
        onVolver = onVolver
    ) {
        TarjetaInformativa(
            titulo = "Sin notificaciones nuevas",
            descripcion = "Cuando exista un cambio importante en un siniestro, aparecerá en esta sección."
        )
    }
}
