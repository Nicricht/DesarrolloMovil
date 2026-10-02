package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetalleScreen(
    siniestroId: String,
    onVolver: () -> Unit,
    onSeguimiento: () -> Unit,
    onHistorial: () -> Unit,
    onEvidencias: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = onVolver) {
            Text(text = "Volver")
        }

        Text(text = "Detalle del siniestro")
        Text(text = siniestroId)

        Button(onClick = onSeguimiento) {
            Text(text = "Ver seguimiento")
        }

        Button(onClick = onHistorial) {
            Text(text = "Ver historial")
        }

        Button(onClick = onEvidencias) {
            Text(text = "Ver evidencias")
        }
    }
}
