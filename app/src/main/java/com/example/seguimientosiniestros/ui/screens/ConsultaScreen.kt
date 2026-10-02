package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConsultaScreen(
    onVolver: () -> Unit,
    onBuscar: (String) -> Unit
) {
    var identificador by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = onVolver) {
            Text(text = "Volver")
        }

        Text(text = "Consultar siniestro")

        OutlinedTextField(
            value = identificador,
            onValueChange = { identificador = it },
            label = { Text(text = "Identificador del siniestro") },
            supportingText = { Text(text = "Ejemplo: SIN-2026-001") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onBuscar(identificador.trim()) },
            enabled = identificador.isNotBlank()
        ) {
            Text(text = "Buscar")
        }
    }
}
