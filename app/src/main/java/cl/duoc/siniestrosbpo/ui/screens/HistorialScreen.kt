package cl.duoc.siniestrosbpo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.siniestrosbpo.domain.model.GestionHistorial

@Composable
fun HistorialScreen(
    historial: List<GestionHistorial>,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Historial",
            style = MaterialTheme.typography.headlineMedium
        )

        if (historial.isEmpty()) {
            Text(
                text = "No hay gestiones disponibles.",
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            historial.forEach { gestion ->
                Text(
                    text = gestion.fechaHora,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = gestion.descripcion,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Volver")
        }
    }
}
