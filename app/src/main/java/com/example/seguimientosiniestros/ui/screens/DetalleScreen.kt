package com.example.seguimientosiniestros.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.components.BotonPrincipal
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa

@Composable
fun DetalleScreen(
    siniestroId: String,
    onVolver: () -> Unit,
    onSeguimiento: () -> Unit,
    onHistorial: () -> Unit,
    onEvidencias: () -> Unit
) {
    PantallaBase(
        titulo = "Detalle del siniestro",
        subtitulo = "Resumen del caso consultado.",
        onVolver = onVolver
    ) {
        Text(
            text = siniestroId,
            style = MaterialTheme.typography.titleLarge
        )

        TarjetaInformativa(
            titulo = "Información del caso",
            descripcion = "Los datos del siniestro aparecerán aquí cuando la consulta se conecte al repositorio."
        )

        BotonPrincipal("Ver seguimiento", onSeguimiento)
        BotonPrincipal("Ver historial", onHistorial)
        BotonPrincipal("Ver evidencias", onEvidencias)
    }
}
