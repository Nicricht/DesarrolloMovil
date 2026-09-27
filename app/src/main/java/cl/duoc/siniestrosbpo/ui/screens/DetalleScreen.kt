package cl.duoc.siniestrosbpo.ui.screens

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
    idSiniestro: String,
    onSeguimiento: () -> Unit,
    onHistorial: () -> Unit,
    onEvidencias: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Detalle del siniestro")
        Text(
            text = if (idSiniestro.isBlank()) "SIN-2026-001" else idSiniestro,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        Button(onClick = onSeguimiento) {
            Text("Ver seguimiento")
        }

        Button(
            onClick = onHistorial,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Ver historial")
        }

        Button(
            onClick = onEvidencias,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Ver evidencias")
        }

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Volver")
        }
    }
}
