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
fun SeguimientoScreen(
    siniestroId: String,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = onVolver) {
            Text(text = "Volver")
        }

        Text(text = "Seguimiento")
        Text(text = siniestroId)
        Text(text = "Recibido")
        Text(text = "En evaluación")
        Text(text = "En liquidación")
        Text(text = "Cerrado")
    }
}
