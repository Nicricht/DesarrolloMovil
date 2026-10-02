package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.ui.components.EstadoSiniestroChip
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.theme.Dimens

@Composable
fun SeguimientoScreen(
    siniestroId: String,
    onVolver: () -> Unit
) {
    PantallaBase(
        titulo = "Seguimiento",
        subtitulo = siniestroId,
        onVolver = onVolver
    ) {
        Text(
            text = "Etapas del proceso",
            style = MaterialTheme.typography.titleMedium
        )

        Column(verticalArrangement = Arrangement.spacedBy(Dimens.espacioSm)) {
            EstadoSiniestro.entries.forEach { estado ->
                EstadoSiniestroChip(estado = estado)
            }
        }

        Text(
            text = "El estado actual se destacará cuando la pantalla reciba los datos del siniestro.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
