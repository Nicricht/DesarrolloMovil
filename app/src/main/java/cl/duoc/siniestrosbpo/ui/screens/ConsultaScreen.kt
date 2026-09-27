package cl.duoc.siniestrosbpo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConsultaScreen(
    idSiniestro: String,
    mensajeError: String?,
    onIdChange: (String) -> Unit,
    onBuscar: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Consultar siniestro",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Para la demo puedes usar SIN-2026-001.",
            modifier = Modifier.padding(top = 8.dp)
        )

        OutlinedTextField(
            value = idSiniestro,
            onValueChange = onIdChange,
            label = { Text("Identificador") },
            placeholder = { Text("SIN-2026-001") },
            singleLine = true,
            modifier = Modifier.padding(top = 16.dp)
        )

        if (mensajeError != null) {
            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Button(
            onClick = onBuscar,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buscar")
        }

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Volver")
        }
    }
}
