package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(
    onConsultar: () -> Unit,
    onNotificaciones: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Seguimiento de Siniestros")
        Text(text = "Consulta el estado de tus siniestros de forma simple.")

        Button(onClick = onConsultar) {
            Text(text = "Consultar siniestro")
        }

        Button(onClick = onNotificaciones) {
            Text(text = "Notificaciones")
        }
    }
}
